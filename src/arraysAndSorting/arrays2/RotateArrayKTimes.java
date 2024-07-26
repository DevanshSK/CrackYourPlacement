package arraysAndSorting.arrays2;

import java.util.ArrayList;

public class RotateArrayKTimes {
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        // Write your code here.
        // taking elements in temp
        int d = k % arr.size();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<d; i++){
            temp.add(arr.get(i));
        }

        // Shifting elements
        for(int i=0; i< arr.size()-d; i++){
            arr.set(i, arr.get(i+d));
        }

        // Placing back elements;
        for(int i=0; i<d; i++){
            arr.set(arr.size()-d+i, temp.get(i));
        }

        return arr;
    }
}
