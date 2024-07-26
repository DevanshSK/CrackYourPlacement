package PatternsJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Intro {
    public static void main(String[] args) throws FileNotFoundException {
        // Taking input from a file
        Scanner sc = new Scanner(new File("D:\\Codes\\Java DSA\\DSA by Striver\\DSA_By_Striver\\src\\Hashing\\input.txt"));

        // Redirect standard output to a file
        PrintStream fileOut = new PrintStream(new FileOutputStream("D:\\Codes\\Java DSA\\DSA by Striver\\DSA_By_Striver\\src\\Hashing\\output.txt"));
        System.setOut(fileOut);
        
        // Program Starts Here

        // Close the redirected output stream
        fileOut.close();

    }
}
