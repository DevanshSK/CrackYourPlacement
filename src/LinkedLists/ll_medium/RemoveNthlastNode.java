package LinkedLists.ll_medium;

public class RemoveNthlastNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {    // TC: O(N)     SC: O(1)
        // Edge Case: Head is null or head is the only element
        if(head == null || head.next == null){
            return null;
        }

        // Move fast node N places
        ListNode fast = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        // Edge Case: Check if deletion node is head
        if(fast == null){
            return head.next;
        }

        // Start slow traversal with fast pointer
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next; fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
