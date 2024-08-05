package TwoPointersAndSlidingWindow.medium;

public class BinarySubArrayWithSum {
    /**
     *  Q.  Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
     *      A subarray is a contiguous part of the array.
     *
     *      # Brute and Better Solution:
     *      - This problem is similar to "Count subarray with sum == k"
     *      - In that problem we used brute and better solutions.
     *      - Brute includes, generating all subarrays.         TC: O(N^2)  SC: O(1)
     *      - Better solution uses Hashing with prefix sum.     TC: O(N)    SC: O(N)
     *
     *      # Optimal Solutions: Optimizations on Hashing method.
     *      - Normal sliding window not works as we don't know when to move l and r pointer.
     *      - So we make some modifications to the solution.
     *      - Instead of sum == k ; We try to find sum <= k
     *      - Due to binary values of data, we conclude that:
     *          - On expansion, if the criteria is valid -> count increases by length.
     *          - As this new number makes combinations with all the previous valid subarrays.
     *          - So count += length.
     *      - Then we can just find, count = f(nums, goal) - f(nums, goal - 1).
     * */

    public int countSubarraysAtMostK(int[] nums, int goal){
        int l=0, r=0, sum=0, count=0;
        // Base case: Handle negative sum
        if(goal < 0) return 0;
        while(r < nums.length){
            // Increment sum
            sum += nums[r];
            // Handle shrinking condition
            while(sum > goal){
                sum -= nums[l++];
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSubarraysAtMostK(nums, goal) - countSubarraysAtMostK(nums, goal - 1);
    }
}
