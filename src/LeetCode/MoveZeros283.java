package LeetCode;

public class MoveZeros283 {
    public void moveZeroes(int[] nums) {
        // Step 1: Find the first zero
        int j = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                j = i;
                break;
            }
        }

        // If no zero found, then return
        if(j == -1) return;

        // Step 2: Iterate remaing array and move zeros to end
        for(int i = j+1; i<nums.length; i++){
            if(nums[i] != 0){
                // Swapping elements
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // Move to next zero
                j++;
            }
        }
    }
}
