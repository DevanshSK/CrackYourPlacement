package LeetCode.BinarySearch;

public class Find_Peak_Element_162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        // Edge cases
        if(n==1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        // Starting binary search.
        int low = 1, high = n-2;
        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if(nums[mid] > nums[mid - 1]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
