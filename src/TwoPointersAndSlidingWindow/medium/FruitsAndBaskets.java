package TwoPointersAndSlidingWindow.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsAndBaskets {
    /**
     *  Q. You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array of arr[],
     *      where arr[i]  is the type of fruit the ith tree produces.
     *      You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow :
     *
     *     You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
     *     Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
     *     The picked fruits must fit in one of the baskets.
     *     Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
     *
     *      Given the integer array of fruits, return the maximum number of fruits you can pick.
     *
     *      Note: This question can be names as "Finding maximum subarray with atmost two types of fruits."
     *
     *      # Bruteforce solution: Generate all the subarrays and find the maximum valid subarray
     *      - We use Set to ensure to monitor the number of types of fruits.
     *      - TC: O(N^2)
     *      - SC: O(3) : Set only contains 3 elements at max.
     *
     *
     *      # Optimal solution: Use sliding window
     *      - We can use sliding window to optimize the completies to linear.
     *      - Set can be used to track the number of types of fruits.
     *      - In expansion, we add element to set.
     *      - And check if the size of set is less than 3
     *
     * */

    public static int totalFruits(Integer[] arr){
        // Initialize a window of size 1
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> mapp = new HashMap<>();

        while(r < arr.length){
            // Increase the count
            mapp.put(arr[r], mapp.getOrDefault(arr[r], 0) + 1);

            if(mapp.size() > 2){
                // Shirnk the window
                mapp.replace(arr[l], mapp.getOrDefault(arr[l], 0) - 1);
                if(mapp.get(arr[l]) == 0 ){
                    mapp.remove(arr[l]);
                }
                l++;
            }
            if(mapp.size() <= 2){
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }
            r++;
        }
        return maxLen;
    }
    public static int totalFruitsOptimal(Integer[] arr) {
        // Initialize a window of size 1
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> mapp = new HashMap<>();

        while(r < arr.length){
            // Increase the count
            mapp.put(arr[r], mapp.getOrDefault(arr[r], 0) + 1);

            if(mapp.size() <= 2){
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }
            else{
                // Shirnk the window
                while(mapp.size() > 2){
                    mapp.replace(arr[l], mapp.getOrDefault(arr[l], 0) - 1);
                    if(mapp.get(arr[l]) == 0 ){
                        mapp.remove(arr[l]);
                    }
                    l++;
                }
            }

            r++;
        }

        return maxLen;
    }

    public static int totalFruitsBrute(Integer[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            // Set for storing types of numbers.
            Set<Integer> st = new HashSet<>();
            for (int j = i; j < arr.length; j++) {
                st.add(arr[j]);
                if(st.size() <= 2){
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }
}
