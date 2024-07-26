package CPlusplusExample;

public class Question {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.activeCount());
    }
}
