package stacksandqueue.learning;

import java.util.Stack;

class SQueue2{
    /**
     *  # Here, we need to optimize the push operation less costly.
     *  - ideally used for apps where a lots of push operation are done.
     *  - The pop and top becomes expensive.
     *  - Maintain the reverse order in stack2 and add elements if it is empty.
     *
     *  TC: push: O(1), pop: O(N), peek: O(N), empty: O(1)
     *  SC: O(2 * Dynamic memory)
     * */
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x){
        s1.push(x);
    }

    public int pop(){
        if(!s2.isEmpty()) return s2.pop();
        else {
            // Move s1 into s2
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

    public int top(){
        if(!s2.isEmpty()) return s2.peek();
        else {
            // Move s1 into s2
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}

public class SQueue {
    /**
     * Q.   Implement a first in first out (FIFO) queue using only two stacks.
     *      The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
     *
     *      Implement the MyQueue class:
     *
     *      void push(int x) Pushes element x to the back of the queue.
     *      int pop() Removes the element from the front of the queue and returns it.
     *      int peek() Returns the element at the front of the queue.
     *      boolean empty() Returns true if the queue is empty, false otherwise.
     *
     *
     *      # Solution
     *      - Here, we are using 2 stacks to simulate the behaviour of the queue.
     *      - We only modify the push method for the given stack to behave like queue.
     *      - The process are as follows:
     *          1. Create 2 stacks q and temp.
     *          2. Move elements of q into temp.
     *          3. Add element x into q.
     *          4. Move back temp elements into q.
     *
     *      *  TC: push: O(2N), pop: O(1), peek: O(1), empty: O(1)
     *      *  SC: O(2 * Dynamic memory)
     * **/
    Stack<Integer> q = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    public SQueue() {

    }

    public void push(int x) {
        // Move q into temp
        while(!q.isEmpty()){
            temp.push(q.pop());
        }
        // Insert the element in q
        q.push(x);
        // Move back temp into q
        while(!temp.isEmpty()){
            q.push(temp.pop());
        }
    }

    public int pop() {
        return q.pop();
    }

    public int peek() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
