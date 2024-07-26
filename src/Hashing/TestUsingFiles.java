package Hashing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestUsingFiles  {
    public static void main(String[] args) throws FileNotFoundException {
            Scanner sc = new Scanner(new File("D:\\Codes\\Java DSA\\DSA by Striver\\DSA_By_Striver\\src\\Hashing\\input.txt"));

            // Redirect standard output to a file
            PrintStream fileOut = new PrintStream(new FileOutputStream("D:\\Codes\\Java DSA\\DSA by Striver\\DSA_By_Striver\\src\\Hashing\\output.txt"));
            System.setOut(fileOut);

            int n = sc.nextInt();
            int[] arr = new int[n];
            // Taking Original Array values
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            // Precompute in Array
            int[] hash = new int[13];
            for (int i = 0; i < n; i++) {
                hash[arr[i]] += 1;
            }

            // Running fetch queries
            int q = sc.nextInt();
            while(q > 0){
                int number = sc.nextInt();
                // Fetch from hash array and print to the redirected output
                System.out.println(hash[number]);
                q--;
            }

            // Close the redirected output stream
            fileOut.close();
    }
}
