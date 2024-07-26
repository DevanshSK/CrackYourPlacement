package arraysAndSorting;

import java.util.Arrays;

public class Sorting1 {

    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<= n-2; i++){
            // Finding minimum
            int mini = i;
            for(int j=i; j<=n-1; j++){
                if(arr[j] < arr[mini]) mini = j;
            }
            // Swapping values
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = n-1; i>=1; i--){    // Note n-2 causes one cycle of the loop to miss, so change the inner loop.
            // Comparing and iterating loops
            for(int j = 0; j<=i-1; j++){
                if(arr[j] > arr[j+1]){
                    // Swapping adjacent elements
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr, int n){
        for(int i=0; i <= n-1; i++){
            // picking and inserting elements
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                // If element is not in order
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }


        }
    }

    public static void main(String[] args) {
        int[] nums = {13,46,24,52,20,9};
        System.out.println("Before Sort");
        System.out.println(Arrays.toString(nums));
//        selectionSort(nums);
//        bubbleSort(nums);
        insertionSort(nums, nums.length);
        System.out.println("After sorting");
        System.out.println(Arrays.toString(nums));

    }
}
