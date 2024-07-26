package dsa.basic_maths;

import java.util.ArrayList;
import java.util.List;

public class PrintDivisions {

    static void printDivisions(int n){
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
//        for (int i = 1; i <= n; i++) {
            if(n%i == 0){
//                ans.add(i);
                System.out.println(i);
                if( (n/i) != i ){
//                    ans.add(n/i);
                    System.out.println(n/i);
                }
            }
        }
        ans.sort(null);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        printDivisions(361);
    }
}
