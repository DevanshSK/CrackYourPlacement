package dsa.basic_maths;

public class CheckPrime {
    public static String isPrime(int num) {
        //Your code goes here
        int count = 0;
        for(int i=1; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                count++;
                if((num/i) != i){
                    count++;
                }
            }
        }
        if(count == 2) return "YES";
        return "NO";
    }
    public static void main(String[] args) {
        System.out.println(isPrime(36));
    }
}
