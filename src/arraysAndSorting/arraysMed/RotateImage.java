package arraysAndSorting.arraysMed;

public class RotateImage {
    public static void rotateMatrixBrute(int [][]mat){
        /**
         * Bruteforce solution: TC - O(N^2), SC: O(N^2)
         * Here we create an answer matrix and map the values to the correct position
         * The mapping are as follows:
         * (i, j) => (j, n-i-1)
         * */
        int n = mat.length;
        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - i - 1] = mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = ans[i][j];
            }
        }
    }

    public void rotateOptimal(int[][] mat){
        /**
         * Here, we have some observations.
         * The columns are in reversed order of the output array.
         *      - So we transpost the matrix.
         * Then we reverse the rows only.
         *
         * TC: O(N/2 * N/2 [Transpose]  +  N * N/2 [Reversal])
         * SC: O(1)
         * */
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < mat[0].length; j++) {
                int temp = 0;
                temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse the columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++){
                int temp = 0;
                temp = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = temp;
            }
        }
    }
}
