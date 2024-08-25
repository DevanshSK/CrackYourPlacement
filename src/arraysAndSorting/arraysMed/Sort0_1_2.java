package arraysAndSorting.arraysMed;

import java.util.ArrayList;

public class Sort0_1_2 {
    /**
     * Q.   Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
     *      with the colors in the order red, white, and blue.
     *      We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     *      You must solve this problem without using the library's sort function
     *
     *      # Bruteforce Solution:
     *      - Sort the array using sorting algorithms.
     *      TC: O(N*log(N))
     *      SC: O(N)
     *
     *      # Better Solution:
     *      - Count the occurences of 0, 1 and 2.
     *      - Then in the next iteration, update the values in the corrected order.
     *      TC: O(2N)
     *      SC: O(1)
     *
     *      # Optimal Solution: Dutch National Flag Algorithm
     *      - Use 3 pointers to track the sorted and unsorted array.
     *      - Initially, left and mid are at 0: Array is unsorted.
     *      - And right is at last index, indicating latest one position.
     *      - Left indicate the potision for 0 to be swapped.
     *      - Now traverse the array with mid.
     *          - If 0: Swap with low and increase low and mid.
     *          - IF 1: Array is already sorted, go forward mid.
     *          - If 2: Swap it to right and increment mid and right.
     *      - Repeat unitl the mid meets right.
     *      TC: O(N)
     *      SC: O(1)
     * */
    public void better(int[] nums, int n){


        // Here bruteforce solution is to just use a sorting algorithm. Which takes greater time.

        // So our better approach is to record the occurences of 0 1 and 2. And then modify the array in sorted order
        // TC: O(2N) SC: O(1)
        int count0=0, count1 = 1, count2 = 2;

        // Recording occurences
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0) count0++;
            else if(nums[i] == 1) count1++;
            else count2++;
        }

        // Overriding array
        for(int i=0; i < count0; i++) nums[i] = 0;
        for(int i=count0; i < count0 + count1; i++) nums[i] = 1;
        for(int i=count0 + count1; i < n; i++) nums[i] = 2;
    }



    public static void sortArray(ArrayList<Integer> arr, int n) {
        // Here we are going to solve this in first iteration.
        // By using Dutch National Flag Algorithm : Using 3 pointers approach
        // Create pointers for
        int low = 0, mid = 0, high = n-1;

        while(mid <= high){
            if(arr.get(mid) == 0){
                // Swapping zero to starting position
                int temp = arr.get(mid);
                arr.set(mid, arr.get(low));
                arr.set(low, temp);
                // Increment pointers
                low++;
                mid++;
            } else if (arr.get(mid) == 1) {
                // Already sorted and move mid pointer
                mid++;
            }
            else{
                // Swap mid and high
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);
                // Decrement high pointer
                high--;
            }
        }
    }
}
