package arraysAndSorting;
import java.util.ArrayList;
import java.util.Arrays;

public class Sorting2 {
    public static void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right= mid + 1;

        // When both halves have elements
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }

        // when left array is exhausted
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }

        // when left array is exhausted
        while(left  <= mid){
            temp.add(arr[left]);
            left++;
        }

        // Copy the sorted array in original array
        for(int i = low; i<= high; i++){
            arr[i] = temp.get(i - low);
        }
    }
    public static void mergeSort(int[] arr, int l, int r){
        if(l == r) return;

        int mid = (l/2) + (r/2);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }



    public static int findPartitionIndex(int[] arr, int low, int high){
        int pivot = low;
        int i=low, j = high;
        while( i < j){
            // From left find first element greater than pivot
            while(arr[i] <= arr[pivot] && i < high) {
                i++;
            }
            // From right find first element smaller than pivot
            while(arr[j] > arr[pivot] && j > low) {
                j--;
            }
            // Swap the elements
            if(i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // Swap pivot element to correct position
        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;
        return j;
    }
    public static void quickSort(int[] input, int startIndex, int endInedx){
        if(startIndex < endInedx){
            int pIndex = findPartitionIndex(input, startIndex, endInedx);
            quickSort(input, startIndex, pIndex - 1);
            quickSort(input, pIndex + 1, endInedx);
        }
    }

    public static int findPartitionIndexDes(int[] arr, int low, int high){
        int pivot = low;
        int i=low, j = high;
        while( i < j){
            // From left find first element smaller than pivot
            while(arr[i] >= arr[pivot] && i < high) {
                i++;
            }
            // From right find first element greater than pivot
            while(arr[j] < arr[pivot] && j > low) {
                j--;
            }
            // Swap the elements
            if(i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // Swap pivot element to correct position
        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;
        return j;
    }
    public static void quickSortDes(int[] input, int startIndex, int endInedx){
        if(startIndex < endInedx){
            int pIndex = findPartitionIndexDes(input, startIndex, endInedx);
            quickSortDes(input, startIndex, pIndex - 1);
            quickSortDes(input, pIndex + 1, endInedx);
        }
    }
    public static void main(String[] args) {
        int[] nums = {2, 13, 4, 1, 3, 6, 28};
        System.out.println(Arrays.toString(nums));
        quickSortDes(nums, 0 , 6);
        System.out.println(Arrays.toString(nums));
    }
}
