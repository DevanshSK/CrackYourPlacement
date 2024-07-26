package arraysAndSorting.arraysMed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInAnArray {
    /**
     * There is an integer array &lsquo;a&rsquo; of size &lsquo;n&rsquo;.
     * An element is called a Superior Element if it is greater than all the elements present to its right.
     * You must return an array all Superior Elements in the array &lsquo;a&rsquo;.
     *
     * Note:
     * The last element of the array is always a Superior Element.
     *
     * Example
     * Input: a = [1, 2, 3, 2], n = 4
     * Output: 2 3
     *
     * Explanation:
     * a[ 2 ] = 3 is greater than a[ 3 ]. Hence, it is a Superior Element.
     * a[ 3 ] = 2 is the last element. Hence, it is a Superior Element.
     * The final answer is in sorted order.
     *
     *
     * ## Bruteforce solution:
     * -> We check wether each element is a leader in an array.
     * -> If any element is greater than the current, It is not a leader.
     * -> If leader is found at the end, we insert it into our resultant array.
     *
     * TC : nearly about O(N^2)
     * SC: O(N) for storing the output.
     * */
    public static List< Integer > superiorElementsOptimal(int []a) {
        /**
         * Here, we optimize the time complexity.
         * first we iterate from the right, as the last element is already a leader.
         * Then we check if the current element is greater than the maximum element from the right.
         * In this way, we can complete this task in a single pass.
         * */
        List<Integer> ans = new ArrayList<Integer>();
        int n = a.length;
        int maximum = Integer.MIN_VALUE;

        for(int i = n-1; i >= 0; i--){
            if(a[i] > maximum){
                // element is a leader
                ans.add(a[i]);
            }

            // Update the maximum
            maximum = Integer.max(maximum, a[i]);
        }
        // Sort the leaders in sorted format.
        Collections.sort(ans);
        // Return the ans.
        return ans;
    }
}
