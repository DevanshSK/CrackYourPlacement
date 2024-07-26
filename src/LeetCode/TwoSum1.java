package LeetCode;
import java.util.HashMap;

public class TwoSum1 {
    public int[] BetterTwoSum(int[] nums, int target) {
        // In bruteforce, Here we check each pair for each element. TC: O(N^2)

        // But better approach is by using hashing. Which uses linear time complexity.
        // Here we check if the remaining element to complete pair exists in the array.

        // Here, If we use 2 pointers, we need another data structure to store (element,index) mappings. So this cannot can be optimized.

        // Store the elements with the index.
        HashMap<Integer, Integer> hash = new HashMap<>();
        // Create answer array
        int[] ans = new int[2];

        // Iterate and check the pairs
        for(int i=0; i< nums.length; i++){
            // Check remaining element
            int rem = target - nums[i];

            // Check remaining exists
            if(hash.containsKey(rem)){
                // Pair present
                ans[0] = i;
                ans[1] = hash.get(rem);
                break;
            }

            // Add current element to hashmap
            hash.put(nums[i], i);
        }

        // Return the answer
        return ans;

    }
}
