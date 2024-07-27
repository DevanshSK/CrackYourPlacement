package TwoPointersAndSlidingWindow;

import java.lang.Math;

public class MaxPointsFromCards {
    /**
     *  Q. 1423:    There are several cards arranged in a row, and each card has an associated number of points.
     *              The points are given in the integer array cardPoints.
     *              In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
     *              Your score is the sum of the points of the cards you have taken.
     *              Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
     *
     *      # Solution:
     *      - Check over all the possible combinations of the windows of left and right.
     *      - First we start with all left and no right.
     *      - Then we decrease left window and right window and store the maximum window.
     *
     *      TC: O( K + K ) = O(2K)
     *      SC: O(1)
     * */
    public int maxScore(int[] cardPoints, int k) {
        // Define variables
        int lsum = 0, rsum = 0;
        // Iterate amd calculate initial sum values.
        for(int i = 0; i<k; i++) lsum += cardPoints[i];
        // Since we iterated in first window so max sum must be.
        int maxSum = lsum;

        // Iterate and compare the combinations
        int rightIndex = cardPoints.length - 1;
        for (int i = k-1; i>=0; i--){
            // Remove last element from left window
            lsum -= cardPoints[i];
            // Add element to right window
            rsum += cardPoints[rightIndex];
            rightIndex--;

            // Compare sum values
            maxSum = Math.max(maxSum, lsum + rsum);
        }
        return maxSum;
    }

}
