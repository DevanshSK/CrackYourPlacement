package stacksandqueue.learning;

public class LQueue {
    // Implement Queue using Linked lists
    private class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            next = null;
        }
        Node(int d, Node n){
            this.data = d;
            this.next = n;
        }
    }

    Node front = null, rear = null;
    int size = 0;

    boolean isEmpty(){
        // Check if queue is empty
        return front == null;
    }

    int peek(){
        // Looks up the latest element to be deleted.
        if(isEmpty()){  // Queue is empty, return
            return -1;
        }
        // Return the value
        return front.data;
    }

    void enQueue(int x){
        // Adds an element to the queue
        Node temp = new Node(x);
        if(front == null){
            // Add first element
            front = rear = temp;
        }
        else{
            // Regular addition
            rear.next = temp;
            rear = temp;
        }
        size++;
    }

    int deQueue(){
        // Removes an element from the queue
        // Checks underflow
        if(isEmpty()) return -1;
        Node temp = front;
        front = front.next;
        temp.next = null;
        size--;
        return temp.data;
    }
}
