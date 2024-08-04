package TwoPointersAndSlidingWindow.medium;

public class MaxConsecutiveOnesIII {
    /**
     *  Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
     *
     *  # Bruteforce Solution:
     *  - Generate all the subarrays with max zeros of K.
     *  - Keep count of zeros in each subarray.
     *  - If zeros exceed limit -> Next subarrays also exceed also.
     *  - Then maintain the max length of the valid subarray.
     *      TC: O(N^2)
     *      SC: O(1)
     *
     *
     *    # Optimal Solution: Sliding window
     *    - start with window size 1 and expand the window and maintain zeros.
     *    - If zeros <= K, then valid and move on.
     *    - If zeros > K, shrink the subarray until no zeros remains.
     *      - We shrink by looping left until zeros <= k
     *
     *    TC: O(2N)
     *    SC: O(1)
     *
     *    # Optimal Solution - Single pass
     *    - We need to eliminate inner shrinking loop.
     *    - We can only update the maxValue if zeros <= k.
     *    - If zeros > k : we just move left and do not update.
     *      TC: O(N)
     *      SC: O(1)
     * */

    public int longestOnesBetter(int[] nums, int k) {
        int maxLen = 0, l = 0, r = 0, zeros = 0;
        // Traverse the array with window.
        while(r < nums.length){
            // Update the zeros counter
            if(nums[r] == 0)    zeros++;
            if(zeros > k){
                // Move left of window
                if(nums[l] == 0)    zeros--;
                l++;
            }

            // Update max value
            if(zeros <= k){
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }

            // Handle expansion
            r++;
        }
        return maxLen;
    }

    public int longestOnes(int[] nums, int k) {
        int maxLen = 0, l = 0, r = 0, zeros = 0;
        // Traverse the array with window.
        while(r < nums.length){
            // Update the zeros counter
            if(nums[r] == 0){
                zeros++;
            }

            while(zeros > k){
                // Shrink the window
                if(nums[l] == 0) zeros--;
                l++;
            }

            // Update max value
            if(zeros <= k){
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }

            // Handle expansion
            r++;
        }
        return maxLen;
    }

    public int longestOnesBrute(int[] nums, int k) {
        int maxLen = 0;
        // Iterate every subarray
        for (int i = 0; i < nums.length; i++) {
            int zeros = 0;
            for (int j = i; j < nums.length; j++) {
                // Handle zeros count.
                if(nums[j] == 0){
                    zeros++;
                }
                if(zeros <= k){
                    // Zeros are under limit, valid subarray
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                }
                else{
                    // Zeros exceed, invalid subarray
                    break;
                }
            }
        }
        return maxLen;
    }
}
