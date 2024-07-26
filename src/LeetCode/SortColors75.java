package LeetCode;

import java.util.Arrays;

public class SortColors75 {
    public void BruteSortColors(int[] nums) {
        // Just sort the array using a sorting algorithm
        Arrays.sort(nums);
    }

    public void BetterSortColors(int[] nums) {
        // Here we count the occurrences and override the original array
        int cnt0=0, cnt1=1, cnt2=2;
        // Start counting
        for (int i = 0; i <nums.length; i++) {
            if(nums[i]==0) cnt0++;
            else if(nums[i] == 1) cnt1++;
            else cnt2++;
        }

        // Override the array
        for(int i =0; i<cnt0; i++) nums[i] = 0;
        for(int i =cnt0; i<cnt0 + cnt1; i++) nums[i] = 1;
        for(int i =cnt0+cnt1; i< nums.length; i++) nums[i] = 2;
    }

    public void OptimalSortColors(int[] nums) {
        // Now we use Dutch national flag algorithm
        // Which utilizes 3 pointer approach
        // TC: 
        int low = 0, mid = 0, high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                // Element is 0
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                // Element is 1
                mid++;
            }
            else{
                // Element is 2
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
