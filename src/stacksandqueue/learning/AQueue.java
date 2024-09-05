package stacksandqueue.learning;

public class AQueue {
    // Implement Queue using Arrays
    int size = 16;
    int[] q = new int[size];
    int start = -1, end = -1, currSize = 0;

    void push(int x){   // Adds element to queue
        // Underflow check
        if(currSize == size){
            // Queue is full
            return;
        }
        // Queue is empty
        if(end == -1){
            start = end = 0;
        }
        else{
            // Normal case: Queue is partially filled
            // Circle back to start if end is at last index
            end = (end+1) % size;
        }
        q[end] = x;
        currSize++;
    }

    int pop(){  // Deletes an element from the queue
        // Underflow check
        if(start == -1){
            return -1;
        }
        int x = q[start];
        // Onlu one element in queue
        if(currSize == 1)   start = end = -1;
        else    start = (start+1) % size;
        currSize--;
        return x;
    }

    int top(){  // Select top element
        if(start == -1){
            return -1;
        }
        return q[start];
    }
    int size(){
        return currSize;
    }
}
