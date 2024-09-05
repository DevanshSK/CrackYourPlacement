package arraysAndSorting.arrayHard;

public class FindRepeatingAndMissingNumber {
    /**
     *  Q.  You are given a read-only array of N integers with values also in the range [1, N] both inclusive.
     *      Each integer appears exactly once except A which appears twice and B which is missing.
     *      The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.
     *
     *
     *      # Bruteforce solution
     *      - Iterate and count the occurences of all numbers from 1 to N.
     *      - Then at the end, compare the count of occurences:
     *          - count == 2 : Duplicate number
     *          - count == 0 : Missing number.
     *      TC: O(N*2)
     *      SC: O(1)
     *
     *      # Better solution
     *      - Use hashing to store occurences and reduce time complexity.
     *      - Then compare and findout the missing and repeating numbers.
     *      - Also we can use hash array of n size;
     *      TC: O(2N)
     *      SC: O(N)
     *
     *      # Optimal Solution - 1: Using Maths
     *      Step 1: Form equation 1:
     *      - Now, we know the summation of the first N numbers is:
     *          Sn = (N*(N+1))/2
     *      - Let’s say, S = the summation of all the elements in the given array.
     *      - Therefore, S - Sn = X - Y…………………equation 1
     *      Step 2: Form equation 2:
     *      - Now, we know the summation of squares of the first N numbers is:
     *          S2n = (N*(N+1)*(2N+1))/6
     *      - Let’s say, S2 = the summation of squares of all the elements in the given array.
     *      - Therefore, S2-S2n = X2-Y2...................equation 2
     *      - From equation 2 we can conclude,
     *          X+Y = (S2 - S2n) / (X-Y) [From equation 1, we get the value X-Y] ………… equation 3
     *          TC: O(N)
     *          SC: O(1)
     *
     *
     *      ## Optimal Solution 2: Using XOR
     *      - We know that A^A = 0 and 0^A = A
     *      - So we xor all array and all numbers from 1 to N. This gives a number num.
     *      - Then find the first differentiating bit from the right in teh num.
     *      - Now group the numbers in 2 groups based on the value of the differentiating bit.
     *      - Now XOR those numbers and we get our missing and repeating numbers:
     *          - 0 Bit group xor is Repeating number
     *          - 1 Bit group xor is Missing number.
     *      TC: O()
     *      SC: O()
     *
     * */
    int[] findTwoElementOptimal2(int arr[], int n) {
        int xor = 0;
        // Find XOR of array and numbers.
        for(int i=0; i<n; i++){
            xor = xor ^ arr[i];
            xor = xor ^ (i+1);
        }

        // Find the first differentiating bit value
//        This logic can be converted into this.
        int bitNo = (xor & ~(xor - 1));
//        int bitNo = 0;
//        while(true){
//            if( (xor & (1 << bitNo)) != 0 ){
//                break;
//            }
//            bitNo++;
//        }

        // Create 2 groups
        int zero = 0, one = 0;
        for (int i = 0; i < n; i++) {
            // Group the array elements
            if((arr[i] & (1 << bitNo)) != 0){
                // Belong to ones group
                one = one ^ arr[i];
            }
            else{
                // Belongs to zero grouup
                zero = zero ^ arr[i];
            }


            // Group the numbers
            if(((i+1) & (1 << bitNo)) != 0){
                // Belong to ones group
                one = one ^ (i+1);
            }
            else{
                // Belongs to zero grouup
                zero = zero ^ (i+1);
            }
        }

        // Verify the numbers
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == zero) count++;
        }
        if(count == 2) return new int[]{zero, one};
        return new int[]{one, zero};
    }
    int[] findTwoElementOptimal1(int arr[], int n) {
        // Find sum and squares of the numbers
        long Sn = (n * (n+1L)) / 2;
        long Sn2 = (n * (n+1L) * (2L * n + 1)) / 6;

        // Find sum and squares of the array
        long S = 0;
        long S2 = 0;
        for (int i = 0; i < n; i++) {
            S += arr[i];
            S2 += (long) (arr[i]) *  (long)(arr[i]);
        }

        // Calculate:
        // X - Y = S - Sn
        // X + Y = (S2 - Sn2) / (X - Y)
        long val1 = S - Sn;
        long val2 = (S2 - Sn2) / val1;

        // Calculating individual values from equations
        long X = (val2 + val1) / 2;
        long Y = X - val1;
        return new int[]{(int)X, (int)Y};
    }

    int[] findTwoElementBetter(int arr[], int n){
        int[] hash = new int[n+1];
        
        // Store the occurences
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        // Find the repeating and missing numbers
        int repeat = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if(hash[i] == 2) repeat = i;
            else if(hash[i] == 0) missing = i;

            if(missing != -1 && repeat != -1) break;
        }

        return new int[]{repeat, missing};
    }

    int[] findTwoElementBrute(int arr[], int n) {
        int missing = -1, repeat = -1;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(arr[j] == i){
                    count++;
                }
            }

            // Compare count
            if(count == 2){
                repeat = i;
            }
            else if(count == 0){
                missing = i;
            }
            if(missing != -1 && repeat != -1) break;
        }
        return new int[]{repeat, missing};
    }
}
