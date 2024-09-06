package stacksandqueue.problems;

import java.util.Stack;

public class ValidParentheses {
    /**
     *  Q.  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     *      determine if the input string is valid.
     *
     *      # An input string is valid if:
     *      Open brackets must be closed by the same type of brackets.
     *      Open brackets must be closed in the correct order.
     *      Every close bracket has a corresponding open bracket of the same type.
     *
     *
     *      ## Bruteforce Solution:
     *      - We traverse the string char by char and do these checks.
     *      - If char is opening: push it in stack.
     *      - Else then we try to find its opening bracket.
     *          - Stack is empty: Mo opening exists.    -> false.
     *          - last bracket is different type        -> false.
     *          - last bracket is same type: Skip and go to next turn.
     *      - Check if any opening element remains:
     *      - Is stack is empty: opening bracket remains.
     *      - Else return true.
     *      TC: O(N)
     *      SC: O(N)
     * */
    public boolean isValid(String s) {
        // Store opening elements
        Stack<Character> st = new Stack<>();
        // Iterate the string
        for(char el : s.toCharArray()){
            // Check opening bracket
            if(el == '(' || el == '[' || el == '{')
                st.push(el);
            else{
                // Check underflow: No opening found.
                if(st.isEmpty())  return false;
                // Compare and find same last opening bracket
                char ch = st.pop();
                // Check for same type
                if((el == ')' && ch == '(') || (el == ']' && ch == '[') || (el == '}' && ch == '{')){
                    // Same last bracket found.
                    // Go to next element.
                    continue;
                }
                else return false;  // Different bracket found.
            }
        }

        // Check for underflow and return.
        return st.isEmpty();
    }
}
