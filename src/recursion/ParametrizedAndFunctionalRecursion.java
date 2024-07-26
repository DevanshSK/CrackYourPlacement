package recursion;

public class ParametrizedAndFunctionalRecursion {

    // Parametrized recursion for calculating sum of n numbers
    static void sum(int i, int sum){
        if(i<1){
            System.out.println(sum);
            return;
        }

        sum(i-1, sum + i);

    }

    // Functional Recursion: Sum of n numbers
    static int func_sum(int n){
        // Create a base case
        if(n == 0) return 0;
        // Assume the n-1 case works and then prove the n case.
        return n + func_sum(n-1);
    }

    // calculate factorial
    static int calc_fact(int n){
        // base case
        if(n==0) return 1;

        // calculating result
        return n * calc_fact(n-1);
    }


    public static void main(String[] args) {
        sum(100, 0);
        System.out.println(func_sum(3));
        System.out.println(calc_fact(5));
    }
}
