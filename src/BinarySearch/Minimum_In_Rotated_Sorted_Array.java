package BinarySearch;

public class Minimum_In_Rotated_Sorted_Array {
    /**
     * Given an integer array arr of size N, sorted in ascending order (with distinct values).
     * Now the array is rotated between 1 to N times which is unknown.
     * Find the minimum element in the array.
     * */

    public static int findMinWithDuplicates(int[] arr){
        /**
         * In case of duplicates, we have this edge case.
         * arr[low] == arr[mid] == arr[high]
         * To resolve this, we have to shrink the sample space by 1 to remove that common element.
         *
         * */
        int low = 0, high = arr.length - 1, ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high) / 2;

            // Edgecase: Remove the common duplicates.
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }

            // Optimization: If entire array is sorted
            if(arr[low] <= arr[high]){
                ans = Math.min(arr[low], ans);
                break;
            }

            // Check for sorted halves.
            if(arr[low] <= arr[mid]){
                // Left sorted
                // Update answer and eliminate
                ans = Math.min(arr[low], ans);
                low = mid + 1;
            }else{
                // Right Sorted
                ans = Math.min(arr[mid], ans);
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findMin(int []arr) {
        // Here is my approach
        /**
         * Since it is a rotated and sorted array, we have to findout the sorted half of the array.
         * And sorted half may or may not contain the final answer.
         * So we store the mimimum of sorted and eliminate the sorted half.
         * Also, we compare with it to the minimum element.
         *
         * TC: O(Logn), SC: O(1)
         * */
        int low = 0, high = arr.length - 1, ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high) / 2;

            // Optimization: If entire array is sorted
            if(arr[low] <= arr[high]){
                ans = Math.min(arr[low], ans);
                break;
            }

            // Check for sorted halves.
            if(arr[low] <= arr[mid]){
                // Left sorted
                // Update answer and eliminate
                ans = Math.min(arr[low], ans);
                low = mid + 1;
            }else{
                // Right Sorted
                ans = Math.min(arr[mid], ans);
                high = mid - 1;
            }
        }
        return ans;
    }
}
