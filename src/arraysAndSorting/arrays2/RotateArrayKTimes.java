package arraysAndSorting.arrays2;

import java.util.ArrayList;

public class RotateArrayKTimes {
    /**
     * Q. Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     *
     *  # Bruteforce solution:
     *  - copy last k elements in temp array
     *  - shift n-k elements from beginning to the k steps
     *  - copy elements into the main array from temp array
     *  TC: O(2N)
     *  SC: O(N)
     *
     *  # Optimal Solution: Use reversal algorithm
     *      Note: This uses a function to reverses an array between 2 points.
     *      - It uses 3 steps.
     *      - Reverse the last k elements
     *      - Reverse the first n-k elements
     *      - Reverse the entire array
     *
     *      TC: O(3N)
     *      SC: O(1)
     * */

    public static void Rotate(int[] nums, int start, int end){
        // Reverses the entire array
        while(start <= end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // Rotate the first n-k elements
        Rotate(nums, 0, n-k-1);
        // Rotate the last k elements
        Rotate(nums, n-k, n-1);
        // Rotate the entire array
        Rotate(nums, 0, n-1);
    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        // Write your code here.
        // taking elements in temp
        int d = k % arr.size();
        ArrayList<Integer> temp = new ArrayList<>();
        // Store k element in temp array
        for(int i=0; i<d; i++){
            temp.add(arr.get(i));
        }

        // Shifting elements
        for(int i=0; i< arr.size()-d; i++){
            arr.set(i, arr.get(i+d));
        }

        // Placing back elements;
        for(int i=0; i<d; i++){
            arr.set(arr.size()-d+i, temp.get(i));
        }

        return arr;
    }
}
