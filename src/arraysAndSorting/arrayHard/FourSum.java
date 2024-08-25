package arraysAndSorting.arrayHard;

import java.util.*;

public class FourSum {
    /**
     *  Q.  Given an array nums of n integers,
     *      return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     *      0 <= a, b, c, d < n
     *      a, b, c, and d are distinct.
     *      nums[a] + nums[b] + nums[c] + nums[d] == target
     *      You may return the answer in any order.
     *
     *      # Bruteforce Solution:
     *      - Traverse through all the available queds.
     *      - Use 4 loops to iterate possible combination of quads.
     *      - Sort the quad and insert in the set for uniqye quads.
     *      TC: O(N^4)
     *      SC: O(No. of Quads) * 2
     *
     *      # Better Solution
     *      - Reduce the last loop by using hashing.
     *      - Hashset runs between j and k.
     *      - Here we calculate the last value using this formula.
     *          nums[l] = target - ( nums[i] + nums[j] + nums[k] )
     *      - Create a hashmap or hashset to search and find the last element.
     *      - After finding last element. Store the unique quad in the set.
     *      TC: O(N^3 * logN)
     *      SC: O(N + 2 * Quads)
     *
     *      # Optimal Solution
     *      - Here we try to remove the hashset to lookups.
     *      - And the set to add unique quads.
     *      - This can be done using 2 pointers and eliminate last 2 loops.
     *      - So, first sort the array.
     *      - Then pointers i and j loop through the array.
     *      - Then we define pointers k and l:
     *         - K at j+1
     *         - L at n-1 position
     *      - Only l and k move and i and j will only move in the next iteration/phase.
     *      - Add those 4 values and do accordingly:
     *         - Sum < 0: Incerase the value of k and skip duplicates.
     *         - Sum > 0: Decrease the value of l and skip duplicates.
     *         - Sum == 0:
     *             = Store the Quad
     *             = Move k and l to next element.
     *             = And skip duplicates
     *      - If k exceeds l: Move j to next element and repeat from start.
     *
     *
     * */
    public List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        // Create the answer array
        List<List<Integer>> ans = new ArrayList<>();
        // Sort the array
        Arrays.sort(nums);

        // Iterate through the array and skip duplicates
        for (int i = 0; i < nums.length; i++) {
            // Skip duplicates for i
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for (int j = i+1; j < nums.length; j++) {
                // Skip duplicates for j
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                // Setup the pointers
                int k = j +1;
                int l = nums.length - 1;

                while(k < l){
                    // Calculate the sum
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    // Move pointers accordingly
                    if(sum < target){
                        k++;
                    } else if (sum > target) {
                        l--;
                    }else{
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);
                        // Update pointers
                        k++;
                        l--;

                        // Skip duplicates for k and l
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }

        return ans;

    }

    public List<List<Integer>> fourSumBetter(int[] nums, int target) {
        // Store all unique quads
        Set<List<Integer>> ans = new HashSet<>();

        // Iterate all the 3 values
        for (int i = 0; i <nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                // HashSet for lookups for last value
                Set<Long> hash = new HashSet<>();
                for (int k = j+1; k < nums.length; k++) {
                    // Calculate the last element
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;

                    // Find the last element in hash
                    if(hash.contains(fourth)){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        temp.sort(Integer::compareTo);
                        ans.add(temp);
                    }

                    // Add the current element to hash
                    hash.add((long) nums[k]);
                }
            }
        }

        // Return the answer in arraylist
        return new ArrayList<>(ans);
    }

    public List<List<Integer>> fourSumBrute(int[] nums, int target) {
        // Store all the valid quads
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    for (int l = k+1; l < nums.length; l++) {
                        long sum = nums[i] + nums[k];
                        sum += nums[k];
                        sum += nums[l];

                        // Check the valid quad
                        if(sum == target){
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            temp.sort(null);

                            ans.add(temp);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
