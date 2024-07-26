package Collections_Framework;
import java.util.Stack;
public class LearnStack {
    public static void main(String[] args) {
        // Stack : Works on LIFO or FILO
        // Creating Stacks
        Stack stk = new Stack();  // Causes bugs as it datatype is not present
        Stack<String> animals = new Stack<String>();    // Correct way

        // .push() : Adding Elements to stack
        animals.push("Lion");
        animals.push("Monkey");
        animals.push("zebra");
        animals.push("deer");

        // Printing the entire Stack
        System.out.println(animals);

        // .peek() : Accessing top element of stack
        System.out.println(animals.peek());

        // .pop() : Removing top element from stack
        String removed = animals.pop();
        System.out.println("Removed Element : " + removed);
        System.out.println(animals);
    }
}
