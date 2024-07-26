package LinkedLists.ll_hard;

import java.util.ArrayList;
import java.util.Collections;

class Node{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}
public class FlattenALinkedLIst {
    /**
     * Q. Given a Linked List of size n, where every node represents a sub-linked-list and contains two pointers:
     *      (i) a next pointer to the next node,
     *      (ii) a bottom pointer to a linked list where this node is head.
     *      Each of the sub-linked-list is in sorted order.
     *      Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
     *
     *      # Bruteforce Solution
     *      1. Traverse and Store all the elements in an array.
     *      2. Sort the elements in an array.
     *      3. Then convert the array into a vertical linked list.
     *
     *      TC: O( 2(N*M) + (N*M)log(N*M) )
     *      SC: O( 2(N*M) )
     *
     *      # Optimal Solution: Utilizing Property of Sorted sub lists
     *      1. If we observe, the core problem can drop down to merging two sorted lists.
     *      2. Also, we can reuse nodes to reduce space complexity: Inplace Solution
     *      3. We can start the merging from end and go towards start: Recursion.
     *
     *
     * */

    static Node merge2Lists(Node h1, Node h2){
        // Dummynode as head for merged list.
        Node dummy = new Node(-1);
        // Temporary node for keeping track of latest element.
        Node res = dummy;

        // Iterate both lists if they are not null
        while(h1 != null && h2 != null){
            if(h1.data < h2.data){
                res.bottom = h1;
                res = h1;
                h1 = h1.bottom;
            }
            else{
                res.bottom = h2;
                res = h2;
                h2 = h2.bottom;
            }
            res.next = null;
        }

        // Check and add remaining lists to result.
        if(h1 != null){
            res.bottom = h1;
        } else {
            res.bottom = h2;
        }

        return dummy.bottom;
    }

    static Node flatten(Node head){
        // Base case
        if(head == null || head.next == null) return head;

        Node mergedHead = flatten(head.next);

        return merge2Lists(head, mergedHead);
    }



    static Node flattenBrute(Node head){
        // Define array to store elements
        ArrayList<Integer> arr = new ArrayList<>();

        // Step-1: Store all elements
        Node temp = head;
        while(temp != null){        // Traverse the main list
            Node t2 = temp;
            while(t2 != null){      // Traverse the sub lists
                arr.add(t2.data);   // Store the node data
                t2 = t2.bottom;     // Go to next sub element
            }
            temp = temp.next;       // Go to next sub list
        }

        // Step-2: Sort the array in ascending order
        Collections.sort(arr);

        return convertArrToLinkedList(arr);
    }

    static Node convertArrToLinkedList(ArrayList<Integer> arr){
        // Dummy node for the head of LL
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        // Iterate through arraylist and build the list.
        for(int i = 0; i < arr.size(); i++){
            Node newNode = new Node(arr.get(i));
            temp.bottom = newNode;      // Attach the new node.
            temp = temp.bottom;         // Go to next element
        }

        // Return the head of completed list.
        return dummyNode.bottom;
    }


}
