package stacksandqueue.learning;

import java.util.LinkedList;
import java.util.Queue;

class QStack {
    /**
     * Q.   Implement a last-in-first-out (LIFO) stack using only two queues.
     *      The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
     *
     *      ## Optimal Solution:
     *      - We only modify the push operation, as it will handles the rest of the operations effectively.
     *      - We store the size of original queue: s
     *      - Push and pop the previous s elements in the queue.
     *
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    Queue<Integer> q;

    public QStack() {
        this.q = new LinkedList<Integer>();
    }

    public void push(int x) {
        int s = q.size();
        q.add(x);
        for (int i = 1; i <= s; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
