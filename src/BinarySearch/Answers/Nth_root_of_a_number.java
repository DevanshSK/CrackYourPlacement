package BinarySearch.Answers;
import java.lang.Math;
public class Nth_root_of_a_number {
    public static int NthRoot(int n, int m) {
        // Using Binary Search
        int low = 1, high = m;
        while(low <= high){
            int mid = (low + high) / 2;
            if(Math.pow(mid, n) == m) return mid;
            else if(Math.pow(mid, n) < n) low = mid + 1;
            else high = mid - 1;
        }

        return -1;

    }
}
