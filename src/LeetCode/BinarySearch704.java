package LeetCode;

public class BinarySearch704 {
    // Recursive bianry search
    public int bs(int[] nums, int low, int high, int target){
        if(low > high) return -1;
        int mid = low + (high - low)/2;
        if(nums[mid] == target) return mid;
        else if(target > nums[mid]) return bs(nums, mid + 1, high, target);
        return bs(nums, low, mid - 1, target);
    }
    public int search(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target);
    }
}
