package arraysAndSorting.arrays1;

public class CheckSortedAndRotated {
    /**
     *  Q.  Given an array nums, return true if the array was originally sorted in non-decreasing order,
     *      then rotated some number of positions (including zero). Otherwise, return false.
     *      There may be duplicates in the original array.
     *      Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
     *
     *
     *      # Optimal Solution: Traverse and count the occurences of not sorted.
     *      - Then check the start and end for rotated elements.
     *      - If count < 2 : array is sorted and rotated.
     *      TC: O(N)
     *      SC: O(1)
     * */

    public boolean check(int[] nums) {
        int count = 0;
        // Check and count the number of disturbances in sorted order.
        for(int i =0; i< nums.length - 1; i++){
            if(nums[i] > nums[i+1]) count++;
        }

        // Check start and end for rotated array
        if(nums[nums.length - 1] > nums[0]) count++;

        // If count is less than 2, sorted array.
        return count < 2;
    }
}
