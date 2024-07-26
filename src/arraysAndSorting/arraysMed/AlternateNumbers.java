package arraysAndSorting.arraysMed;

import java.util.ArrayList;

public class AlternateNumbers {
    /**
     * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
     *
     * You should rearrange the elements of nums such that the modified array follows the given conditions:
     *
     * Every consecutive pair of integers have opposite signs.
     * For all integers with the same sign, the order in which they were present in nums is preserved.
     * The rearranged array begins with a positive integer.
     * Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
     *
     *
     *
     * ## Bruteforce solution
     * First create two arrays, for positives and negatives
     * Then iterate the array and store the +ve and -ve elements in those arrays
     * Then Rearrange the elements based on the index position: +ve on even and -ve on odd.
     * TC: O(2N)
     * SC: O(N) for 2 arrays of N/2 size
     *
     * */

    public static int[] alternateNumbers(int []a) {
        /**
        * In this optimal approach, we are going to solve this problem in one pass as space cannot be reduced in this approach.
         * First, we create an answer array and we set pointers for even and odd position for +ve and -ve numbers
         * Iterate the original array and insert at that place and increment the pointers by 2.
         * At the end, the new array has rearranged elements.
        * */

        int[] ans = new int[a.length];
        int pos = 0, neg = 1;
        for (int i = 0; i < a.length; i++) {
            if(a[i] < 0){
                ans[neg] = a[i];
                neg += 2;
            }else {
                ans[pos] = a[i];
                pos += 2;
            }
        }

        return ans;

    }

    public static int[] secondVarient(int[] a){
        /**
         * Here, the numbers of +ve and -ve elements may not be equal.
         * So, we have to make use of bruteforce solution and then add the remaining elements.
         * */
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0)
                pos.add(a[i]);
            else
                neg.add(a[i]);
        }
        // If positives are lesser than the negatives.
        if (pos.size() < neg.size()) {

            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                a[2*i] = pos.get(i);
                a[2*i + 1] = neg.get(i);
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                a[index] = neg.get(i);
                index++;
            }
        }
        else{
            // Negatives are less than positives

            // Add them alternatively till the point where all positive and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                a[2*i] = pos.get(i);
                a[2*i + 1] = neg.get(i);
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                a[index] = pos.get(i);
                index++;
            }
        }
        return a;
    }
}
