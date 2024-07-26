package arraysAndSorting.arraysMed;

import java.util.*;

public class SetMatricesZero {
    public static ArrayList<ArrayList<Integer>> zeroMatrixOptimal(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        int col0 = 1;
//        int[] row = new int[n]; -> matrix[..][0]
//        int[] col = new int[m]; -> matrix[0][..]


        // Traverse and mark all the zeros.
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix.get(i).get(j) == 0){
                    // Mark the i-th row
                    matrix.get(i).set(0,0);
                    // mark the jth column
                    if(j != 0)
                        matrix.get(0).set(j,0);
                    else
                        col0 = 0;
                }
            }
        }
//
        // Then iterate the array and convert marked to zeros.
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // Check if element is already zero
                if(matrix.get(i).get(j) == 0){
                    // Check for col and row
                    if(matrix.get(0).get(j) == 0 || matrix.get(i).get(0) == 0){
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }
        if(matrix.get(0).get(0) == 0){
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j,0);
            }
        }
        if(col0 == 0){
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0,0);
            }
        }
        return matrix;
    }
    public static ArrayList<ArrayList<Integer>> zeroMatrixBetter(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        // Row and columns array
        int[] row = new int[n];
        int[] col = new int[m];

        // Traverse the array
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix.get(i).get(j) == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Now all the rows and cols are marked
        // Iterate and turn all to zeros
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }
}
