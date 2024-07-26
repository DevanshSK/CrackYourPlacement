package BinarySearch;

import java.util.ArrayList;

public class SearchInRotatedSortedArray {

    public static boolean searchInARotatedSortedArrayII(int []A, int key) {
        // Here duplicates are also present, so we have to confirm the element this array.
        // This created a edge case where it casues some problems.
        // A[low] == A[mid] == A[high]
        // To overcome this, we update the values of low and high and skip the iteration.
        // TC:
        // SC:
        int low = 0, high = A.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;

            // target is found;
            if(A[mid] == key) return true;

            // Edge case, all same values
            if(A[low] == A[mid] && A[mid] == A[high]){
                // Update values and skip iteration.
                low = low + 1;
                high = high - 1;
                continue;
            }

            if(A[low] <= A[mid]){
                // Left part is sorted
                if(A[low] <= key && key <= A[mid]){
                    // Element exist in left half.
                    high = mid - 1;
                }
                else{
                    // Element exist in right half.
                    low = mid + 1;
                }
            } else{
                // Right part is sorted
                if(A[mid] <= key && key <= A[high]){
                    // Element exist in right half.
                    low = mid + 1;
                }
                else{
                    // Element exist in left half.
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static int search(ArrayList<Integer> arr, int n, int k) {
        // We are using BinarySearch here as the array is sorted and we have to search.
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high) / 2;
            // Target is found
            if(arr.get(mid) == k)   return mid;

            // Checking which part to go
            if(arr.get(low) <= arr.get(mid)){
                // Left subarray is sorted
                if(arr.get(low) <= k && k <= arr.get(mid)){
                    // GOTO left
                    high = mid-1;
                }
                else{
                    // GOTO right
                    low = mid + 1;
                }
            }else{
                // Right subarray is sorted
                if(arr.get(mid) <= k && k <= arr.get(high)){
                    // GOTO right
                    low = mid + 1;
                }
                else{
                    // GOTO left
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
