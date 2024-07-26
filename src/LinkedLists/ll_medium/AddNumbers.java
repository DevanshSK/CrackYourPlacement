package LinkedLists.ll_medium;



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * This can be done by using dummy node approach.
         * And in a single pass.
         * We iterate both lists and store the sum and carry in the resultant list and keep track of it.
         * TC: O(max(num1, num2))
         * SC: O(max(num1, num2))
         * */

        // Inititlise the temp, dummy and current nodes.
        ListNode temp1 = l1, temp2 = l2;    // Tracks both the lists
        ListNode dummyNode = new ListNode(-1);  // Holds the resultant list
        ListNode current = dummyNode;   // Tracks the resultant list
        int carry = 0;  // Hold the carry value in addition.

        // Iterate the lists
        while(temp1 != null || temp2 != null){
            int sum = carry;
            // Add temp value and move on
            if(temp1 != null){
                sum += temp1.val;
                temp1 = temp1.next;
            }

            // Add temp value and move on
            if(temp2 != null){
                sum += temp2.val;
                temp2 = temp2.next;
            }

            // Append the sum value in the resultant list
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;

            current.next = newNode;
            current = current.next;
        }

        // Now append the remaining carry value
        if(carry != 0){
            current.next = new ListNode(carry);
        }

        // Return the resultant list.
        return dummyNode.next;
    }
}
