package arraysAndSorting.arraysMed;

public class SpiralMatrix {
    public static int[] spiralMatrix(int [][]mat) {
        // Write your code here.
        int n = mat.length;
        int m = mat[0].length;
        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;

        int[] ans = new int[m * n];
        int index = 0;

        while(top <= bottom && left <= right) {
            // Moving left to right
            for (int i = left; i <= right; i++) {
                ans[index++] = mat[top][i];
            }
            top++;

            // Moving top to bottom
            for (int i = top; i <= bottom; i++) {
                ans[index++] = mat[i][right];
            }
            right--;

            if(top <= bottom){// For moving right to left
                for (int i = right; i >= left; i--) {
                    ans[index++] = mat[bottom][i];
                }
                bottom--;
            }

            if(left <= right){
                for (int i = bottom; i >= top; i--) {
                    ans[index++] = mat[i][left];
                }
                left++;
            }
        }
        return ans;
    }
}
