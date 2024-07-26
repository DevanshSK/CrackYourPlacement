package BinarySearch;

public class LowerAndUpperBounds {
    public static int lowerBound(int []arr, int n, int x) {
        int low = 0, high = n-1;
        int ans = n;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] >= x){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }


    public static int upperBound(int []arr, int x, int n){
        int low = 0, high = n-1;
        int ans = n;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] > x){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int searchInsert(int [] arr, int m){
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = n;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] >= m){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
