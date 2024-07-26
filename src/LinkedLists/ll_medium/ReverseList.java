package LinkedLists.ll_medium;

import java.util.Stack;

public class ReverseList {
    /**
     * Q-206. Reverse a linked list provided to the method.
     *
     * Bruteforce: TC: O(2N) and SC: O(N)
     *  1. Iterate and store all values in a stack.
     *  2. Reiterate the stack and update the reversed values of the linked list.
     *
     *
     *  Optimal solution: Reverse the links and reduce sc.
     *  1. Create a prev node to store and manage the previous links. Essentially building the LL from end.
     *
     *  TC: O(N)
     *  SC: O(1)
     *
     *  Recursive approach;
     *  TC: O(N) SC: O(N)
     *  1. Break down the reversing problem and solving only current node and reversing the next LL.
     * */

    public static Node reverseLLBasic(Node head){
        // Check if LL is empty
        if(head == null || head.next == null)   return head;

        // Define a stack
        Stack<Integer> stack = new Stack<Integer>();

        // Iterate and store values in the stack
        Node temp = head;
        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }

        // Reiterate and replace the reversed values from stack
        temp = head;
        while(temp != null){
            temp.data = stack.pop();
            temp = temp.next;
        }

        // Return the updated LL
        return head;
    }

    public static Node reverseOptLL(Node head){
        // Check if LL is empty
        if(head == null || head.next == null)   return head;

        Node prev = null;
        Node temp = head;
        while(temp != null){
            Node nextEl = temp.next;
            // Assign link to previous element.
            temp.next = prev;

            // Updating values
            prev = temp;
            temp = nextEl;
        }

        head = prev;
        return head;
    }

    public static Node reverse(Node head){
        // Base case
        if(head == null || head.next == null) return head;

        // Gather the new reversed LL
        Node newHead = reverse(head.next);

        // Change the links at current level
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}
