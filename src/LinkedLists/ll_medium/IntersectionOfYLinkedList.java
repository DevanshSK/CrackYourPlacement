package LinkedLists.ll_medium;

import java.util.HashMap;

public class IntersectionOfYLinkedList {
    /**
     * Q. 160: Given a Y Linked list with two heads. Find and return the node which is common in both the lists.
     *
     *  Bruteforce Solution: Using hashing.
     *      - Iterate the first list and store the nodes in hashmap.
     *      - Then iterate and find the node that exist in the hashmap.
     *      - That node is the intersection node in the LL.
     *
     *      - TC: O(N1 * 1 + N2 * 1)
     *      - SC: O(N)
     *
     *
     *
     *  Optimized solution: No storing of nodes. Do it in place.
     *      - We trim the lists to equal lengths to reduce search space.
     *      - Find lengths of both lists.
     *      - Calculate difference in length and shift the head to that position.
     *      - Then perform simultaneously traversal to get to intersection.
     *      - We need to optimize the time complexity
     *
     *      TC: O(N1 + 2N2)
     *      SC: O(1)
     *
     *
     *  Optimal Solution: Use two pointers.
     *      - We traverse the two lists simultaneously until we reaches the common node.
     *      - If we reach null at the end of one list, we move to head of another list.
     *      - At the worst case the two pointers will traverse both lists and alignes perfectly.
     *      - Because essentially, Each pointer will traverse (N1 + N2) distance
     *      - So after both pointers switches list. They will be aligned.
     *
     *      TC: O(N1 + N2)
     *      SC: O(1)
     *
     * */

    public Node getIntgersectionNodeOptimal(Node headA, Node headB){
        // Check for empty lists.
        if(headA == null || headB == null) return null;

        // Create traversal pointers
        Node t1 = headA, t2 = headB;

        while(t1 != t2){
            // Simultaneous increment
            t1 = t1.next;
            t2 = t2.next;

            // Edge cases
            if(t1 == t2) return t1;     //  Intersection found
            if(t1 == null) t1 = headB;  //  Switch to Second list
            if(t2 == null) t2 = headA;  //  Switch to first list
        }
        return t1;
    }

    public Node getIntersectionNodeOpt1(Node headA, Node headB){
        Node t1 = headA, t2 = headB;
        int n1 = 0, n2 = 0;

        // Calculate length
        while(t1 != null){
            n1++;
            t1 = t1.next;
        }

        while(t2 != null){
            n2++;
            t2 = t2.next;
        }

        // Find length difference with collision.
        if(n1 < n2){
            return findCollision(headA, headB, n2 - n1);
        }
        else{
            return findCollision(headB, headA, n1 - n2);
        }
    }

    public Node findCollision(Node t1, Node t2, int d){
        // Trim the lists and find intersection point.

        // Trim the lists to same length
        while(d != 0){
            d--;
            t2 = t2.next;
        }

        // Simultaneous traversal with collision check
        while(t1 == t2){
            t1 = t1.next;
            t2 = t2.next;
        }
        // Return any value
        return t1;
    }


    public Node getIntersectionNodeHashed(Node headA, Node headB) {
        HashMap<Node, Integer> mapp = new HashMap<Node, Integer>();
        Node temp = headA;

        while(temp != null){
            mapp.put(temp, 1);
            temp = temp.next;
        }

        temp = headB;
        while(temp != null){
            if(mapp.containsKey(temp))  return temp;
            temp = temp.next;
        }

        return null;

    }
}
