package LinkedLists.ll_medium;

public class MiddleNode {
    /**
     * Q. 876: Find the middle node of the LL
     *          If even number of nodes are found, return the second mid element.
     *
     *   # Bruteforce Solution:
     *   TC: O(N + N/2) SC: O(1)
     *   1. Iterate and calculate number of nodes N
     *   2. Calculate the mid node number
     *   3. Iterate to the mid node and return it.
     *
     *
     *
     * # Optimised solution: Solved by Tortoise and Hare ALgorithm
     *  Here we declare two pointers: slow and fast.
     *  And they initially start at head.
     *  And they move simultaneously where fast pointer moves twice as fast as slow one.
     *  Now, this process repeats untill:
     *      1. Fast pointer reaches the last element: Odd number of elements
     *      2. Fast pointer reaches null: Even number of elements
     *  At this condition the slow element is automatically the middle element in LL.
     *
     *
     *  TC: O(N/2)
     *  SC: O(1)
     * */

    public Node findMiddleOptimised(Node head){
        // Declare slow and fast pointers
        Node slow = head, fast = head;

        // Iterate until fast reaches last or null.
        while(fast != null && fast.next != null){
            slow = slow.next;       // Slow moves 1x
            fast = fast.next.next;  // Fast moves 2x
        }

        return slow;    // Slow reaches at middle.
    }

    public static Node middleBrute(Node head){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        int mid = (count / 2) + 1;
        temp = head;
        while(temp != null){
            mid = mid - 1;
            if(mid == 0){
                break;
            }
            temp = temp.next;
        }
        return temp;
    }


}
