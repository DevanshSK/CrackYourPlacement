package LeetCode.BinarySearch;

public class SearchInRotatedSortedArrayII_81 {
    public boolean search(int[] A, int key) {
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
}
