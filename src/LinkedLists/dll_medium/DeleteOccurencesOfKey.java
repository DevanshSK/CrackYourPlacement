package LinkedLists.dll_medium;

public class DeleteOccurencesOfKey {
    /**
     *  Q. You are given the head_ref of a doubly Linked List and a Key.
     *  Your task is to delete all occurrences of the given key if it is present and return the new DLL.
     *
     *  # Solution
     *      - Traverse the DLL as standard.
     *      - Check if the node is equals to the key or not.
     *      - If head is to be removed, then update the head to next element.
     *      - Else, Remove the node by taking prevNode and nextNode of the currentNode
     *
     *
     * */

    static Node deleteAllOccurOfX(Node head, int x) {
        Node temp = head;
        while(temp != null){
            if(temp.data == x){ // Check if Node is target.
                // Move the head if it is deleted
                if(temp == head){
                    head = head.next;
                }
                // Delete the node
                Node nextNode = temp.next;
                Node prevNode = temp.prev;
                if(nextNode != null)    nextNode.prev = prevNode;
                if(prevNode != null)    prevNode.next = nextNode;
                temp = temp.next;
            }
            else{
                temp = temp.next;
            }
        }

        return head;
    }
}
