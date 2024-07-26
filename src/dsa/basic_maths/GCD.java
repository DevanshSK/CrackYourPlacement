package dsa.basic_maths;
import java.lang.Math;

public class GCD {
    public static int calcGCD(int n, int m){    // tc: linear
        int gcd = 1;
        for(int i=1; i <= Math.min(n,m); i++){
            if(n%i == 0 && m%i == 0){
                gcd = i;
            }
        }
        return gcd;
    }

    public static int calcGCD2(int n, int m){
        // improved approach using euclidean algorithm
        int ans = 1;

        while(n > 0 && m > 0){
            if(n>m){
                n = n % m;
            }
            else{
                m = m % n;
            }
        }

        if(n==0){
            ans = m;
        }
        else{
            ans = n;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
