package InterviewQuestions.Flipkart;

public class PerfectPeakOfArray {
    /**
     *  Q. Given an integer array A of size N.
     * You need to check that whether there exist a element which is strictly greater than all the elements on left of it and strictly smaller than all the elements on right of it.
     * If it exists return 1 else return 0.
     *
     * NOTE: Do not consider the corner elements i.e A[0] and A[N-1] as the answer.
     *
     *  # Bruteforce:
     *  - Check the left subarrays and right subarrays for valid condition.
     *  - Left elements must be smaller than A[i]
     *  - Right elements must be greater than A[i]
     *  TC: O(N^2)
     *  SC: O(1)
     *
     *  # Better solution:
     *  - Precompute the maximum and minimum values of left and right subarrays for each index.
     *  - By doing this, we can remove the condition checking loop.
     *  - If the left maximum is smaller than the current, then all left elements are smaller than current.
     *  - If the right minimum is greater than the current, then all right elements are greater than the current.
     *  TC: O(3N)
     *  SC: O(2N)
     *
     *
     * */
    public int perfectPeakBetter(int[] A){
        int n = A.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];

        // Calculate left maximum element for all cases
        leftMax[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], A[i - 1]);
        }

        // Calculate minimum values for right subarrays at that index.
        rightMin[n-1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >=  0; i--) {
            rightMin[i] = Math.min(A[i + 1], rightMin[i+1]);
        }

        for (int i = 1; i < n-1; i++) {
            if(leftMax[i] < A[i] && rightMin[i] > A[i]) return 1;
        }
        return 0;
    }

    public int perfectPeakBrute(int[] A) {
        // Check for each element except start and end.
        for(int i = 1; i < A.length - 1; i++ ){
            // Count occurences of infavourable conditions.
            int lcount = 0, rcount = 0;
            for(int j = 0; j < i; j++){
                if(A[j] >= A[i]){
                    lcount++;
                    break;
                }
            }

            for(int j = i + 1; j < A.length; j++){
                if(A[j] <= A[i]){
                    rcount++;
                    break;
                }
            }

            if(lcount == 0 && rcount == 0) {
                return 1;
            }
        }
        return 0;
    }
}
