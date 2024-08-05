package TwoPointersAndSlidingWindow.medium;

public class NiceSubArrays {
    /**
     *  Q.  Given an array of integers nums and an integer k.
     *      A continuous subarray is called nice if there are k odd numbers on it.
     *      Return the number of nice sub-arrays.
     *
     *      # NOTE:
     *          - This problem is similar to "Binary SubArray with Sum K".
     *          - As this array is converted to binary array with odd=1 and even=0 values.
     *          - So this question can be solved by converting this problem into sub problems.
     *              - Count nice subarrays with sum <= K
     *              - Count nice subarrays with sum <= k - 1
     *              - Then, Our count of nice subarrays will become:
     *                  count = F(nums, k) - F(nums, k-1)
     *          TC: O(2N)
     *          SC: O(1)
     * */
    public int helper(int[] nums, int k){
        int l=0, r=0, sum=0, count=0;
        // Base case: If sum of odd < 0 : Not possible
        if(k < 0) return 0;

        while(r < nums.length){
            // Increment the odd numbers.
            sum += nums[r] % 2;

            // Handle shrinking condition.
            while(sum > k){
                sum -= nums[l++] % 2;
            }

            // Update count of valid subarrays
            count += r - l + 1;
            r++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
}
