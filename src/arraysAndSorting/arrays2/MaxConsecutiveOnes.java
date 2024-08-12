package arraysAndSorting.arrays2;

public class MaxConsecutiveOnes {
    /**
     *  Q.  Given a binary array nums, return the maximum number of consecutive 1's in the array.
     *
     *  # Solution: Count all the occurences of the consecutive ones
     *  - Traverse the array
     *  - Maintain counter of ones found
     *  - Increment count if one found, else reset.
     *  - Then update the maxCount value.
     *  TC: O(N)
     *  SC: O(1)
     *
     * */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxLen = 0;

        for(int i = 0; i< nums.length; i++){    // Traverse the array
            if(nums[i] == 1){   // Increment ones counter, consecutive one found
                count++;
            }else{  // ones sequence breaks, reset counter
                count = 0;
            }

            // Update the max counter
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
    }
}
