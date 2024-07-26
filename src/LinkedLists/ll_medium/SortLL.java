package LinkedLists.ll_medium;

public class SortLL {
    /**
     * Q. 148: Given the head of a linked list, return the list after sorting it in ascending order.
     *
     * # Bruteforce Solution:
     *      - Put all elements of the list in an array      \ O(N)
     *      - Sort the array using any technique.           \ O(N * Log(N))
     *      - Replace the list values with sorted values.   \ O(N)
     *
     *      TC: O(2N + N * log(N))
     *      SC: O(N)
     *
     *
     *  # Optimal Solution: We perform the merge sort on the linked list itself
     *  Note: We need these in order to do this solution
     *  1. Merge sort | Obviously
     *  2. Merge two sorted linked lists.
     *  3. Find the middle of the LL | Tortoise and Hare Algorithm.
     *
     * */


    public static Node sortList(Node head) {
        // Base case: Head is null or singular
        if(head == null || head.next == null) return head;

        // Find middle of the LL
        Node middle = findMiddle(head);
        // Split the LL in two parts
        Node leftHead = head ,rightHead = middle.next;
        middle.next = null;

        // Sort the individual lists
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        // Merge the two sorted lists.
        head = mergeTwoLists(leftHead, rightHead);
        return head;
    }


    // Find middle node using Tortoise and Hare algorithm.
    public static Node findMiddle(Node head){
        // Declare slow and fast pointers
        Node slow = head, fast = head.next;

        // Iterate until fast reaches last or null.
        while(fast != null && fast.next != null){
            slow = slow.next;       // Slow moves 1x
            fast = fast.next.next;  // Fast moves 2x
        }

        return slow;    // Slow reaches at middle.
    }

    // Merge two sorted lists
    public static Node mergeTwoLists(Node list1, Node list2) {
        // Optimal Solution
        Node t1 = list1, t2 = list2;
        // Creating dummy node for resultant list
        Node dNode = new Node(-1), temp = dNode;

        // Move until one of the list is exhausted
        while(t1 != null && t2 != null){
            // Pick the smaller node and attack it to dummy list
            if(t1.data < t2.data){
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            }
            else{
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }

        // At least one of the list is exhausted
        if(t1 != null){
            temp.next = t1;
        }else{
            temp.next = t2;
        }

        // Return the sorted list
        return dNode.next;
    }
}
