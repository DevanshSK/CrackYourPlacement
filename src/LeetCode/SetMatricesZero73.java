package LeetCode;

public class SetMatricesZero73 {
    public void setZeroesBetter(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        // Traverse the array
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Turn all marked rows and cols to zero
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public void setZerosOptimal(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;
//        int[] row = new int[n]; -> matrix[..][0]
//        int[] col = new int[m]; -> matrix[0][..]


        // Traverse and mark all the zeros.
        for(int i=0; i<n; i++){
            if(matrix[i][0] == 0) col0 = 0;
            for(int j=1; j<m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 1; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(col0 == 0) matrix[i][0] = 0;
        }
    }
}
