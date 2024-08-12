package arraysAndSorting.arrays2;

public class MoveZerosToEnd {
    /**
     * Q.   Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *      Note that you must do this in-place without making a copy of the array.
     *
     *      # Bruteforce solution:
     *      - Store non zeros in an external array
     *      - Then update the non zeros and rest are zeros
     *      TC: O(2N)
     *      SC: O(N)
     *
     *      # Optimal Solution:
     *      - Use 2 pointers
     *      - One pointer(j) tracks the first zero element.
     *      - Then second(i) pointer traverses the array and point at non zeros.
     *      - Then Traverse and swap non zeros with last zeros(j)
     *      TC: O(N)
     *      SC: O(1)
     *
     * */
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
