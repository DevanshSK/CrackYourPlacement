package BinarySearch.Answers;
import java.lang.Math;

public class Sqrt_of_a_number {
    public static int sqrtNBrute(long N){
        // Bruteforce solution
        // Do a linear search and store the suitable value.
        // If the square is greater than the number, then break the loop and return.
        // TC: O(N)
        // SC: O(1)

        int ans = 0;
        // Linear Search for answers
        for (long i = 0; i <= N; i++){
             if(i*i == N){
                 ans = (int) i;
             }
             else{
                 break;
             }
        }

        return ans;
    }

    public static int sqrtNOpptimal(long N){
        // By using built in sqrt() method
        // TC: O(1) SC: O(1)
        return (int) Math.sqrt(N);
    }

    public static int sqrtOptimal(long N){
        // By using binary search.
        // TC: O(log N)
        // SC: O(1)
        int ans = 1;
        int low = 1, high = (int) N;

        while(low <= high){
            int mid = (low + high) / 2;
            int val = mid * mid;

            if(val <= N){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
}
