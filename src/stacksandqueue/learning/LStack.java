package stacksandqueue.learning;

public class LStack {
    // Stack implementation using Linked list
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

    // Define elements
    Node top = null;
    int size = 0;

    void push(int x){
        // Adds new element to the stack
        Node temp = new Node(x);
        temp.next = top;    // Update link
        top = temp; // Update top
        size++; // Increase size
    }

    int pop(){
        // Underflow.
        if(top == null) return -1;
        int x = top.data;
        Node temp = top;
        top = top.next;
        temp.next = null;
        return x;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return top == null;
    }

    int top(){
        if(top == null) return -1;
        return top.data;
    }
}
