package Hashing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class HashmapTuts {
    public static void main(String[] args) throws FileNotFoundException {
        // Taking input from a file
        Scanner sc = new Scanner(new File("D:\\Codes\\Java DSA\\DSA by Striver\\DSA_By_Striver\\src\\Hashing\\input.txt"));

        // Redirect standard output to a file
        PrintStream fileOut = new PrintStream(new FileOutputStream("D:\\Codes\\Java DSA\\DSA by Striver\\DSA_By_Striver\\src\\Hashing\\output.txt"));
        System.setOut(fileOut);

        // Program starts here
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // Precompute
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }


        // Traversing the Hashmap
//        for(Map.Entry<Integer, Integer> e : map.entrySet()){
//            System.out.println(e.getKey() + " -> " + e.getValue());
//        }


        // Fetch
        int q = sc.nextInt();
        while(q > 0){
            int number = sc.nextInt();
            System.out.println(map.getOrDefault(number, 0));
            q--;
        }




        // Close the redirected output stream
        fileOut.close();

    }
}