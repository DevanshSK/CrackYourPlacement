package LinkedLists.ll_medium;

import java.util.HashMap;

public class LengthOfLoopInLL {
    /**
     *  Q. Given a linked list, we have to find the length of the loop in the linked list.
     *      If there is no loop, return the length = 0
     *      It is a follow up question of Check if there is cycle or not.
     *
     *      # Bruteforce - Hashing
     *      - We can maintain a timestamp counter to determine at which step the node is visited.
     *      - We create an HashMap to store the nodes and the time visited.
     *      - Then we traverse the LL and:
     *          1. Check if Node exists in a hashmap.
     *          2. If node do not exists, add the node to map with current timestamp.
     *          3. If node exists, Then difference between Current time and Stored time is the length of LL.
     *
     *      TC: O(N * 1) For constant TC of hashmap.
     *      SC: O(N)
     *
     *      # Optimal Solution: Tortoise and Hare Algorithm
     *      - Take 2 pointers, slow move 1x and fast move 2x
     *      - Move them simultaneously and when they collide, The loop is found.
     *      - Then Iterate one pointer to cycle back to its position, as we have a cycle.
     *      - Else, return 0 at the end as no cycle is found.
     *
     *
     * */
    public static int findLength(Node slow, Node fast){
        int count = 1;
        fast = fast.next;

        while(slow != fast){
            count++;
            fast = fast.next;
        }

        return count;
    }
    public static int findLengthOfLoopOptimal(Node head){
        // Declare pointers
        Node slow = head, fast = head;
        // Start the traversal
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // Check for collision
            if(slow.equals(fast)){
                // Find the length of Loop
                return findLength(slow, fast);
            }
        }
        // No cycle is found here
        return 0;
    }

    public static int findLengthOfLoop(Node head){
        // Define the hashmap and timestamp
        int timer = 1;
        HashMap<Node, Integer> mapp = new HashMap<>();

        Node temp = head;

        while(temp != null){
            if(mapp.containsKey(temp)){
                // Cycle detected
                return timer - mapp.get(temp);
            }
            // Add current node to map.
            mapp.put(temp, timer);
            timer++;
            temp = temp.next;
        }

        // No loop found
        return 0;
    }
}
