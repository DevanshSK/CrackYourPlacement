package stacksandqueue.problems.infixprefixpostfix;

import java.util.Stack;

public class InfixToPostfix {
    public static int priority(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    public static String infixToPostfix(String exp) {

        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(char ch : exp.toCharArray()){
            // Check Operands
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }
            else if (ch == '(') {
                st.push(ch);
            }
            else if(ch == ')'){
                // Put operators until opening bracket
                while(!st.empty() && st.peek() != '(' ){
                    ans.append(st.pop());
                }
                // Remove the opening bracket
                st.pop();
            }
            else{
                // Handle low priority operators
                while(!st.isEmpty() && priority(ch) <= priority(st.peek())){
                    ans.append(st.pop());
                }
                // Add current element in stack
                st.push(ch);
            }
        }

        // Add the rest of operators in stack.
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        // Return the string.
        return ans.toString();
    }

    // Infix to postfix conversion
    public static String infixToPrefix(String exp) {
        // Reverse the string.
        exp = new StringBuilder(exp).reverse().toString();

        // Convert reversed infix with some changes
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(char ch : exp.toCharArray()){
            // Check operand
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }
            else if(ch == ')'){
                // Handle opening
                st.push(ch);
            }
            else if (ch == '(') {
                // Handle closing brackets
                while(!st.isEmpty() && st.peek() != ')'){
                    // Move the element from stack to ans
                    ans.append(st.pop());
                }
                // Remove the opening bracket
                st.pop();
            }
            else{
                // Handles operators
                if(ch == '^'){
                    while(!st.isEmpty() && priority(ch) <= priority(st.peek())){
                        ans.append(st.pop());
                    }
                }
                else{
                    while(!st.isEmpty() && priority(ch) < priority(st.peek())){
                        ans.append(st.pop());
                    }
                }
                st.push(ch);
            }
        }

        // Add the remaining elements in ans
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        // Reverse and return the converted ans.
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        String a = "A*(B+C)/D";
        System.out.println(infixToPrefix(s).equals("-+a*b^-^cde+f*ghi"));
        System.out.println(infixToPrefix(a).equals("/*A+BCD"));
    }

    static String postToInfix(String exp) {
        Stack<String> st = new Stack<>();
        int i = 0;
        while(i < exp.length()){
            // Check for operands
            if(Character.isLetterOrDigit(exp.charAt(i)))    st.push(String.valueOf(exp.charAt(i)));
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String con = "(" + t2 + exp.charAt(i) + t1 + ")";
                st.push(con);
            }
            i++;
        }
        return st.peek();
    }


    static String preToInfix(String s) {
        Stack<String> st = new Stack<>();
        int i = s.length() - 1;
        while(i >= 0){
            // Handle operands
            if(Character.isLetterOrDigit(s.charAt(i)))  st.push(String.valueOf(s.charAt(i)));
            else{
                // Handle operators
                String t1 = st.pop(), t2 = st.pop();
                String con = "(" + t1 + s.charAt(i) + t2 + ")";
                st.push(con);
            }
            i--;
        }
        return st.peek();
    }


    static String postToPre(String s) {
        Stack<String> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch))   st.push(String.valueOf(ch));
            else{
                String t1 = st.pop(), t2 = st.pop();
                String con = ch + t2 + t1;
                st.push(con);
            }
        }
        return st.peek();
    }

    static String preToPost(String s) {
        Stack<String> st = new Stack<>();
        int i = s.length() - 1;
        while(i >= 0){
            // Check operands
            if(Character.isLetterOrDigit(s.charAt(i)))  st.push(String.valueOf(s.charAt(i)));
            else{
                String t1 = st.pop(), t2 = st.pop();
                String con = t1 + t2 + s.charAt(i);
                st.push(con);
            }
            i--;
        }
        return st.peek();
    }
}
