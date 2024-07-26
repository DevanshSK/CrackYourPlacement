package arraysAndSorting.arraysMed;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
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


    public static String Optimal(int n, int [] book, int target){
        // Here we are using 2 pointer approach which do not use extra memory.
        // First, we sort the array, then we use greedy to detect the pair using 2 pointers
        Arrays.sort(book);

        // Creating pointers
        int left = 0, right = n-1;

        // Iteration 1
        for(int i = 0; i<n; i++){
            int sum = book[left] + book[right];
            if(sum == target){
                return "YES";
            }

            if(sum < target){
                left++;
            }else{
                right--;
            }
        }


        return "NO";
    }
}
