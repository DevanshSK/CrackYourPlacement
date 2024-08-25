package arraysAndSorting.arrayHard;

import java.util.*;

public class ThreeSum {
    /**
     * Q. Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets.
     *
     * # Bruteforce Solution:
     * - Run through all the combinations and check if the sum is equal to the target.
     * - Create a DS to store unique triplets.
     * - Run three loops to iterate the arrays.
     * - Now compare the sum of the triplets with the target.
     * - Store unique triplets by using sets.
     * - Sort the triplet and add it to the set.
     *  TC: O(N^3)
     *  SC: O(2 * Number of triplets)
     *
     *  # Better Solution:
     *  - Here we use hashing to reduce TC upto N^2.
     *  - We can find the third element by this formula.
     *      arr[k] = -( arr[i] + arr[j] )
     *  - Then we lookup this third value.
     *  - Also to remove duplicacy, we do not consider the values of i and j in the hashmap.
     *  - If the third value is present, Sort and store the unique element in the Set.
     *  - Then add the current value of j in hashmap.
     *  TC: O(N^2 * )
     *  SC: O(N)
     *
     *  # Optimal Solution
     *  - Here we utilize two pointers and try to remove the sets and lookups.
     *  - So, first sort the array.
     *  - Then we define pointers i,j,k:
     *      - Initially i at 0
     *      - J at i+1 position
     *      - k at end position
     *  - Only j and k move and i will only move in the next iteration/phase.
     *  - Add those 3 values and do accordingly:
     *      - Sum < 0: Incerase the value of j to non duplicate element.
     *      - Sum > 0: Decrease the value of k until non duplicate value.
     *      - Sum == 0:
     *          = Store the triplet
     *          = Move j and k to next element.
     *  - If j exceeds k: Move i to next element and repeat from start.
     *  TC: O(NLogN + N^2)
     *  SC: O(Number of Unique Triplets)
     *
     * */
    public List<List<Integer>> threeSumOptimal(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        // Sort the array: NlogN
        Arrays.sort(nums);

        // Iterate through the sorted array
        for (int i = 0; i < nums.length; i++) {
            // Increment until next unique element.
            // Exception: First element.
            if(i != 0 && nums[i] == nums[i-1]) continue;

            // Setup the rest 2 pointers
            int j = i + 1;
            int k = nums.length - 1;
            // Iterate until these pointers meet
            while(j < k){
                // Calculate the sum
                int sum = nums[i] + nums[k] + nums[k];
                // Move pointers accordingly
                if(sum < 0){    // Move J
                    j++;
                }
                else if(sum > 0){   // Move K
                    k--;
                }
                else{   // Found the unique triplet.
                    // Insert the triplet in resultant list.
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    // Update the pointers.
                    j++;
                    k--;

                    // Skip duplicates values.
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k - 1]) k--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSumBetter(int[] nums){
        // Store unique triplets
        Set<List<Integer>> st = new HashSet<>();

        // Traverse and find for each element.
        for (int i = 0; i < nums.length; i++) {
            // Hash to store and find third value.
            Set<Integer> hash = new HashSet<>();
            // Iterate the second element
            for (int j = i+1; j < nums.length; j++) {
                // Calculate the third element
                int third = -(nums[i] + nums[j]);

                // Check the element in the hash
                if(hash.contains(third)){
                    // Store the triplet in the hashMap
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                // Add the current element to hash.
                hash.add(nums[j]);
            }
        }

        return new ArrayList<>(st);
    }

    public List<List<Integer>> threeSumBrute(int[] nums) {
        // Set to store unique triplets
        Set<List<Integer>> st = new HashSet<>();

        // Iterate all the triplets using 3 loops.
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    // Check for valid triplet
                    if(nums[i] + nums[j] + nums[k] == 0){
                        // Sort and store unique triplet
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        temp.sort(null);

                        st.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(st);

    }
}
