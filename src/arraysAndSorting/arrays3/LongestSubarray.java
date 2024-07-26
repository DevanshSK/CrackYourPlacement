package arraysAndSorting.arrays3;

import java.util.HashMap;

public class LongestSubarray {
    // You are given an array 'a' of size 'n' and an integer 'k'.
    // Find the length of the longest subarray of 'a' whose sum is equal to 'k'.


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