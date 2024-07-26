package LeetCode.BinarySearch;

public class Find_minimum_in_rotated_sorted_array_153_and_154 {
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
