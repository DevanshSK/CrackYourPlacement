package recursion;

public class BasicProblems {

    // Q.1 Print name n times
    static void printNameNTimes(int s, int n){
        if(s > n){
            return;
        }
        System.out.println("Devansh " + s);
        printNameNTimes(s + 1, n);
    }

    // Q.2 Print 1 to N linearly
    static void ques2(int i, int n ){
        if(i>n) return;
        System.out.println(i);
        ques2(i+1, n);
    }

    static void ques3(int i, int n){
        if(i < 1) return;
        System.out.println(i);
        ques3(i-1, n);
    }

    static void ques4(int i, int n){    // 1 to N using backtracking
        if(i<1) return;

        ques4(i-1, n);
        System.out.println(i);
    }




    public static void main(String[] args) {
//        printNameNTimes(1, 5);
//        ques2(1, 5);
//        ques3(5, 5);
        ques4(5, 5);
    }
}
