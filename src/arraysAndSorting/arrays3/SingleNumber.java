package arraysAndSorting.arrays3;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    /**
     * Q.   Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     *      You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     *      # Bruteforce solution:
     *      - For every element present in the array, we will do a linear search and count the occurrence.
     *      - If for any element, the occurrence is 1, we will return it.
     *      TC: O(N^2)
     *      SC: O(1)
     *
     *      # Better Solution: Use hashing
     *      - Store the element with their frequencies.
     *      - Then, traverse the map and findout the element with single frequency.
     *      TC: O(2N)
     *      SC: O(N)
     *
     *      # Optimal Solution: Using XOR
     *      - We use these properties of XOR. a ^ a = 0 and 0 ^ a = a
     *      - Thus the xor of all the numbers will becomes the single number.
     *      - At the end, only single number remains.
     *      TC: O(N)
     *      SC: O(1)
     * */

    public int singleNumberOptimal(int[] nums){
        int xor = 0;
        for(int i : nums){
            xor = xor ^ i;
        }

        return xor;
    }

    public int singleNumberBetter(int[] nums) {
        // map to store element frequencies
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // Traverse the array and store the frequencies of the array.
        for(int i = 0; i< nums.length; i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        // Traverse the mapp and get the single frequent element
        for (Map.Entry<Integer, Integer> v: mpp.entrySet()){
            if(v.getValue() == 1){
                return v.getKey();
            }
        }

        return -1;
    }
}
