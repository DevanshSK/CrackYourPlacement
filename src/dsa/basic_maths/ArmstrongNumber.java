package dsa.basic_maths;
import java.util.Scanner;
import java.lang.Math;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        // Take the number of digits
        int c = (int)(Math.log10(num) + 1);

        int sum = 0, m = num;

        while(m != 0){
            int digit = m % 10;
            sum = (int)(sum + Math.pow(digit, c));
            m /= 10;
        }

        System.out.println("Is " + num + " armstrong : " + (sum == num));
    }
}
