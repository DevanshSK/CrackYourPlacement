package dsa.basic_maths;
import java.lang.Math;

public class CountDigits {
    public static void main(String[] args) {
        // Counting the number of digits in a number
        int n = 15718654;
        // Approach1 : Iterating and storing count in variable
        // TC : O(log10(N)) SC : O(1) , where N = number of digits
        int count = 0;
        while(n > 0){
            int digit = n % 10;
            count++;
            n = n / 10;
        }
        System.out.println("Total digits : " + count);


        // Approach 2 : log10() + 1 of a number gives the number of digits in integer
        int num = 7789;
        int cnt = (int)(Math.log10(num) + 1);
        System.out.println("Total digits : " + cnt);

    }
}
