package BinarySearch;

import java.util.ArrayList;

public class FirstAndLastOccurence {
    public static int upperBound(ArrayList<Integer> arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr.get(mid) > x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr.get(mid) >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static int[] firstAndLastPositionBetter(ArrayList<Integer> arr, int n, int k) {
        // Solved using Upper and lower bound concept.
        // Write your code here.
        int lb = lowerBound(arr, n, k);
        if(lb == n || arr.get(lb) != k) return new int[] {-1, -1};
        int ub = upperBound(arr, n, k);
        return new int[] {lb, ub-1};
    }



}
