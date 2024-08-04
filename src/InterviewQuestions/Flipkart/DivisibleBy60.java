package InterviewQuestions.Flipkart;

public class DivisibleBy60 {
    /**
     * Q.   Given a large number represent in the form of an integer array A, where each element is a digit.
     *      You have to find whether there exists any permutation of the array A such that the number becomes divisible by 60.
     *      Return 1 if it exists, 0 otherwise.
     * */

    public int divisibleBy60(int[] A) {
        if (A.length == 1 && A[0] == 0) {
            return 1;
        }

        boolean isZero = false;
        int evens = 0, sum = 0;

        for(int num : A){
            sum += num;
            if(num == 0) isZero = true;
            if(num % 2 == 0) evens++;
        }

        if(isZero && sum % 3 == 0 && evens > 1) return 1;

        return 0;
    }
}
