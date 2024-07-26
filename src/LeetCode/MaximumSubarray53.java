package LeetCode;

public class MaximumSubarray53 {
    /**
     * Given an array of integers,
     * we have to find a subarray having maximum sum and
     * return it.
     *
     * There are negative integers present in the array.
     * */

    public int maxSubArrayBrute(int[] nums) {
        /**
         * First solution is to loop over all subarrays and store the maximum sum in a variable.
         * Here, we use 2 loops for finding subarray and a third loop to calculate the sum.
         * TC: O(N^3) SC:O(1)
         * */

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // We are inside the subarray
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxi = Math.max(sum, maxi);
            }
        }
        return maxi;
    }
    public int maxSubArrayBetter(int[] nums) {
        /**
         * Here, we optimize the brute by an observation.
         * The sum of a subarray is basically the sum of the previous subarray and next element.
         * So we takeout sum and just increment the sum as we go through next subarray.
         * It will reduce the time complexity.
         * TC: O(N^2) SC:O(1)
         * */

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                // We are inside the subarray
                sum += nums[j];
                maxi = Math.max(sum, maxi);
            }
        }
        return maxi;
    }

    public int maxSubArrayOptimal(int[] nums){
        /**
         * Here, we are going to use kandane algorithm.
         * First we, initialise maxi = MIN_value and sum = 0
         * Then we iterate over the array and increment the sum.
         * If sum is less than 0 : Shift subarray to right
         * If sum is greater than maxi : Update maxi
         *
         * Then return maxi
         * TC: O(N) SC:O(1)
         * */
        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(sum > maxi) maxi = sum;
            if(sum < 0) sum = 0;
        }

        return maxi;
    }



}
