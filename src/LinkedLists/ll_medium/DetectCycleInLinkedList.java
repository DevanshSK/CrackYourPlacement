package LinkedLists.ll_medium;

import java.util.HashMap;

public class DetectCycleInLinkedList {
    /** Q.141: Given the head of linked list, determine wether the list has a cycle in it.
     *      Here we need to check if the current node is previously visited or not.
     *      To accomplish this, we use hashing.
     *
     *      - Start traversal of the LL, during which
     *      - Check if that node exist in the map:
     *          - If exist, loop is found
     *          - Id not, then add this node to map and move on.
 *          - If Traversal is complete, so we reach the end of the LL. So no loop exist.
     *
     *          TC: O(W * 2 * 1)
     *          SC: O(N)
     *
     *
     *      Optimal Solution: Reduce the space complexity.
     *      So we use Tortoise and hare algorithm.
     *      - Take 2 pointers, fast and slow
     *      - Slow moves 1x and fast moves 2x
     *      - They move simultaneously and if they reach at same node.
     *      - Then there is a loop in the ll, as fast completes 2 rounds and slow did 1 round.
     *
     *
     * */

    public boolean hasCycleOptimized(Node head){
        // Declare pointers
        Node slow = head, fast = head;

        // Start traversal
        while(fast != null && fast.next != null){
            // Simultaneous movement
            slow = slow.next;
            fast = fast.next.next;

            // Check for collision
            if( slow.equals(fast)){
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle(Node head) {
        // My try
        HashMap<Node, Integer> mapp = new HashMap<Node, Integer>();

        Node temp = head;
        while(temp != null){
            if(mapp.containsKey(temp)){
                return true;
            }
            else{
                mapp.put(temp, 1);
            }
            temp = temp.next;
        }

        return false;
    }
}
