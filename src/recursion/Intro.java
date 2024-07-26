package recursion;

public class Intro {
    public static int f(int n){
        // Base case
        if(n < 10)  return n;

        // Some processing
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n/=10;
        }
        // Recursive call : Assuming f(n-1) works
        return f(sum);
    }

    static int count = 0;
    static void count(){

        if(count == 4)  return;
        System.out.println(count++);
        count();
    }


    public static void main(String[] args) {
//        System.out.println(f(123));
        count();
    }
}
