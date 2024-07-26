package arraysAndSorting.arrays1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Arrays1 {
    public static int secondLargest(int[] arr, int n){
        int large = Integer.MIN_VALUE;
        int s_large = Integer.MIN_VALUE;

        for(int i = 0; i< n;i++){
            if(arr[i] > large){
                s_large = large;
                large = arr[i];
            }
            else if(arr[i] > s_large && arr[i] != large){
                s_large = arr[i];
            }
        }
        return s_large;
    }
    public static int secondSmallest(int[] arr, int n){
        int small = Integer.MAX_VALUE;
        int s_small = Integer.MAX_VALUE;

        for(int i=0; i< n; i++){
            if(arr[i] < small){
                s_small = small;
                small = arr[i];

            }
            else if(arr[i] < s_small && arr[i] != small){
                s_small = arr[i];
            }
        }
        return s_small;
    }

    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.

        int slargest = secondLargest(a, n);
        int ssmallest = secondSmallest(a, n);
        return new int[]{slargest, ssmallest};
    }
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
    public static void main(String[] args) {

    }
}
