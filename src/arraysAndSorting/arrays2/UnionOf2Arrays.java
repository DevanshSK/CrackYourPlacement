package arraysAndSorting.arrays2;
import java.lang.reflect.Array;
import java.util.*;

public class UnionOf2Arrays {
    /**
     * Q.   Given two sorted arrays of size n and m respectively, find their union.
     *      The Union of two arrays can be defined as the common and distinct elements in the two arrays.
     *      Return the elements in sorted order.
     *
     *      # Bruteforce solution:
     *      - Create a set and add both array elements and return those elements.
     *      - Create a new output array from the set.
     *      TC: O(M+N)  // Insertion in Hashset is O(1)
     *      SC: O(M+N)  // Considering union array/list
     *
     *      # Optimal solution: Using 2 pointers approach
     *      - Take 2 pointers and
     *
     * */

    public static List< Integer > sortedArrayBruteForce(int []a, int []b) {
        // Bruteforce
        // Bruteforce
        HashSet <Integer> s=new HashSet<>();
        for (int j : a) s.add(j);
        for (int j : b) s.add(j);
        ArrayList<Integer> Union = new ArrayList<>(s);
        Collections.sort(Union);
        return Union;
    }

    public static void main(String[] args) {
        int[] num1 = {1,1,2,3,4,5};
        int[] num2 = {2,3,4, 4,5,6};
        List<Integer> union = sortedArray(num1, num2);
        System.out.println(union);
    }

    // Better method, partial success bcuz of .contains() method
    public static List< Integer > sortedArray(int []a, int []b) {
        // This kinda works but dont use .contains() method.
        List<Integer> union = new ArrayList<>();
        int i = 0, j=0, n1 = a.length, n2 = b.length;
        // Insert elements
        while(i < n1 && j < n2){

            if(a[i] <= b[j]){
                // Element a is smaller or equal to b
                // Check if that element is already belongs to b
                if(!union.contains(a[i]))
                    union.add(a[i]);
                // move to next element
                i++;
            }else{
                // Element b is smaller than a
                if(!union.contains(b[j]))
                    // Element is unique, insert it
                    union.add(b[j]);
                j++;
            }
        }

        // Iterate remaining arrays
        while(i<n1){
            if(!union.contains(a[i])){
                // Element is unique, insert it
                union.add(a[i]);
            }
            // move to next element
            i++;
        }
        while(j<n2){
            if(!union.contains(b[j])){
                // Element is unique, insert it
                union.add(b[j]);
            }
            // move to next element
            j++;
        }
        return union;
    }


    // Best solution: fully manually
    public static List< Integer > sortedArrayOptimal(int []a, int []b) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j=0, n1 = a.length, n2 = b.length;
        // Insert elements
        while(i < n1 && j < n2){

            if(a[i] <= b[j]){
                // Element a is smaller or equal to b
                // Check if that element is already belongs to b
                if(union.size() == 0 || union.get(union.size()-1) != a[i])
                    union.add(a[i]);
                // move to next element
                i++;
            }else{
                // Element b is smaller than a
                if(union.size() == 0 || union.get(union.size()-1) != b[j])
                    // Element is unique, insert it
                    union.add(b[j]);
                j++;
            }
        }

        // Iterate remaining arrays
        while(i<n1){
            if(union.size() == 0 || union.get(union.size()-1) != a[i]){
                // Element is unique, insert it
                union.add(a[i]);
            }
            // move to next element
            i++;
        }
        while(j<n2){
            if(union.size() == 0 || union.get(union.size()-1) != b[j]){
                // Element is unique, insert it
                union.add(b[j]);
            }
            // move to next element
            j++;
        }
        return union;
    }

}
