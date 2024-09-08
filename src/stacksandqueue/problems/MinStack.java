package stacksandqueue.problems;

import java.util.Stack;

public class MinStack {
    /**
     *  Q. Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     *      Implement the MinStack class:
     *
     *      MinStack() initializes the stack object.
     *          void push(int val) pushes the element val onto the stack.
     *          void pop() removes the element on the top of the stack.
     *          int top() gets the top element of the stack.
     *          int getMin() retrieves the minimum element in the stack.
     *      You must implement a solution with O(1) time complexity for each function.
     *
     *      ## Bruteforce Solution:
     *      - Scan the stack for the minimum element.
     *
     *
     *      ##  Better Solution: MinStack1
     *      - Store the element and the minimum element upto that point in the stack as a pair.
     *      - Then we can easily get the minimum element by this way.
     *      TC: O(1)
     *      SC: O(2N)
     *
     *      ## Optimal Solution: MinStack2
     *      - Store the minimum value in a single variable.
     *      - But this is a problem. when popping we need get the previous minimum element.
     *      - To do this we have some calculations.
     *      - If we find a new minimum element, we modify it and add it to the stack. And store the minimum.
     *      - And when we get the top, if value is smaller than minimum: Modified -> Recover the original value.
     *      - And when popping get the modified value from stack and update the previous minimum.
     *      TC: O(1)
     *      SC: O(N)
     * */
    private class Pair{
        int first;
        int second;
        Pair(int f, int s){
            this.first = f;
            this.second = s;
        }
    }

    private class MinStack1{
        private Stack<Pair> st = new Stack<>();
        public void push(int x){
            // Check if stack is empty.
            if(st.isEmpty())  st.push(new Pair(x,x));
            else{
                st.push(new Pair(x, Math.min(x, st.peek().second)));
            }
        }
        public int getMin(){
            return st.peek().second;
        }
        public int top(){
            return st.peek().first;
        }
        public void pop(){
            st.pop();
        }
    }

    private class MyStack2{
        private Stack<Long> st = new Stack<>();
        private Long mini = Long.MAX_VALUE;
        public void push(int x){
            long val = x;
            if(st.isEmpty()) {
                mini = val;
                st.push(val);
            }
            else if(val > mini){
                st.push(val);
            }
            else{
                st.push(2*val-mini);
                mini = val;
            }
        }
        public void pop(){
            if(st.isEmpty())  return;
            Long x = st.pop();
            if(x < mini){
                mini = 2 * mini - x;
            }
        }
        public int top(){
            if(st.isEmpty()) return -1;
            Long x = st.peek();
            if(mini > x) return mini.intValue();
            return x.intValue();
        }
        public int getMini(){
            return  mini.intValue();
        }
    }
}
