package LeetCode;

import java.util.Arrays;

public class replaceElements {

    public static int[] replaceEl(int[] arr){
        for(int i=0; i<arr.length; i++){
            int max = -1;
            // find maximum element in range
            for(int j= i+1; j<arr.length; j++){
                if(max < arr[j]){
                    max = arr[j];
                }
//                System.out.print(arr[j] + " ");
            }
//            System.out.print(max + " ");
            arr[i] = max;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] num1 = {17,18,5,4,6,1};
        int[] num2 = {400};

        System.out.println(Arrays.toString(replaceEl(num1)));
        System.out.println(Arrays.toString(replaceEl(num2)));
    }
}
