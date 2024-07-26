package BinarySearch;

public class How_many_times_array_is_rotated {
    public static int findKRotation(int []arr){
        /**
         *  Here, we are following a similar approach.
         *  We observe that, here the index of mimimum element is equal to the times of rotations in the array.
         *  So we just have to store the index and call it a day.
         *
         * */
        int low = 0, high = arr.length - 1, ans = Integer.MAX_VALUE, index = -1;
        while(low <= high){
            int mid = (low + high) / 2;

            // Optimization: If entire array is sorted
            if(arr[low] <= arr[high]){
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }

            // Check for sorted halves.
            if(arr[low] <= arr[mid]){
                // Left sorted
                // Update answer and eliminate
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            }else{
                // Right Sorted
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
