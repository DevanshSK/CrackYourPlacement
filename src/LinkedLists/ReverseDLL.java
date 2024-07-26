package LinkedLists;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Queue;
import java.util.Stack;

public class ReverseDLL {

    public static ListNode reverseExtreme(ListNode head){
        // Here we reverse the data values
        Stack<Integer> stk = new Stack<Integer>();
        ListNode temp = head;
        // Store all elements in the stack
        while(temp != null){
            stk.add(temp.data);
            temp = temp.next;
        }

        // Reinsert the data in reversed order
        temp = head;
        while(temp != null){
            temp.data = stk.peek();
            stk.pop();
            temp = temp.next;
        }

        return head;
    }

    public static ListNode reverse(ListNode head){
        // Here we reverse the links of the nodes.
        // TC: O(N), SC: O(1).
        ListNode last = null;
        ListNode current = head;
        while(current != null){
            last = current.prev;
            current.prev = current.next;
            current.next = last;
            current = current.prev;
        }

        return last.prev;
    }


    public static void main(String[] args) {

    }
}
