package LinkedLists.dll_medium;

public class RemoveDuplicates {
    /**
     * Q. Given a doubly linked list of n nodes sorted by values,
     * the task is to remove duplicate nodes present in the linked list.
     *
     *  # Solution
     *      - Traverse the LL as usual.
     *      - Take nextNode as next NOde and move it until it reaches a different value than temp.
     *      - Then skip those values immediately.
     * */

    Node removeDuplicates(Node head){
        Node temp = head;
        while(temp != null && temp.next != null){
            Node nextNode = temp.next;
            // Skip the duplicate nodes
            while(nextNode != null && nextNode.data == temp.data){
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if(nextNode != null) nextNode.prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
