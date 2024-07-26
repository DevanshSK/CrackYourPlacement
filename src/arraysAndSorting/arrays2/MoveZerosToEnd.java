package arraysAndSorting.arrays2;

public class MoveZerosToEnd {
    public static int[] moveZeros(int n, int []arr) {
        // Step 1: Find the first zero
        int j = -1;
        for(int i = 0; i<n; i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }

        // If no zeros is found then return
        if(j == -1 ) return arr;

        // Continue the iteration and swap the zeros to the end
        for(int i = j+1; i<n; i++){
            if(arr[i] != 0){
                // Swap the elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        // Return the array
        return arr;
    }
}
