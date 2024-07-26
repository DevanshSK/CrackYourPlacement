package LeetCode;

public class Rearrange_Element_By_Sign_Med_2149 {
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
}
