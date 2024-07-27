package LinkedLists.ll_hard;

import java.util.HashMap;

class RNode {
    int val;
    RNode next;
    RNode random;

    public RNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CloneListWithRandomPointer {
    /**
     *  Q. A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
     *     - ‘next’ which points to the next node in the list.
     *     - ‘random’ which points to a random node in the list or ‘null’.
     *
     *     # Bruteforce Solution:   Creating a deep copy of LL
     *     - First we create and map the copied nodes to the original nodes.
     *     - Then we traverse the LL and assign the nodes to copied LL.
     *     - We can manage links by using map to identify correspondence nodes.
     *     TC: O(2N)
     *     SC: O(2N)    : O(N) as extra space is needed to return the answer.
     *
     *
     *     # Optimal solution: Store copy nodes in between the original list
     *     - This has 3 steps:
     *     - Insert nodes next to original nodes
     *     - Connect random pointers of the head.
     *     - Connect next pointer and extracting the copied list.
     *
     * */
    public RNode copyRandomList(RNode head){
        // Storing nodes in between original nodes.
        RNode temp = head;
        while(temp != null){
            // Create a new Node
            RNode copyNode = new RNode(temp.val);
            // Insert copy node next to original
            copyNode.next = temp.next;
            temp.next = copyNode;
            // Move on to next node
            temp = temp.next.next;
        }

        // Assigning Random pointer of copied nodes.
        temp = head;
        while(temp != null){
            // Get the copy Node
            RNode copyNode = temp.next;
            // Assign copy random
            RNode random = temp.random;
            // Check if random goes to null
            if(random == null){
                copyNode.random = null;
            } else{
                // Corresponding copy node is right next to original node.
                copyNode.random = random.next;
            }
            // Go to next node
            temp = temp.next.next;
        }

        // Split copied and original list and connect next pointers
        temp = head;
        RNode dummy = new RNode(-1), res = dummy;
        while(temp != null){
            // Attach copy node to list
            res.next = temp.next;
            // Attaching temp node to its original next
            temp.next = temp.next.next;
            // Moving for the next node
            res = res.next;
            temp = temp.next;
        }

        return dummy.next;
    }


    // Deep copy using bruteforce method
    public RNode copyRandomListBrute(RNode head) {
        // Map to store node pairs
        HashMap<RNode, RNode> mapp = new HashMap<>();
        // Node for traversal
        RNode temp = head;

        // Store all nodes pairs in map
        while(temp != null){
            RNode newNode = new RNode(temp.val);
            mapp.put(temp, newNode);
            temp = temp.next;
        }

        // Traverse and assign links
        temp = head;
        while(temp != null){
            // Fetch corresponding node
            RNode copyNode = mapp.get(temp);
            // Assign next and random links
            copyNode.next = mapp.get(temp.next);
            copyNode.random = mapp.get(temp.random);
            // Move on to next node
            temp = temp.next;
        }

        // Return the head of new LL
        return mapp.get(head);
    }
}
