package LeetCode;

import java.util.Arrays;

public class RotateArray189 {
    // Bruteforce method
    public static void rotateRight(int[] nums, int k) {
        int[] temp = new int[k];
        int n = nums.length;
        // Filling temp
        for(int i=0; i<k; i++){
            temp[i] = nums[n-k+i];
        }


        // Shift the elements right
        for(int i= n-1; i>=k; i--){
            System.out.println(nums[i - k]);
            nums[i] = nums[i - k];
        }

        // Placing back remaining elements
        for(int i=0; i<temp.length; i++){
            nums[i] =  temp[i];
        }

    }

    public void rotate(int[] arr, int k) {
        // Leetcode solution : Rotate right
        int n = arr.length;
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;
        int[] temp = new int[k];
        for (int i = n - k; i < n; i++) {
            temp[i - n + k] = arr[i];
        }
        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }

    }

    public void reverse(int arr[], int start, int end ){
        while(start <= end){
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }

    public void rotateOptimal(int arr[], int k, int n){
        // Rotate left
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        reverse(arr, 0, n-1);

        // Rotate Right
        reverse(arr, 0, n-k-1);
        reverse(arr, n-k, n-1);
        reverse(arr, 0, n-1);
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7};
//        rotate(nums, 3);
//        System.out.println(Arrays.toString(nums));
    }
}
