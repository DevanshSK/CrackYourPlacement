package BinarySearch;

public class CountOccurences {
    static int firstOcc(int[] nums, int target){
        int first = -1, low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            // can be an answer
            if(nums[mid] == target){
                first = mid;
                // Go to left
                high = mid - 1;
            }
            else if(nums[mid] < target){
                // Too low, go to right
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return first;
    }
    static int lastOcc(int[] nums, int target){
        int last = -1, low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                // Can be our desired number.
                last = mid;
                // Search to right
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return last;
    }

    public static int count(int arr[], int n, int x) {
        // Bruteforce solution using a linear search and counter;
        // TC: O(N), SC: O(1)
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // counting the occurrences:
            if (arr[i] == x) cnt++;
        }
        return cnt;
    }
    public static int countOptimal(int arr[], int n, int x) {
        // This is an optimal approach using first and last occurence using binary search
        // TC: 2*O(log2N), SC: O(1)
        int first = firstOcc(arr, x);
        int last = lastOcc(arr, x);

        // If element is not found in array
        if(first == -1) return 0;

        return last - first + 1;
    }
}
