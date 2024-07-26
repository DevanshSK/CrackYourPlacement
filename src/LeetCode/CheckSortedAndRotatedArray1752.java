package LeetCode;

public class CheckSortedAndRotatedArray1752 {
    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        // Check how many element pairs break the order
        for(int i = 0; i <= n-2; i++ ){
            if(nums[i] > nums[i+1]){
                count++;
            }
        }
        // Also check if last and first element break the order
        if(nums[n-1] > nums[0]){
            count++;
        }
        System.out.println(count);
        // If order is less than 1, then true
        return count < 2;
    }


    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        int[] arr2 = {2, 1, 3, 4};
        System.out.println(check(arr));
        System.out.println(check(arr2));
    }
}