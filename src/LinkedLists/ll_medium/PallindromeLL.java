package LinkedLists.ll_medium;

import java.util.Stack;

public class PallindromeLL {
    /**
     * Q. 234: Check if a given LL is pallindrome or not.
     *
     * Bruteforce Solution:
     *  1. Store the values in reverse order in a stack.
     *  2. Reiterate and compare the values to the list.
     *  3. If match found then it is a pallindrome.
     *
     *  TC: O(2N)
     *  SC: O(N)
     *
     *
     *  Optimal Solution: Optimize space complexity. Also uses reversal of the linked list.
     *  1. Find the middle of the linked list.
     *  2. Reverse the second half of the Linked list. Then we get head of the second half of LL
     *  3. Iterate and compare the halves of the Linked lists.
     *  4. If values differ -> Not pallindrome or vice versa.
     *  5. Then reverse the second half again before returning. ( NOTE: Necessary as the input data is changed here. )
     *
     *  TC: O(N)
     *  SC: O(1)
     * */

    public boolean brutePallindrome(Node head){
        Stack<Integer> stack = new Stack<Integer>();

        // Storing data in reverse order
        Node temp = head;
        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }

        // Iterating and comparing data to the LL
        temp = head;
        while(temp != null){
            if(temp.data != stack.pop()) return false;

            temp = temp.next;
        }
        return true;
    }

    public static Node reverseLL(Node head){
        // Check if LL is empty
        if(head == null || head.next == null)   return head;

        // Create the null node.
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

    public boolean optimalPallindrome(Node head){
        // Declaring the pointers
        Node slow = head, fast = head;
        // Find the middle of LL : Turtle-Hare algorithm
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Slow is our middle element
        // Reverse the second half of the LL
        Node newHead = reverseLL(slow.next);

        // Declare nodes for comparison
        Node first = head, second = newHead;

        // Iterate and compare to find the pallindrome or not.
        while(second != null){
            // Check if values are same
            if(first.data != second.data){
                // Reverse the LL and return.
                reverseLL(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        // Reverse the LL and return.
        reverseLL(newHead);
        return true;
    }
}
