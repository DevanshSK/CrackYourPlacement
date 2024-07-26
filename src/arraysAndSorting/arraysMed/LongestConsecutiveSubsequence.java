package arraysAndSorting.arraysMed;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    /**
     * There is an integer array ‘A’ of size ‘N’.
     * A sequence is successive when the adjacent elements of the sequence have a difference of 1.
     * You must return the length of the longest successive sequence.
     *
     * Note:
     * You can reorder the array to form a sequence.
     * For example,
     *
     * Input:
     * A = [5, 8, 3, 2, 1, 4], N = 6
     * Output:
     * 5
     * Explanation:
     * The resultant sequence can be 1, 2, 3, 4, 5.
     * The length of the sequence is 5.
     * */

    public static int longestSuccessiveElementsBetter(int []a) {
        /**
         * Here we first sort the array.
         * Then we iterate the array and maintain lastSmaller, currentCount, largestSeq;
         *
         * If our current element is greater than lastSmaller by 1, Increment currentCount and update lastSmaller.
         *
         * If out current element is equal to lastSmaller, then we have to do nothing.
         *
         * If our element differs from the lastSmaller by more than 1. We reset the currentCount and update the lastSmaller to current element.
         *
         * In the end update the longest after each iteration in the loop.
         * */

        // Sort the array
        int n = a.length;
        if (n == 0) return 0;
        Arrays.sort(a);


        int largest = 1, cnt = 0, lastSmaller = Integer.MIN_VALUE;

        // find longest sequence
        for (int i = 0; i < a.length; i++) {
            if(a[i] - 1 == lastSmaller){
                // Element is in the current sequence
                cnt += 1;
                lastSmaller = a[i];
            }
            else if(a[i] != lastSmaller){
                // Element is not in the current sequence
                cnt = 1;
                lastSmaller = a[i];
            }

            largest = Math.max(largest, cnt);
        }

        return largest;
    }

    public static int longestSuccessiveElementsOptimal(int []a) {
        /**
         * Here, we are using Set data structure.
         *  - Transfer all element into the set.
         *  - Here it will be similar to bruteforce, but we use Set properties to search.
         *  - Then iterate the set.
         *      - If previous does exist: It is not the starting of a sequence, move to next element
         *      - If previous doesn't exist: It is the starting point.
         *          - Now try to find all the next sequences.
         *          - And update the next number and count.
         *      - At the end, update the largest
         *  - Return the largest.
         *
         *  TC:
         *  SC:
         * */
        int longest = 1;
        Set<Integer> set = new HashSet<Integer>();

        // Put all elements in the set.
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        // Iterate over the set
        for (int num : set){
            // if num is a starting sequence
            if(!set.contains(num)){
                // Try to find next sequences
                int cnt = 1;
                int x = num;
                while(set.contains(x + 1)){
                    x += 1;
                    cnt += 1;
                }
                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }
}
