package LeetCode.BinarySearch;

public class FirstAndLastPosition34 {
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
    public int[] searchRange(int[] nums, int target) {
        int first = firstOcc(nums, target);
        int last = lastOcc(nums, target);
        return new int[] {first, last};
    }
}
