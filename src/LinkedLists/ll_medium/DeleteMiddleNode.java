package LinkedLists.ll_medium;

public class DeleteMiddleNode {
    /**
     * Q. 2095: Given a LL, delete the middle node of the linked list.
     *      If even list is there, remove the second middle element.
     *
     *      # Bruteforce Solution:
     *      - Traverse and find the length of the linked list.
     *      - Then traverse again and reach the node before the middle node.
     *      - Then delete the middle node.
     *
     *      TC: O(N + N/2)  // 2 pass solution
     *      SC: O(1)
     *
     *      # Optimized solution: Tortoise and hare algorithm
     *      - Take 2 pointers, slow and fast.
     *      - They move simultanrously with different speeds.
     *      - If fast reaches null or last element, slow is in middle.
     *      - To obtain element before middle, we need slow to move behind one step.
     *      - So skip one turn of the slow.
     *      - Then we easily delete the middle element.
     *
     *      TC: O(N/2)
     *      SC: O(1)
     * */
    public Node deleteNodeOptimal(Node head){
        // Handle empty and single list
        if(head == null || head.next == null) return null;

        // Declare the pointers
        Node slow = head, fast = head;
        // skip slow turn
        fast = fast.next.next;

        // Perform simultaneous traversal
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Delete the middle node.
        slow.next = slow.next.next;
        return head;
    }

    public Node deleteNode(Node head){
        // Handle empty and singular lists
        if(head == null || head.next == null) return null;

        // Declare the variables
        Node temp = head;
        int count = 0;

        // Find the length
        while(temp != null){
            count++;
            temp = temp.next;
        }

        int mid = count / 2;
        temp = head;

        // Go to the element before mid
        while(temp != null){
            mid--;
            if(mid == 0){
                // Reached the element.
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }

        return head;
    }
}
