package BinarySearch;

public class BinarySearch01 {
    public static int searchIterative(int []nums, int target) {
        // Iterative Code
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }


    public static int f(int[] nums, int low, int high, int target){
        if(low > high)  return -1;
        int mid = (low + high) / 2;

        if(nums[mid] == target) return mid;
        else if(target > nums[mid]) f(nums, mid+1, high, target);
        return f(nums, low, mid - 1, target);
    }
    public static int searchRecursive(int[] nums, int target){
        return f(nums, 0, nums.length - 1, target);
    }
}
