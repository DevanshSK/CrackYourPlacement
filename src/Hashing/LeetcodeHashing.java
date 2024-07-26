package Hashing;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetcodeHashing {
    public static int[] countFrequency(int n, int x, int []nums){
        int[] result = new int[n];
        HashMap<Integer, Integer> myMap = new HashMap<>();
        // precomputation
        for(int num : nums){
            Integer count = myMap.getOrDefault(num, 0);
            myMap.put(num, count+1);
        }


        // fetching
        for(int i = 0; i < n; i++){
            int key = i + 1;
            int  value = myMap.getOrDefault(key, 0);
            result[i] = value;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {11,14,8,3,12,14,1,7,4,3};
        System.out.println(Arrays.toString(countFrequency(10,14, nums)));
    }
}
