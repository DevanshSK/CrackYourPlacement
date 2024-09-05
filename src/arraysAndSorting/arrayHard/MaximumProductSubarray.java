package arraysAndSorting.arrayHard;

public class MaximumProductSubarray {
    /**
     *  Q.  Given an integer array nums, find a subarray
     *      that has the largest product, and return the product.
     *
     *      The test cases are generated so that the answer will fit in a 32-bit integer.
     *
     *      # Bruteforce Solution:
     *      - Generate all the subarrays and find the maximum element in it.
     *      TC: O(N^3)
     *      SC: O(1)
     *
     *      ## Better Solution:
     *      - Reduce the last loop by calculating the product as we traverse the subarrays.
     *      TC: (N^2)
     *      SC: (1)
     *
     *      # Optimal Solution:
     *      - By observations:
     *          - If negatives are even or none: Then the maximum subarray is the entire array.
     *          - But if negatives are odd: Then we need to eliminate one negative to make even.
     *          - If zero is found, then the two subarrays will be the answer, as multiplying by zero will result in zero.
     *      - So, we traverse the array, and calculate prefix from start and suffix from end.
     *      - Then we compare these and store the maximum value.
     *      - If the prefix or suuffix is zero, then just update its value to 1 and move on.
     *      TC: O()
     *      SC: O()
     *
     * */
    public int maxProductOptimal(int[] nums) {
        int pref = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        
        // Iterate the array calculate the size.
        for (int i = 0; i < n; i++) {
            if(pref == 0) pref = 1;
            if(suff == 0) suff = 1;

            pref = pref * nums[i];
            suff = suff * nums[n-i-1];
            ans = Math.max(ans, Math.max(pref, suff));
        }
        return ans;
    }
}
