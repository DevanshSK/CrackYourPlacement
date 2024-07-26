package Hashing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class CharacterHashingProblem {
    public static void main(String[] args) throws FileNotFoundException {
        // Taking input from a file
        Scanner sc = new Scanner(new File("D:\\Codes\\Java DSA\\DSA by Striver\\DSA_By_Striver\\src\\Hashing\\input.txt"));

        // Redirect standard output to a file
        PrintStream fileOut = new PrintStream(new FileOutputStream("D:\\Codes\\Java DSA\\DSA by Striver\\DSA_By_Striver\\src\\Hashing\\output.txt"));
        System.setOut(fileOut);

        // Program starts here
        // Taking input string data
        String s = sc.next();

        // Pre computation for hashing
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }


        int q = sc.nextInt();
        while(q > 0){
            // Take the input character
            char c = sc.next().charAt(0);
            // fetch data
            System.out.println("Character " + c + " occured " + hash[c] + " times.");
            q--;
        }


        // Close the redirected output stream
        fileOut.close();

    }
}
