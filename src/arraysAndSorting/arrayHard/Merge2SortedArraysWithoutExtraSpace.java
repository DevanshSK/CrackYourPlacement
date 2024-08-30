package arraysAndSorting.arrayHard;

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
     *      ## Optimal Solution
     *
     *
     * */

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
