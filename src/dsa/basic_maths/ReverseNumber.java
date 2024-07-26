package dsa.basic_maths;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 7786;
        int rev = 0;

        // Reversing using place value number
        while(n > 0){
            int digit = n % 10;
            n = n/10;
            rev = rev*10 + digit;
        }


        System.out.println("Reversed : " + rev);
    }
}
