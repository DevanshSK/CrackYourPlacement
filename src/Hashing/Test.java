package Hashing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
            // Fetch from hash array
            System.out.println(hash[number]);
            q--;
        }
    }


}
