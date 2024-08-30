package arraysAndSorting.arrayHard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
    /**
     *  Q.  Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     *
     *  ## Important Observation:
     *  - There are at maximum only 2 majority elements which are greater then N/3.
     *  - Because, if a third element want to become majority, it needs more than n/3 occurences.
     *  - In that case the number of elements exceed the array elements.
     *
     *  # Bruteforce Solution
     *  - Iterate and count occurences for all the elements.
     *  - Store those occurences in a list and return it.
     *  TC: O(N^2)
     *  SC: O(1)
     *
     *  # Better Solution:
     *  - We use hashing to reduce TC to linear time.
     *  - We iterate the array and store the elements and frequencies in the hashmap.
     *  - Also if the frequency exceed N/3 -> Add it to list.
     *  TC: O(N)
     *  SC: O(N)
     *
     *  # Optimal Solution
     *  - Use and modify moore voting algo for N/3 elements.
     *  - First we add states for tracking 2 elements.
     *  - Then also make sure that, the two elements are unique and appear more than N/3 times.
     *  - Then after that, apply manual checks to conisder majority element.
     *  TC: O(2N)
     *  SC: O(1)
     *
     * */

    public List<Integer> majorityElementOptimal(int[] nums) {
        // Define states for majority element
        int count1 = 0, count2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if(count1 == 0 && nums[i] != el2){
                count1 = 1;
                el1 = nums[i];
            }
            else if(count2 == 0 && nums[i] != el1){
                count2 = 1;
                el2 = nums[i];
            }
            else if(el1 == nums[i]) {
                count1++;
            }
            else if(el2 == nums[i]) {
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        // Manual check for true majority.
        List<Integer> ls = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if(el1 == nums[i]) count1++;
            if(el2 == nums[i]) count2++;
        }
        int mini = (n/3) + 1;
        if(count1 >= mini) ls.add(el1);
        if(count2 >= mini) ls.add(el2);
        return ls;
    }

    public List<Integer> majorityElementBetter(int[] nums) {
        // List for storing the majority elements
        List<Integer> ls = new ArrayList<>();
        int n = nums.length;
        // Hashmap to record frequencies.
        Map<Integer, Integer> mpp = new HashMap<>();
        // Minimum frequency for an element to become majority element.
        int mini = (n/3) + 1;

        // Iterate the array
        for(int i = 0; i<n; i++){
            // Add frequency to hashmap
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);

            // If current element is majority
            if(mpp.get(nums[i]) == mini){
                ls.add(nums[i]);
            }
        }

        return ls;
    }

    public List<Integer> majorityElementBrute(int[] nums) {
        // List for storing majority element
        List<Integer> ls = new ArrayList<>();
        int n = nums.length;

        // Iterate the array
        for(int i = 0; i < n; i++){
            // Check if list is empty or element is not same
            if(ls.size() == 0 || ls.get(0) != nums[i]){
                // Count and check the occurences
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if(nums[j] == nums[i]) count++;
                }
                // Check the majority condition
                if(count > n/3){
                    ls.add(nums[i]);
                }
            }
            // Both majority elements are found
            if(ls.size() == 2) break;
        }
        return ls;
    }
}
