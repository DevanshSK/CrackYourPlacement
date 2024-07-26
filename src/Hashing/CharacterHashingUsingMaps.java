package Hashing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class CharacterHashingUsingMaps {
    public static void main(String[] args) throws FileNotFoundException {
        // Taking input from a file
        Scanner sc = new Scanner(new File("D:\\Codes\\Java DSA\\DSA by Striver\\DSA_By_Striver\\src\\Hashing\\input.txt"));

        // Redirect standard output to a file
        PrintStream fileOut = new PrintStream(new FileOutputStream("D:\\Codes\\Java DSA\\DSA by Striver\\DSA_By_Striver\\src\\Hashing\\output.txt"));
        System.setOut(fileOut);

        // Program starts here
        String str = sc.next();

        // Precomputation
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            hash.put(str.charAt(i), hash.getOrDefault(str.charAt(i), 0) + 1);
        }
        System.out.println(hash);

        // Fetch queries
        int q = sc.nextInt();
        while(q > 0){
            char c = sc.next().charAt(0);
            System.out.println(hash.getOrDefault(c, 0));
            q--;
        }

        // Close the redirected output stream
        fileOut.close();

    }
}