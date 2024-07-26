package LeetCode.BinarySearch;

public class Minimum_day_to_make_n_bouquets_1482 {
    /**
     * You are given an integer array bloomDay, an integer m and an integer k.
     * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
     * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
     * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
     * */

    public boolean possible(int[] arr, int day, int m, int k){
        int count = 0, bouquets = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= day){
                count++;
            }
            else{
                bouquets += (count / k);
                count = 0;
            }
        }
        bouquets += (count / k);
        return bouquets >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        // Check for total flowers required.
        // This value may exceed integer limit.
        long totalBlooms = (long) m * k;
        int n = bloomDay.length;
        // Impossible case
        if(totalBlooms > n) return -1;

        // Calculate minimum and maximum elements.
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i <n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        // Apply BS
        int low = mini, high = maxi;
        while(low <= high){
            int mid = (low + high) / 2;

            if(possible(bloomDay, mid, m, k)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }
}
