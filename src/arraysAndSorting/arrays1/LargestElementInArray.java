package arraysAndSorting.arrays1;

public class LargestElementInArray {
    /**
     *  Q. Given an array arr, the task is to find the largest element in it.
     *  - Keep a max number.
     *  - Iterate the array.
     *  - Compare and update the maximum number.
     *  TC: O(N)
     *  SC: O(1)
     * */
    public static int largest(int n, int[] arr) {
        // Maximum var to store maximum
        int maxNum = Integer.MIN_VALUE;

        for(int i =0; i<n; i++){
            maxNum = Math.max(maxNum, arr[i]);
        }
        return maxNum;
    }

}
