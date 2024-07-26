package LinkedLists.ll_medium;

import java.util.HashMap;

public class FindStartOfLoopInLL {
    /**
     *  Q. Given a linked list, we have to find the start of the loop if there is any.
     *      If no loop is found, return null;
     *
     *      # Bruteforce Solution: Hashing
     *          We can traverse the LL and when we find a node twice. It means there is a node and this is the first element of the node.
     *          To remember the occurences of the nodes. We use a Hashmap.
     *
     *          TC: O(N * 2*1)
     *          SC: O(N)
     *
     *      # Optimal solution: Tortoise and Hare Algorithm
     *      - 2 pointers: Slow moving at 1x and Fast moving at 2x.
     *      - They move simultaneously and eventually if there is any cycle in the LL.
     *
     *      - Now, when slow enter the cycle. The fast covers distance L from slow.
     *      - And, the dist between fast and slow is d [Length of loop = L1 + d]
     *      - Now, The length d will reduces by 1 at every step of the traversal
     *          [As the speed difference of fast and slow is 1]
     *      - So they will eventually collide and loop is detected.
     *      - At this time: Fast covers 2d distance and slow covers d distance from the point.
     *          [When slow enters the cycle]
     *      - Now, The slow will have to move L1 steps to reach the initial point of the loop.
     *      - This distance is equal to the start of loop to the head of the loop.
     *      - If we perform simultaneous traversal with same speed
     *      - We will collide at the starting point of the LL.
     *
     *      TC:
     *      SC:
     * */
    public static Node findStartOfLoopOptimal(Node head){
        // Create pointers for simultaneous traversal.
        Node fast = head, slow = head;

        // Perform simultaneous traversal
        while(fast != null && fast.next != null){
            // Move the pointers
            slow = slow.next;
            fast = fast.next.next;

            // Check for Collision: Loop confirmed
            if(slow == fast){
                // Loop is confirmed. Now we find the start node of the LL
                /*
                * Distance[Head - Collision] = Distance[Collision - Head]
                * */
                slow = head;
                // Simultaneous traverse to the start point
                while(slow != fast){
                    fast = fast.next;
                    slow = slow.next;
                }
                // Both collide at start point
                return slow;
            }
        }
        // No cycle is found, returning null;
        return null;
    }

    public static Node findStartOfLoop(Node head){
        // Create hashmap to store nodes
        HashMap<Node, Integer> mapp = new HashMap<>();

        Node temp = head;
        while(temp != null){
            if(mapp.containsKey(temp)){ // Cycle found
                return temp;
            }
            // Insert node, cycle not found
            mapp.put(temp, 1);
            temp = temp.next;
        }
        // List is linear: No cycle found
        return null;
    }
}
