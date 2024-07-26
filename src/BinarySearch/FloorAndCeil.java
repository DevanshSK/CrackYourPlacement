package BinarySearch;

public class FloorAndCeil {
    static int findFloor(int[] a, int n, int x){
        // Floor is the largest number which is smaller than or equal to x.
        int ans = -1, low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(a[mid] <= x){
                ans = a[mid];
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    static int findCeil(int[] a, int n, int x){
        // Ceil is the smallest number which is greater than or equal than x.
        int ans = -1, low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(a[mid] >= x){
                ans = a[mid];
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int[] ans = new int[2];
        ans[0] = findFloor(a,n,x);
        ans[1] = findCeil(a, n, x);
        return ans;
    }
}
