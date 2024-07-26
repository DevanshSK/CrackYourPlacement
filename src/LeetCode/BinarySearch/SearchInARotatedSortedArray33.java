package LeetCode.BinarySearch;

public class SearchInARotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;


            if(nums[low] <= nums[mid]){
                // Left part is sorted
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                // Right part is sorted
                if(nums[high] >= target && nums[mid] <= target ){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
