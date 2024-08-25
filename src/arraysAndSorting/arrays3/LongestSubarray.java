package arraysAndSorting.arrays3;

import java.util.HashMap;

public class LongestSubarray {

    /**
     *  Q.  You are given an array 'a' of size 'n' and an integer 'k'.
     *      Find the length of the longest subarray of 'a' whose sum is equal to 'k'.
     *
     *      NOTE: The array contains only POSITIVES.
     *
     *      # Bruteforce solution.
     *      - Generate all the subarrays.
     *      - Then calculate the sum of the subarray.
     *      - When the sum equals K, update the max length.
     *      TC: O(N^3)
     *      SC: O(1)
     *
     *      ### Certain Optimizations:
     *      - Calculate the sum as we generate the next subarray from an element.
     *      - Stop generating subarrays when sum excceds K.
     *      - As the subsequent subarrays will also exceed K.
     *      TC: O(N^2)
     *      SC: O(1)
     *
     *      # Better Solution: Using Prefix sum
     *      - First we store all the sum values at an index in a map.
     *      - For each index of I:
     *          - Add current element to prefixSum
     *          - Update maxLen when sum == k
     *          - Generate remaining sum and if it exist in map
     *          - the length of the subarray will be i - mpp.get(x-k)
     *          - Insert the sum in the map, if it doesnot exist here.
     *      TC: O(N)
     *      SC: O(N)
     *
     *      # Optimal Solution: Using Sliding window
     *      - We have 2 pointers right and left, representing a sliding window.
     *      - Until r < length: R increases and increments the window.
     *          - Here we update the sum and update the maxLen.
     *      - If sum > k: Shrinking phase begin.
     *          - move left pointer of window and remove that element form the sum
     *      - Then update the max len.
     *      TC: O(2N)
     *      SC: O(1)
     *
     *      NOTE: If array contains both POSITIVES and NEGATIVES.
     *
     *      # Bruteforce solution:
     *      - Generate all the subarrays with two loops and store the maximum with sum == k
     *      - Here, we cannot break when sum > k, as negatives will decrease the sum.
     *      TC: O(N^2)
     *      SC: O(1)
     *
     *      # Optimal Solution: Using Prefix sum
     *      - As there are negatives, sliding window will fails.
     *      - So we have to use prefix sum to use
     * */

    public static int brutelongestSubarrayWithSumK(int[] a, long k) {
        // Here we create all the possible subarrays and find out required arrays.

        // Approach 1:  TC:O(N^3), SC: O(1)
        // Here time complexity can be optimized in next approach
        /*
        int len = 0;
        for(int i = 0; i< a.length; i++){
            for(int j = i; j<a.length; j++){
                // Store the subarray.
                int sum = 0;
                for(int m=i; m<=j; m++){
                    sum += a[m];
                }
                // Check if our subarray is correct
                if(sum == k) len = Math.max(len, j-i+1);
            }
        }
        */


        // Approach 2: TC: O(N^2)
        // From observation, the sum of next subarray is just next element + previous sum.
        // So inner loop is removed.
        int len = 0;
        for(int i=0; i<a.length; i++){
            int sum = 0;
            for(int j=i; j<a.length; j++){
                sum += a[j];    // Increment the sum
                // Check current subarray
                if(sum == k) len = Math.max(len, j-i+1);
            }
        }
        return len;
    }

    public static int betterlongestSubarrayWithSumK(int []a, long k) {
        // For negatives and zero, This is an optimal solution.
        // Write your code here
        HashMap<Long, Integer> preSumMap = new HashMap<Long, Integer>();
        long sum = 0;
        int maxLen = 0;
        // Go through the array
        for(int i = 0; i< a.length; i++){
            sum += a[i];

            // Check sum of the subarray
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }

            // Check remaining sum
            long rem = sum - k;
            if(preSumMap.containsKey(rem)){
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }


            if(!preSumMap.containsKey(sum)){
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }

    public static int OptimallongestSubarrayWithSumK(int []a, long k) { // Applicable for positive integers
        int maxLen = 0;
        int sum = a[0], left = 0, right = 0;
        int n = a.length;

        // Loop over the array
        while(right < n){

            // sum exceeds k
            while(left <= right && sum > k){
                sum -= a[left];
                left++;
            }

            // sum == k
            if(sum == k){
                maxLen = Math.max(right - left + 1, maxLen);
            }
            // Sum less than k
            right++;
            if (right < n) sum += a[right];

        }
        return maxLen;
    }
}