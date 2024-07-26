package arraysAndSorting.arraysMed;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    /**
     * Given an array of N integers, you have to find the majority element.
     * A majority element occurs more than N/2 times in the array.
     * There is atleast one majority element present in the array.
     * */
    public int majorityElementBrute(int[] nums) {
        /**
         * Here we pick an element and count its occurences in the array
         * If the occurences is greater than N/2 then our answer is here
         * TC: O(N^2) SC: O(1)
         * */
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) count++;

                if(count > (nums.length)/2) return nums[i];
            }
        }
        return 0;
    }

    public int majorityElementBetter(int[] nums) {
        /**
         * Here we are going to store the element and their occurences in the HashMap.
         * First we iterate the array and record the iterations of the elements
         * Then, we iterate the HashMap and find the mahority element
         * TC: O(N logN) SC: O(N)
         * */
        // Create a hashmap
        HashMap<Integer, Integer> hash = new HashMap<>();

        // Count the frequency of the elements : N logN
        for(int i=0; i<nums.length; i++){
            int value = hash.getOrDefault(nums[i], 0);
            hash.put(nums[i], value+1);
        }

        // N
        for(Map.Entry<Integer, Integer> el : hash.entrySet()){
            if(el.getValue() > (nums.length / 2)){
                return el.getKey();
            }
        }

        return -1;
    }

    public int majorityElementOptimal(int[] nums){
        /**
         * Here, we are using Moore's Voting alogrithm.
         * If the array contains a majority element, its occurrence must be greater than the floor(N/2).
         * Now, we can say that the count of minority elements and majority elements is equal up
         * to a certain point in the array.
         * So when we traverse through the array we try to keep track of the count of elements and the element
         * itself for which we are tracking the count.
         *
         * After traversing the whole array, we will check the element stored in the variable.
         * If the question states that the array must contain a majority element, the stored element
         * will be that one but if the question does not state so, then we need to check if the stored element
         * is the majority element or not. If not, then the array does not contain any majority element.
         * */

        int count = 0;
        int el = 0;
        // Apply Moore's Voting Algorithm
        for(int i=0; i<nums.length; i++){
            if(count == 0){
                count = 1;
                el = nums[i];
            } else if (nums[i] == el) {
                count++;
            }
            else{
                count--;
            }
        }
        
        // Check if our answer is correct
        int cnt1 = 0;
        for (int num : nums) {
            if(num == el) cnt1++;
        }

        if(cnt1 > (nums.length / 2)) return el;

        return -1;
    }
}
