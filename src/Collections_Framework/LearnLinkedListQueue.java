package Collections_Framework;
import java.util.LinkedList;
import java.util.Queue;

public class LearnLinkedListQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();

        // .offer() : Adds elements to the queue
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(90);
        queue.offer(60);

        // Printing queue
        System.out.println(queue);

        // .poll() : Deletion of first element and returns it
        Integer num = queue.poll();
        System.out.println("Removed Element : " + num);
        System.out.println(queue);

        // .peek() : Returns the elements that is going to deleted next
        System.out.println("Next in line : " + queue.peek());


    }
}
