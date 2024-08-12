package arraysAndSorting.arrays1;

import java.util.ArrayList;

public class RemoveDuplicates {
    /**
     * Q.   Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
     *      The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
     *      Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
     *
     *      Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
     *      The remaining elements of nums are not important as well as the size of nums.
     *      Return k.
     *
     *
     *      # Bruteforce Solution:
     *      - Store all elements in a set and update the values.
     *      TC: O(N*log(N) + N)
     *      SC: O(N)
     *
     *      # Optimal SOlution
     *      - Use 2 pointers to solve this problem.
     *      - Keep a pointer to track the unique elements
     *      = And use 2nd pointer to traverse and find unique elements
     *      - If unique is found: Then update this at start and update pointer.
     *      TC: O(N)
     *      SC: O(1)
     * */

    public static int removeDuplicates(ArrayList<Integer> arr){

        // Bruteforce approach
        // Create a set and iterate the array
//        Set<Integer> st = new HashSet<Integer>();
//        for(int i=0; i<arr.size(); i++){
//            st.add(arr.get(i));
//        }
//        // Now replace the unique numbers in array
//        int count = 0;
//        for(int i : st){
//            arr.set(count++, i);
//        }
//        // return the length
//        return count;


        // Optimised Approach
        // Use 2 pointer approach
        int i = 0;
        for(int j = 1; j < arr.size(); j++){    // Iterate the array
            if(!arr.get(j).equals(arr.get(i)) ){    // Check if current element is unique or not
                // Unique found
                arr.set(i+1, arr.get(j));   // Set unique to next position
                i++;    // Move i to next position
            }
            // Unique not found
        }
        return i+1;

    }
}
