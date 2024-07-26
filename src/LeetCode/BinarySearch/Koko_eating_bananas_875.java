package LeetCode.BinarySearch;

public class Koko_eating_bananas_875 {
    public static int findMax(int[] arr){
        // Calculate max element in an array
        int maxi = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    public static int calculateHours(int[] arr, int h){
        // Calculate total hours
        int totalH = 0;
        int n = arr.length;
        for(int i = 0; i<n; i++){
            totalH += Math.ceil((double) arr[i] / (double) h);
        }
        return totalH;
    }

    public static int minEatingSpeed(int[] piles, int h){
        int low = 1, high = findMax(piles);
        while(low <= high){
            int mid = (low + high) / 2;
            int totalH = calculateHours(piles, mid);
            if(totalH <= h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}
