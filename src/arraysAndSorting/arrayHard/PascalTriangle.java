package arraysAndSorting.arrayHard;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    /**
     * Q. Given an integer numRows, return the first numRows of Pascal's triangle.
     * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
     * This problem has 3 variations. They are stated below:
     *
     * Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
     * Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.
     * Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.
     *
     * Ex: 5
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     *
     *  ## Variant 1: Find the element at R row and C column.
     *      # Bruteforce: Use nCr formula to find the desired element.
     *      TC: O(N + N + R)
     *
     *      # Better Solution: Optimize the nCr formula.
     *      - Cancel out the bottom factorial to reduce TC to O(R)
     *      - It means at most the number of iterations is equal to R.
     *      - TC: O(R)
     *
     *  # Variant 2: Generate the Nth row of the pascal triangle
     *      # Bruteforce:
     *      - Traverse and generate every element of the row using previous element.
     *      TC: O(N ^ 2)
     *
     *      # Better solution:
     *      - We know that the next element found using multiplication of previous element with the column number
     *      - Element = Previous * (Row - col -1) / col -1
     *      - TC: O(R)
     *
     *  # Variant 3: Generate the entire pascal triangle
     *      # Bruteforce:
     *      - Generate all rows and cols using nCr formula.
     *      TC: O(N^3)
     *
     *      # Optimal solution: Generate rows using the variant 2 method.
     *      - Here we know that next answer can be calculated by using previous ans.
     *      - So we generate all the rows the same way.
     *      TC: O(N^2)
     *
     *
     * */


    //* VARIATION 1: Get the element of the position of the triangle.

    // Find factorial of the number
    public int fact(int n){
        if(n == 1) return 1;
        return n * fact(n-1);
    }

    public int generateElementBrute(int rows, int cols){
        return (fact(rows -1)) / (fact(cols - 1) * fact(rows - cols - 1));
    }

    public int nCr(int rows, int cols){
        int res = 1;
        for (int i = 0; i < cols; i++) {
            res = res * (rows - i);
            res = res / (i + 1);
        }
        return res;
    }


    //* VARIATION 2: Build the Nth row of the pascal triangle.
    public List<Integer> generateRowBrute(int n){
        // Generate all the elements of the row.
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            ans.add(nCr(n-1, i-1));
        }

        return ans;
    }

    public List<Integer> generateRowOptimal(int n){
        List<Integer> row = new ArrayList<>();
        int ans = 1;
        row.add(ans);

        // Generate current element based on the previous element.
        for(int i = 1; i<n; i++){
            ans = ans * (n-i);
            ans = ans / i;
            row.add(ans);
        }

        return row;
    }

    // VARIANT 3:
    // # Bruteforce: Generate all rows using basic traversal
    public List<List<Integer>> generateBrute(int n){
        List<List<Integer>> ans = new ArrayList<>();

        // Render and generate all rows
        for(int i = 1; i <= n; i++){
            List<Integer> temp = new ArrayList<>();
            // Generate the row
            for (int j = 1; j <= i; j++){
                temp.add(nCr(i -1, j-1));
            }
            ans.add(temp);
        }
        return ans;
    }


    // # Optimal Solution:
    public List<Integer> generateRow(int rows){
        int res = 1;
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int col = 1; col < rows; col++) {
            res = res * (rows - col);
            res = res / (col);
            row.add(res);
        }
        return row;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=1; i<= numRows; i++){
            ans.add(generateRow(i));
        }

        return ans;
    }
}
