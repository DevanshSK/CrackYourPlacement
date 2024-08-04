package InterviewQuestions.Flipkart;

import java.util.HashMap;

public class PairWithGivenDifference {
    /**
     * Q. Given an one-dimensional unsorted array A containing N integers.
     * You are also given an integer B, find if there exists a pair of elements in the array whose difference is B.
     * Return 1 if any such pair exists else return 0.
     * */
    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> mapp = new HashMap<>();

        for(int i = 0; i<A.length; i++){
            int value = A[i];
            int diff1 = value - B;
            int diff2 = B + value;

            if(mapp.containsKey(diff1) || mapp.containsKey(diff2)){
                return 1;
            }

            mapp.put(value, 1);

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(0 % 2);
    }
}
