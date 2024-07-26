package arraysAndSorting.arraysMed;

import java.util.ArrayList;

public class Sort0_1_2 {
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
