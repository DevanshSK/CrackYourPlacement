package stacksandqueue.learning;


public class AStack {
    // Implementing Stack using Arrays
    int size = 10000;
    int[] st = new int[size];
    int top = -1;

    void push(int x){   // Adds element to stack
        // Overflow check
        if(top == 999) return;
        // Insert element
        top++;
        st[top] = x;
    }
    int pop(){  // Deletes and return top element.
        if(top == -1){
            // Underflow check
            return -1;
        }
        int x = st[top];
        top--;
        return x;
    }
    int top(){  // Returns top element
        if(top == -1){
            return -1;
        }
        return st[top];
    }
    int size(){
        return top+1;
    }
}
