package LeetCode;

public class RemoveDuplicates26 {
    public int removeDuplicates(int[] arr) {
        // 2 pointer approach
        int i = 0;
        for(int j = 1; j < arr.length; j++){    // Iterate the array
            if(arr[j] != arr[i] ){    // Check if current element is unique or not
                // Unique found
                arr[i+1] = arr[j];   // Set unique to next position
                i++;    // Move i to next position
            }
            // Unique not found
        }
        return i+1;
    }
}
