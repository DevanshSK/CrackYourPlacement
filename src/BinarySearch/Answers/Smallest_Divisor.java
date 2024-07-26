package BinarySearch.Answers;

public class Smallest_Divisor {
    /**
     * You are given an array of integers 'arr' and an integer 'limit'.
     * Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it, the sum of the division's result is less than or equal to the given integer's limit.
     * Note:
     * Each result of the division is rounded to the nearest integer greater than or equal to that element. For Example, 7/3 = 3.
     * */
    public static int smallestDivisorBrute(int[] nums, int limit){
        // Bruteforce Solution: Use Linear Search, and sum the numbers after dividing these numbers by that number.
        // TC: O(N^2)
        // SC: O(1)

        // Optimal Solution: Use same strategy for binary search.
        // The range should be fall under 1-Maximum element.
        // TC: O(N x logN)
        // SC: O(1)

        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        // Find maximum element
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi, nums[i]);
        }

        int low = 1, high = maxi;
        while(low <= high){
            int mid = (low + high) / 2;

            // Calculate sum of divisors
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.ceil((double) nums[i] / (double) mid);
            }

            if(sum <= limit){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
