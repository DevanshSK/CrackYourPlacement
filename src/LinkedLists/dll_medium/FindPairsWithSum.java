package LinkedLists.dll_medium;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPairsWithSum {
    /**
     * Q. Given a sorted doubly linked list of positive distinct elements,
     *      the task is to find pairs in a doubly-linked list whose sum is equal to given value target.
     *
     *  # Bruteforce solution:
     *      - Traverse and check all combinations for all elements in the LL.
     *      - And add them to the list to return.
     *
     *      TC: Nearly O(N ^ 2)
     *      SC: O(1)
     *
     *      # Optimal solution
     *      - We know the list is sorted, so we can use this to apply two pointer approach.
     *      - We take 2 pointers, left at head, right at tail
     *      - Then we check the sum of left and right:
     *      - If sum == target  : Pair found and move both pointers.
     *      - If sum < target   : move the left pointer and increase the sum
     *      - If sum > target   : move the right pointer and decrease the sum.
     *      - Repeat untill the left < right.
     *
     *      TC: O(2N)
     *      SC: O(1) : We are using arraylist to return the answer.
     * */
    public static Node findTail(Node head){
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        return tail;
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // Assign pointers to tail and head
        Node left = head, right = findTail(head);   // O(N)
        // Define list to store pairs
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        while(left.data < right.data){  // O(N)
            int sum = left.data + right.data;
            if(sum == target){
                // Pair is found, move both pointers.
                list.add(new ArrayList<>(Arrays.asList(left.data, right.data)));
                left = left.next;
                right = right.prev;
            }
            else if(sum < target){
                left = left.next;
            }
            else{
                right = right.prev;
            }
        }
        return list;
    }

}
