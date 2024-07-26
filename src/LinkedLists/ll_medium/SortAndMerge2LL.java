package LinkedLists.ll_medium;

public class SortAndMerge2LL {
    /**
     * Q. You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
     * Return the head of the merged linked list.
     *
     *
     * # Bruteforce solution:
     *      - Put all elements of both linked list into an arary.
     *      - Perform the sorting on the array.
     *      - Generate a new linked list from the sorted array.
     *  TC: O(N1 + N2 + (N1 + N2)log(N1+N2) )
     *  SC: O(N1 + N2)
     *
     *  # Optimal solution:
     *      - Here we use 2 pointers and reuse the nodes.
     *      - First we traverse the LL simultaneously
     *      - Then we add the smallest node in the new LL with a dummy node.
     *      - Then we append the remaining list into new LL.
     *  TC: O(M+N)
     *  SC: O(1)
     * */

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
