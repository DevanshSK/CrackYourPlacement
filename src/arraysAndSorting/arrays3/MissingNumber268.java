package arraysAndSorting.arrays3;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class MissingNumber268 {
    /**
     * Q.   Given an array nums containing n distinct numbers in the range [0, n],
     *      return the only number in the range that is missing from the array.
     *
     *
     *      # Bruteforce solution:
     *      - Search all numbers from 0 to N inside the array.
     *      - Use linear search to find matches.
     *      TC: O(N^2)
     *      SC: O(1)
     *
     *      # Better approch:
     *      - Use hash arrays to store occurences of the numbers.
     *      - Then iterate the array and find the element with zero occurences.
     *      TC: O(2n)
     *      SC: O(N)
     *
     *      # Optimal 1: Using summation.
     *      - We know that numbers exist in the range of [0, N]
     *      - So summation from 0 to N will differ from the sum of array.
     *      - This difference will be equal to the missing number.
     *      TC: O(N)
     *      SC: O(1)
     *
     *      # Optimal 2: Using XOR
     *      - XOR has a property that n ^ n = 0 and 0 ^ n = n.
     *      - So all numbers can be xored with the array elements.
     *      - At the end, only the missing element remains as only that element is present single
     *      TC: O(N)
     *      SC: O(1)
     *
     *
     * */
    public int bruteForce(int[] nums) {
        // We use linear search for all the elements available in the array
        // TC: O(N^2), SC: O(1)
        int ans = 0;
        for(int i = 0; i<=nums.length; i++){
            int flag = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[j] == i){
                    flag = i;
                    break;
                }
            }
            if(flag==0){
                ans = i;
            }
        }

        return ans;
    }

    public static int betterApproach(int[] nums){
        // Here we use hashing to optimise the process of searching elements.
        // Here we improved Time complexity to O(n^2) to O(2n). And space complexity to O(n) for the hash array.
        int[] hash = new int[nums.length + 1];
        int ans = 0;
        // Precomputation
        for(int i = 0; i< nums.length; i++){
            hash[nums[i]]++;
        }

        // fetch
        for(int i = 0; i<hash.length; i++){
            if(hash[i] == 0){
                ans = i;
                break;
            }
        }
        System.out.println(Arrays.toString(hash));
        return ans;
    }

    public static int optimalSumApproach(int[] nums){   // TC: O(N), SC: O(1)
        // We know that, sum of N numbers is (N)*(N+1)/2.
        // And one number is missing, So the sum of nums in array differs to this sum by out missing number.
        int sum = (nums.length * (nums.length + 1)) / 2;

        // Calculate the array sum
        int arraySum = 0;
        for(int num : nums){
            arraySum += num;
        }

        // Return the sum difference.
        return sum - arraySum;
    }

    public static int optimalXORApproach(int[] nums){   // TC: O(N), SC: O(1)
        // We know that, a^a = 0, 0^a = a.
        // Now we XOR all numbers in array and all numbers from 1 to N.
        // XOR all numbers in XOR1, and all array nums in XOR2
        int xor1 = 0, xor2 = 0;
        for(int i = 0; i<nums.length; i++){
            xor2 = xor2 ^ nums[i];
            xor1 = xor1 ^ (i + 1);
        }

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        int ans = betterApproach(nums);
        System.out.println(ans);
    }
}