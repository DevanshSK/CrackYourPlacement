package LinkedLists.ll_hard;

import java.util.List;

public class ReverseNodeInKGroups {
    /***
     * Q. Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
     * k is a positive integer and is less than or equal to the length of the linked list.
     * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
     * You may not alter the values in the list's nodes, only nodes themselves may be changed.
     *
     *      # Optimal Solution
     *      - Figure out if it is the first group.
     *      - For every group repeat these steps
     *          - Find the kthNode and nextNode
     *          - If kthNode is null: Group is incomplete
     *              - Join the previous group, if there is any
     *          - Break the list from kth node and reverse the LL
     *          - If current group is head : Update the head
     *          - Else: Join the prevNode to reversed list
     *          - Update the prevNode and move temp to next list.
     *          - TC: O(2N) SC: O(1)
     */

    // Reverses a Linked list using 3 pointer approach.
    public ListNode reverseLL(ListNode head){
        // Initialize temp at head
        ListNode temp = head;
        // Also initialize previous node
        ListNode prev = null;

        // Traverse the list till the end.
        while(temp != null){
            // Store the next Node
            ListNode front = temp.next;
            // Add the current element to prev to build the list from last
            temp.next = prev;
            // Update the prev and temp nodes.
            prev = temp;
            temp = front;
        }
        // Return the new head of reversed ll
        return prev;
    }

    // Function to get the Kth node of the LL
    public ListNode getKthNode(ListNode temp, int k){
        // 1st node is already traversed in temp
        k -= 1;

        // Traverse to the kth nodes
        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }

        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // Node to traverse the List
        ListNode temp = head;
        // Make a pointer to track the previous node.
        ListNode prev = null;

        // Traverse the LL
        while(temp != null){
            // Get the Kth node of current group
            ListNode KthNode = getKthNode(temp, k);

            // If Kth node is null: Not a complete group
            if(KthNode == null){
                // Join the previous group if there is any and break
                if(prev != null) prev.next = temp;
                break;
            }

            // Store the nextNode and break the group into seperate LL
            ListNode nextNode = KthNode.next;
            KthNode.next = null;

            reverseLL(temp);

            // Update the head if first node is reversed
            if(temp == head){
                head = KthNode;
            }
            else{
                // Link the last group to current reversed group
                prev.next = KthNode;
            }

            // Update the pointers and prepare for next group
            prev = temp;
            temp = nextNode;
        }
        return head;
    }

}
