package LeetCode.BinarySearch;

public class Single_Element_In_Sorted_Array_540 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int low = 1, high = n-2;
        while(low <= high){
            // Calculate Mid
            int mid = (low + high) / 2;

            // Check if mid is answer
            if((nums[mid] != nums[mid - 1]) && (nums[mid] != nums[mid+1])) return nums[mid];

            // Check for elimination
            if((mid%2==1 && nums[mid-1] == nums[mid]) || (mid%2==0 && nums[mid] == nums[mid+1])){
                // Eliminate left half
                low = mid + 1;
            }
            else{
                // Eliminate right half
                high = mid - 1;
            }
        }
        return -1;
    }
}
