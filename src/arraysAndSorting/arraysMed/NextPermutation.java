package arraysAndSorting.arraysMed;

import java.util.Collections;
import java.util.List;

public class NextPermutation {
    /**
     * Given an array of integer, you have to rearrange it into lexicographically next permutation of numbers.
     *
     * If no permutation is possible, rearrange it to lowest possible order. (Ascending order)
     *
     * Bruteforce-> TC:(N! * N) High order of TC
     * Here, we are going to first create all permutations and then find the next permutation of the array by using linear search.
     *
     * Better solution -> Only possible in C++ STL
     * We have a function named next_permutation() which rearranges the array into next permutation order.
     * Not enough
     * */

    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        /**
         * Optimal Solution:
         * */

        // Finding the breakpoint with longest common prefix
        int index = -1;
        int n = A.size();
        for(int i = n-2; i>=0; i--){
            if(A.get(i) < A.get(i+1)){
                // Breakpoint is found
                index = i;
                break;
            }
        }

        // If our permutation is last permutatino, go to first permutation (ascending sorted)
        if(index == -1){
            Collections.reverse(A);
            return A;
        }

        // Find smallest greatest number than the dip
        for(int i = n-1; i>index; i--){
            if(A.get(i) > A.get(index)){
                Collections.swap(A, i, index);
                break;
            }
        }

        // Now reverse the remaining elements
        List<Integer> sublist =  A.subList(index+1, n);
        Collections.reverse(sublist);

        return A;
    }
}
