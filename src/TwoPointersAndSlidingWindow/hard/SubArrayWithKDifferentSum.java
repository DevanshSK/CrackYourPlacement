package TwoPointersAndSlidingWindow.hard;

import java.util.HashMap;
import java.util.HashSet;

public class SubArrayWithKDifferentSum {
    /**
     *  Q.  Given an integer array nums and an integer k, return the number of good subarrays of nums.
     *      A good array is an array where the number of different integers in that array is exactly k.
     *          For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
     *      A subarray is a contiguous part of an array.
     *
     *      # Bruteforce Solution:
     *      - Generate all the subarrays.
     *      - Use hashmap/sets to maintain count of distinct elements.
     *      - Count only those subarrays with sum == k
     *      TC: O(N^2)  // TLE error.
     *      SC: O(N)
     *
     *      # Optimal Solution: Find count of subarrays with <condition> == K
     *      - Converting the problem into this format:
     *          "Find the count of subarrays with <condition> <= K"
     *      - Then, Required count can be obtained via:
     *              count = F(nums, K) - F(nums, k-1)
     *
     *      - Note: We have one observation:
     *          - On expansion, the element will itself be a subarray and its previous subarrays.
     *          - So the count of subarrays will increment with [Length of window]
     * */

    public int atMost(int[] nums, int k){
        int l=0, r=0, count=0;
        // Hashmap to record frequencies
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // Begin sliding window
        while(r < nums.length){
            // Add element to map
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0) + 1);

            // Handle shrinking condition.
            while(mpp.size() > k){
                mpp.replace(nums[l], mpp.getOrDefault(nums[l], 0) - 1);
                if(mpp.get(nums[l]) == 0) mpp.remove(nums[l]);
                l++;
            }

            // Incrementing valid subarrays count
            count += r-l+1;
            r++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int [] nums, int k){
        return atMost(nums, k) - atMost(nums, k-1);
    }

    public int subarraysWithKDistinctBrute(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> st = new HashSet<>();
            for (int j = i; j < nums.length ; j++) {
                // Add number to set
                st.add(nums[j]);
                if(st.size() == k) count++;
                else if (st.size() > k) break;
            }
        }
        return count;
    }
}
