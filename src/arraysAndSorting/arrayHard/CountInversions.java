package arraysAndSorting.arrayHard;

import java.util.ArrayList;

public class CountInversions {
    /**
     *  Q.  Given an array of integers, count the number of inversion pairs and return it.
     *      - An inversion is 2 number which follow these 2 conditions:
     *          i < j & a[i] > a[j]
     *      - Essentially the left element is greater than right element.
     *
     *      # Bruteforce Solution:
     *      - Iterate and check all the available pairs in the array.
     *      - For every element, check all elements to the right for the inversion pair.
     *      TC: O(N^2)
     *      SC: O(1)
     *
     *      # Optimal Solution: Implementing Merge sort:
     *      - We know that, in the merge sort. During the merging phase.
     *      - The left array is always to the left side of original array. And right one will always be on right side.
     *      - So i < j will always hold true.
     *
     *      - So now the problem drops down into counting pairs between 2 sorted arrays.
     *      - Take left pointer on start of left array.
     *      - And right pointer on start of right array.
     *      - Now compare these 2 elements:
     *          - left <= right : left is smaller and increment left.
     *          - Left > Right:
     *                  = An inversion pair is found, and all rest elements of left will form an inversion with right element.
     *                  = This is due to sorted nature of arrays. So we increment the counter by (mid - left + 1) and increment right.
     *      - Now repeat this for the entire merge sort operations.
     *      TC: O()
     *      SC: O()
     *
     * */
    private static int merge(long[] arr, int low, int mid, int high) {
        long[] temp = new long[high - low + 1];
        int left = low, right = mid + 1;
        int count = 0, k = 0;

        // Merge process and count inversions
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                count += (mid - left + 1);
            }
        }

        // Copy remaining elements of left subarray, if any
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements of right subarray, if any
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy sorted elements into original array
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }

        return count;
    }

    // Merge sort function to sort the array and count inversions
    private static int mergeSort(long[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;

            // Recursively sort and count inversions
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);

            // Merge sorted halves and count inversions
            count += merge(arr, low, mid, high);
        }
        return count;
    }

    // Function to count inversions in the array
    public static long inversionCount(long[] arr, int n) {
        return mergeSort(arr, 0, n - 1);
    }

    static long inversionCountBrute(long arr[], int n) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] > arr[j]) count++;
            }
        }

        return count;
    }
}
