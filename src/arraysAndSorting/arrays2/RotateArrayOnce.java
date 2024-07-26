package arraysAndSorting.arrays2;

public class RotateArrayOnce {
    static int[] rotateArrayLeft(int[] arr, int n) {
        // Write your code here.
        int temp = arr[0];
        for(int i=1; i<n; i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
        return arr;
    }
    static int[] rotateArrayRight(int[] arr, int n){
        int temp = arr[n-1];
        for(int i = 1; i<n; i++){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        return arr;
    }
}
