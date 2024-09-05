package arraysAndSorting.arrayHard;

import java.util.Arrays;

public class Merge2SortedArraysWithoutExtraSpace {
    /**
     *  Q.  You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
     *      and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
     *
     *      Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     *
     *      The final sorted array should not be returned by the function,
     *      but instead be stored inside the array nums1.
     *      To accommodate this, nums1 has a length of m + n,
     *      where the first m elements denote the elements that should be merged,
     *      and the last n elements are set to 0 and should be ignored.
     *      nums2 has a length of n.
     *
     *      ## Bruteforce Solution: NOT A SOLUTION
     *      - Create a third array to store the merged array.
     *      - Merge the array using 2 pointer approach.
     *      - Then override the 2 individuual arrays to the sorted array.
     *      TC: O(2(M+N))
     *      SC: O(M+N)
     *
     *      ## Optimal Solution 1
     *      - Use 2 pointers solution. Set left at last element of first arr.
     *      - Then set right at first element of second array.
     *      - Then traverse and compare elements.
     *      - If left > right : Swap and move forwards.
     *      - If left <= right : Stop, as rest of the elements are also sorted in that order.
     *
     *      # Optimal Solution 2 -> Gap method -> Shell Sort
     *      - We take gap as ciel(m+n / 2)
     *      - Then we set left ptr at start and right ptr at left+gap position.
     *      - Now we compare and traverse the array by iterating the pointers until right pointer overflows.
     *          - Compare and swap the elements.
     *          - nums[left] > nums[right] -> SWAP
     *          - Also we have to adjust for the seperate arrays.
     *          - Maybe create a helper method to swap the values.
     *      - Then, Divide and update gap by its ciel value.
     *      - Repeat this process until gap == 1;
     *      TC: O( log2(m+n) * (m+n) + N )
     *      SC: O(1)
     * */
    public static void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
    public void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n;
        // Put nums2 into nums1;
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        // Calculate the gap
        int gap = (len / 2) + (len % 2);

        // Iterate until gap is 1
        while(gap > 0){
            int left = 0;
            int right = left + gap;
            // Traverse and compare the array
            while(right < len){
                // Check for comparisons
                if (nums1[left] > nums1[right]) {
                    int temp = nums1[left];
                    nums1[left] = nums1[right];
                    nums1[right] = temp;
                }
                left++; right++;
            }
            // Update the gap.
            if(gap == 1) break;
            gap = (gap/2) + (gap % 2);
        }
    }


    public void mergeBetter(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Last element of nums1's actual data
        int j = n - 1; // Last element of nums2
        int k = m + n - 1; // Last position of nums1's total capacity

        // Merge nums1 and nums2 starting from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public void mergeBrute(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m+n];
        int index = 0;
        int left = 0;
        int right = 0;
        // Merge the array
        while(left < n && right < m){
            if(nums1[left] <= nums2[right]){
                nums3[index] = nums1[left];
                left++; index++;
            }
            else{
                nums3[index] = nums2[right];
                right++;
                index++;
            }
        }

        // Add the remaining elements
        while(left < n){
            nums3[index] = nums1[left];
            left++; index++;
        }

        while(right < m){
            nums3[index] = nums2[right];
            right++; index++;
        }

        // Replace the elements in nums1
        for(int i = 0; i< m+n; i++){
            nums1[i] = nums3[i];
        }
    }
}
