package PatternsJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Pattern1 {

    public static void print1(int n){
        // Pattern 1
        //  * * * *
        //  * * * *
        //  * * * *
        //  * * * *
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
            System.out.println();
    }

    public static void print2(int n){
        // Pattern 2
        //  *
        //  **
        //  ***
        //  ****
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

    }
    public static void print3(int n){
        // Pattern 3
        //  1
        //  12
        //  123
        //  1234
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j +" ");
            }
            System.out.println();
        }
        System.out.println();

    }
    public static void print4(int n){
        // Pattern 3
        //  1
        //  22
        //  333
        //  4444
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i +" ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void print5(int n){
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void print6(int n){
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void print7(int n){
        for (int i = 1; i <= n; i++) {  // Rows loop

            for (int j = 0; j < n-i ; j++) {    // Upper left triangle from n-1 to 0
                System.out.print("  ");
            }

            for(int j = 1; j <= i; j++){    // Middle Triangle
                System.out.print("* ");
            }

            for (int j = 1; j < i; j++){    // Right Triangle
                System.out.print("* ");
            }

            System.out.println();
        }
        System.out.println();
    }
    public static void print8(int n){
        for (int i = 1; i <= n; i++) {  // Rows loop

            for (int j = 1; j < i ; j++) {    // Upper left triangle from n-1 to 0
                System.out.print("  ");
            }

            for(int j = 0; j <= n-i; j++){    // Middle Triangle
                System.out.print("* ");
            }

            for (int j = 0; j < n-i; j++){    // Right Triangle
                System.out.print("* ");
            }

            System.out.println();
        }
        System.out.println();
    }

    public static void print10(int n){
        for(int i=1; i<= 2*n-1; i++){
            int stars = i;
            if(i > n) stars = 2*n-i;
            for(int j=1; j <= stars; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print11(int n){
        for(int row=1; row<=n; row++){
            for(int j = 0; j< row; j++){
                System.out.print((row+j)%2);
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void print12(int n){
        for(int i=1; i<=n; i++){    // Outer loop
            //  First counting
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            //  Spaces
            for(int j=1; j<=2*(n-i); j++ ){
                System.out.print(" ");
            }
            //  Right counting
            for(int j=i; j>=1; j--){
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print13(int n){
        int count = 1;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j<=i; j++){
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print14(int n){
        for(int i=0; i<n; i++){
            for (int j = 0; j <= i; j++) {
                char letter = (char) ('A' + j);
                System.out.print(letter);
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) throws FileNotFoundException {
        // Taking input from a file
        Scanner sc = new Scanner(new File("input.txt"));

        // Redirect standard output to a file
        PrintStream fileOut = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(fileOut);

        // Program Starts Here
        int n = sc.nextInt();

        while(n > 0){
            int num = sc.nextInt();
//            print1(num);
//            print2(num);
//            print3(num);
//            print4(num);
//            print5(num);
//            print6(num);
            print7(num);

//            print8(num);
//            print10(num);
//            print11(num);
//            print12(num);
//            print13(num);
//            print14(num);
            n--;
        }




        // Close the redirected output stream
        fileOut.close();

    }
}
