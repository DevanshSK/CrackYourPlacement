package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;

        List<Integer> ans = new ArrayList<>();

        while(top <= bottom && left <= right){
            // Moving left to right
            for (int i = left; i <= right ; i++) {
                ans.add(mat[top][i]);
            }
            top++;

            // Moving top to bottom
            for (int i = top; i <= bottom ; i++) {
                ans.add(mat[i][right]);
            }
            right--;

            // Moving right to left
            if(top <= bottom){
                for (int i = right; i >= left ; i--) {
                    ans.add(mat[bottom][i]);
                }
                bottom--;
            }

            // Moving Bottom to top
            if(left <= right){
                for (int i = bottom; i >= top ; i--) {
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}
