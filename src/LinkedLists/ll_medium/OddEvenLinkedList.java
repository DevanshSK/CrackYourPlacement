package LinkedLists.ll_medium;

import java.util.ArrayList;

public class OddEvenLinkedList {

    /**
     * Brute force solution
     * Create a temp array to hold the grouped values.
     * Then Iterate the list 2 times to get odd and even values     O(N/2) * 2
     * Then Reiterate the list to replace values from the array.    O(N)
     *
     * TC: O(2N)
     * SC: O(N)
     * */
    static ListNode bruteforce(ListNode head){
        // Check for empty or list with single node.
        if(head == null || head.next == null)   return head;

        ArrayList<Integer> values = new ArrayList<Integer>();
        ListNode temp = head;

        // Iterate the odd nodes
        while(temp != null && temp.next != null){
            values.add(temp.val);
            temp = temp.next.next;  // Skip nodes by 2
        }
        // Handle the remaining last node.
        if(temp != null) values.add(temp.val);

        // Iterate the Even nodes
        temp = head.next;
        while(temp != null && temp.next != null){
            values.add(temp.val);
            temp = temp.next.next;
        }
        // Handle the remaining node.
        if(temp != null) values.add(temp.val);

        // Reassign values
        int i = 0;
        temp = head;
        while(temp != null){
            temp.val = values.get(i++);
            temp = temp.next;
        }

        return head;
    }


    /**
     * Better Optimized Solution
     * Here we are asked to remove the additional space complexity.
     * It means that we have to do in-place operations inside the LL
     * So we come up with another approach
     *
     * This requires 2 steps to
     *  1. Link together odd nodes seperately.
     *  2. Link together even nodes seperately.
     *
     * Also these can be done inside a single loop iteration.
     * Then, we can link the odd chain with the even chain.
     *
     * TC: O(N/2) * 2 = O(N)
     * SC: O(1)
     * */
    static ListNode optimized(ListNode head){
        // Handle empty and singular list
        if(head == null || head.next == null) return head;

        // Create pointers to store values
        ListNode odd = head, even = head.next, evenNode = head.next;

        // Begin the iteration
        while(even != null && even.next != null){
            // Link the nodes
            odd.next = odd.next.next;
            even.next = even.next.next;

            // move the pointers
            odd = odd.next;
            even = even.next;
        }

        // Link the odd chain to even chain
        odd.next = evenNode;
        return head;
    }
}
