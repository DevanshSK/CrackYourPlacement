package Collections_Framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LearnArrayList {
    public static void main(String[] args) {
        // List : Parent Interface
        // ArrayList: Child class of List.
        // ArrayList<String> studentsName = new ArrayList<>();
        // studentsName.add("Rakesh");
        // System.out.println(studentsName.toString());

        // Declaration and Creation
        ArrayList<Integer> arraylist = new ArrayList<>();    // ArrayList
        List<Integer> list = new ArrayList<>();             // Another way of ArrayList
        List<Integer> linkedlist = new LinkedList<Integer>();   // LinkedList


        // .add() : add elements to list : TC O(n)
        list.add(1);
        list.add(2);
        list.add(6);
        System.out.println(list);
        list.add(1, 50);   // Adds element at given index
        System.out.println(list);


        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(22);
        newList.add(17);

        list.addAll(newList);   // Adds another list in current list
        System.out.println(list + "\n");

        // Accessing elements : TC O(1)
        System.out.println("Element at index " + 1 + " in list is " + list.get(1));

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(40);
        nums.add(50);
        nums.add(60);
        nums.add(70);
        nums.add(80);
        nums.add(90);
        System.out.println("\nRemoving Elements in ArrayList");
        System.out.println(nums);

        // .remove(), .clear() : Removing elements from List : TC is O(n)
        nums.remove(2); // Remove elements from an index
        System.out.println(nums);

        nums.remove(Integer.valueOf(50));   // Remove element based on value
        System.out.println(nums);

        nums.clear();   // Removes all the elements
        System.out.println(nums);

        // .set() : Updating Elements
        nums.set(2, 1000);  // TC is O(1)
        System.out.println(nums);

        // .contains() : Searching Elements - Returns true/false
        System.out.println(nums.contains(50));  // TC is O(n)
        System.out.println(nums.contains(500));
        
        // Traversing ArrayLists through for and forEach loop
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + " ");
        }
        System.out.println();
        for (Integer el : nums) {
            System.out.print(el + " ");
        }
        System.out.println();

        // Traversing List using iterator
        // Creating Iterator
        // Has 2 methods
        // .hasNext() : Checks if there is any element available to return
        // .next() : Returns the available element and moves to next element.
        Iterator<Integer> it = nums.iterator();
        System.out.println(it.next());  // Returns the current element

        // General way of iterating through Iterator
        while(it.hasNext()){
            System.out.println("Iterator element " + it.next());
        }
    }
}
