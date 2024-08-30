package arraysAndSorting.arrayHard;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithXORK {
    /**
     *  Q. Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.
     *
     *  # Bruteforce solution
     *  - Traverse all possible subarrays and count the valid subarrays.
     *  TC: O(N^3)
     *  SC: O(1)
     *
     *  # Better Solution:
     *  - Reduce the last loop by calculating xor as we traverse the subarrays.
     *  TC: O(N^2)
     *  SC: O(1)
     *
     *  # Optimal Solution:
     *  - We know that, a subarray has a starting point and an ending point.
     *  - So if we consider a subarray ending at a point. So:
     *      - Whole xor of subarray from starting = XR
     *      - XOR of desired subarray = K
     *      - XOR os remaining elements from start = X
     *
     *      - Then, X ^ K = XR
     *      - XOR both sides: X = XR ^ K
     *  - Then, we traverse and store the xor of elements from start along with their occurences in a hashmap.
     *  - We check if the remaining xor is already traversed or not.
     *  - Then we update the count by its occurences.
     * */

    public int solve(int[] nums, int K) {
        int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(xr, 1);
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            xr = xr ^ nums[i];
            // We are looking for k
            // Find the remaining element
            int x = xr ^ K;

            count += mpp.getOrDefault(x, 0);
            mpp.put(xr, mpp.getOrDefault(xr, 0) + 1);
        }
        return count;
    }
}
