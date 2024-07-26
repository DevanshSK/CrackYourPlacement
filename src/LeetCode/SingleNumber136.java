package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber136 {
    // Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    //
    //You must implement a solution with a linear runtime complexity and use only constant extra space.
    public static int bruteforce(int nums[]){   // TC:O(N^2), SC: O(1)
        // Iterate over the array and find the occurence of each occurence.
        int ans = 0;
        for(int i=0; i< nums.length; i++){
            int count = 0;
            // Perform linear search
            for(int j = 0; j< nums.length; j++)
                if(nums[j] == nums[i])  count++;

            // Check for occurence
            if(count == 1){
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

    public static int betterArrayHashing(int[] nums){   // TC: O(3N), SC:O(max)
        // Here we use hashing to store the occurence of the numbers.
        // And the hash array size is equal to maximum element + 1 (Including 0)
        int maxi = nums[0], ans = 0;
        int[] hash = new int[nums.length + 1];
        // Calculate max value
        for (int num : nums) {
            maxi = Math.max(maxi, num);
            hash[maxi] = 0;
        }

        // Precompute the frequencies
        for (int num: nums){
            hash[num]++;
        }

        // Fetch the single occurence
        for(int i=0; i<hash.length; i++){
            if(hash[i] == 1){
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static int betterHashMapSolution(int[] nums){    // TC: O(M+N), SC:O(M), where M = N/2 + 1
        // Here we use HashMap data structure.
        HashMap<Integer, Integer> hash = new HashMap<>();
        int ans = -1;
        // Set data in hashmap
        for(int num : nums){
            int value = hash.getOrDefault(num, 0);
            hash.put(num, value + 1);
        }

        // Fetch occurences from hashmap.
        for(Map.Entry<Integer, Integer> it : hash.entrySet()){
            if(it.getValue() == 1){
                ans = it.getKey();
                break;
            }
        }

        return ans;
    }


    public static int optimalXORSolution(int[] nums){
        int xor = 0;
        for(int i: nums){
            xor ^= i;
        }
        return xor;
    }
}
