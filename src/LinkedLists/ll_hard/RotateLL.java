package LinkedLists.ll_hard;

public class RotateLL {
    /**
     * Q. Given the head of a linked list, rotate the list to the right by k places.
     *
     *
     * # Optimal SOlution
     *      - Find the tail element and join it to head
     *      - Find the new Tail node which is at [Length -  K] position
     *      - Break the link and update the head
     *      TC: O(2N)
     *      SC: O(1)
     * */

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        // Finding Length
        int len = 1;
        ListNode tail = head;

        while(tail.next != null){
            len++;
            tail = tail.next;
        }
        // If k is multiple of len: No change in LL
        if(k % len == 0) return head;

        // Rotate the LL
        k = k % len;
        // Connect tail to head
        tail.next = head;
        // Get the newLastNode: Length - Kth node
        ListNode newLast = findNth(head, len - k);
        head = newLast.next;
        newLast.next = null;

        return head;
    }
    public ListNode findNth(ListNode temp, int k){
        int count = 1;
        while (temp != null){
            if(count == k) return temp;
            count++;
            temp = temp.next;
        }
        return temp;
    }
}
