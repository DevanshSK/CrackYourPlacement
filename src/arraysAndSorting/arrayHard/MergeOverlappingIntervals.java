package arraysAndSorting.arrayHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    /**
     *  Q.  Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
     *      and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     *
     *      ## Bruteforce Solution:
     *      - First we sort the intervals, so similar intervals are grouped together.
     *      - After that, we took one interval[i] at a time:
     *          - Initially it was the merged interval.
     *          - Now check if the interval [i] falls under the last merged interval:
     *          - This is done using interval[i][1] <= temp[n-1][1]
     *          - If yes, then skip to next interval.
     *      - Then, iterate the loop from i and find the overlaping intervals.
     *          - If intervals[j][0] <= end : Overrlaping.
     *          - Expand the merged interval to larger interval.
     *      - Add the interval to temp array.
     *      - Slice the temp array to remove empty arrays.
     *      TC: O(NlogN + 2N)
     *      SC: O(N)
     *
     *      ## Optimal Solution:
     *      - We sort the intervals to group them.
     *      - We start with the first interval and add it to merged ans.
     *      - Then we continue forward and compare the current intervals with last merged interval for overlaping.
     *      - Overlaping: B[0] <= A[1]
     *          - Yes: Update and expand the last merged interval.
     *          - No: Then took a new interval to compare to.
     *      TC: O()
     *      SC: O()
     *
     * */
    public int[][] mergeOptimal(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        // List to store answer.
        int[][] temp = new int[n][2];
        // Index to track number of Pairs.
        int index = 0;

        // Iterate and merge the intervals
        for (int i = 0; i < n; i++) {
            // Add the first interval.
            // Move on to next interval as it is not overlaping
            if(index == 0 || intervals[i][0] > temp[index-1][1]){
                // Add interval to result array
                temp[index] = intervals[i];
                index++;
            }
            else{
                // Overlaping will occurr
                temp[index-1][1] = Math.max(temp[index-1][1], intervals[i][1]);
            }
        }

        return Arrays.copyOf(temp, index);
    }


    public int[][] mergeBrute(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        // List to store answer.
        int[][] temp = new int[n][2];
        // Index to track number of Pairs.
        int index = 0;

        // Traverse the array
        for(int i = 0; i< n; i++){
            // Get the current interval.
            // This becomes the merged interval
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Check if current interval is a part of the last existing interval.
            if(index > 0 && end <= temp[index - 1][1] ){
                // Interval already exists in answer. Move to next interval
                continue;
            }

            // Check the rest of the intervals
            for (int j = i+1; j < n; j++) {
                // If interval is overlaping
                if(intervals[j][0] <= end){
                    // Update the maximum interval
                    end = Math.max(end, intervals[j][1]);
                }
                else{
                    // Interval is not overlaping.
                    break;
                }
            }
            // Add the merged interval to answer list.
            temp[index][0] = start;
            temp[index][1] = end;
            index++;
        }

        return Arrays.copyOf(temp, index);
    }
}
