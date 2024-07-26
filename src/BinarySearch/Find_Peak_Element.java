package BinarySearch;

import java.util.ArrayList;

public class Find_Peak_Element {
    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size();

        // Manual edge cases
        if(n == 1) return 0;
        if(arr.get(0) > arr.get(1)) return 0;
        if(arr.get(n-1) > arr.get(n-2)) return n-1;

        int low = 1, high = n-2;
        while(low <= high){
            int mid = (low+high)/2;

            // Check if mid is answer
            if(arr.get(mid) > arr.get(mid -1) && arr.get(mid) > arr.get(mid + 1)){
                return mid;
            }
            else if(arr.get(mid) > arr.get(mid - 1)){
                // We are on an ascending slope.
                low = mid + 1;
            }
            else{
                // We are on a decending slope
                high = mid - 1;
            }
        }
        return -1;
    }
}
