package arraysAndSorting.arraysMed;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /**
     *  Q.  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *      You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *      You can return the answer in any order.
     *
     *      # Bruteforce Solution:
     *      - For every element, search every element in the array.
     *      - Then we store and return the indices.
     *      TC: O(N^2)
     *      SC: O(1)
     *
     *      # Better Solution:
     *      - In previous solution, we search the remaining element from the array.
     *      - Instead use hashing to search remaining elements in the map.
     *      - Search the map for remaining and check for target.
     *      - Then add the current element.
     *      TC: O(N)
     *      SC: O(N)
     *
     *      # Optimal Solution
     *      - Use two pointers to find pair in linear time with no space.
     *      - Here we first sort the array and find pairs with greedy way.
     *      - Then we set left pointer at start and right at end.
     *      - Useful when we want to only check the valid pair.
     *      - Then we check the sum with target:
     *          - sum == target: pair found at [left, right]
     *          - sum < target: increase sum [left++]
     *          - sum > target: decrease sum [right++]
     *      TC: O(N)
     *      SC: O(1)
     *
     * */

    public int[] twoSumOptimal(int[] nums, int target){
        // Create a result array.
        int[] res = new int[2];
        res[0] = res[1] = -1;

        // Initialize the pointers.
        Arrays.sort(nums);

        // Initialize the pointers
        int left = 0, right = nums.length - 1;

        while(left < right){
            int sum = nums[left] + nums[right];

            if(sum == target){
                res[0] = left;
                res[1] = right;
                return res;
            }

            if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }

        return res;
    }
    public int[] twoSumBetter(int[] nums, int target){
        // Initialize a hashmap to store the values with their indices.
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int[] res = new int[2];
        res[0] = res[1] = -1;

        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            // Check remaining element.
            int remaining = target - num;

            // Search the remaining element
            if(mpp.containsKey(remaining)){
                // Update the remaining.
                res[0] = mpp.get(remaining);
                res[1] = i;
                break;
            }

            mpp.put(num, i);
        }

        return res;
    }
    public int[] twoSum(int[] nums, int target) {
        // Initialize a result array
        int[] res = new int[2];
        res[0] = res[1] = -1;
        boolean flag = false;

        for (int i = 0; i < nums.length; i++) {
            if(flag) break;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    flag = true;
                    break;
                }
            }
        }
        return res;
    }

    public static String Better(int n, int []book, int target){
        // In bruteforce, Here we check each pair for each element. TC: O(N^2)

        // But better approach is by using hashing. Which uses linear time complexity.
        // Here we check if the remaining element to complete pair exists in the array.
        // Store the elements with the index.
        HashMap<Integer, Integer> hash = new HashMap<>();

        // Iterate and check the pairs
        for(int i=0; i<n; i++){
            // Check remaining element
            int rem = target - book[i];

            // Check remaining exists
            if(hash.containsKey(rem)){
                // Pair present
                return "YES";
            }

            // Add current element to hashmap
            hash.put(book[i], i);
        }

        // If not found, return NO
        return "NO";

    }


//    public static String Optimal(int n, int [] book, int target){
//        // Here we are using 2 pointer approach which do not use extra memory.
//        // First, we sort the array, then we use greedy to detect the pair using 2 pointers
//        Arrays.sort(book);
//
//        // Creating pointers
//        int left = 0, right = n-1;
//
//        // Iteration 1
//        for(int i = 0; i<n; i++){
//            int sum = book[left] + book[right];
//            if(sum == target){
//                return "YES";
//            }
//
//            if(sum < target){
//                left++;
//            }else{
//                right--;
//            }
//        }
//
//
//        return "NO";
//    }
}
