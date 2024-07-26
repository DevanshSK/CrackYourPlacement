package arraysAndSorting.arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionArray {
    public static List<Integer> bruteForce(int[] a, int[] b, int n1, int n2){
        List<Integer> ans = new ArrayList<>();
        // Marker array for visited elements of b
        boolean[] vis = new boolean[n2];

        for(int i = 0; i<n1; i++){
            for(int j=0; j<n2; j++){
                // Check if element is present in both array and is not previously used.
                if(a[i] == b[j] && !vis[j]){
                    ans.add(a[i]);
                    vis[j] = true;
                    break;
                }

                // Break out if greater elements reached
                if(b[j] > a[i]) break;
            }
        }

        return ans;
    }

    public static List<Integer> optimalSolution(int[] a, int[] b, int n1, int n2){
        List<Integer> ans = new ArrayList<>();
        int i=0,j = 0;   // Create pointers

        // Take a as main array
        while(i<n1 && j<n2){
            if(a[i] == b[j]){
                ans.add(a[i]);
                i++;
                j++;
            } else if (b[j] < a[i]) {
                j++;
            }
            else{
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,3,3,4,5,6};
        int[] num2 = {2,3,3,5,5,6,6,7};
        List<Integer> intersection = optimalSolution(num1, num2, num1.length, num2.length);
        System.out.println(intersection.toString());
    }
}
