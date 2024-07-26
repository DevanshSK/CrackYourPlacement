import java.io.*;

public class Main {
//    public static void main(String[] args) throws IOException {
//        // Take input and output in Java
//        // Simplest method
//        String[] names = {"John", "Rahul", "Dev"};
//
//        // Method 1: Outputing using BufferedWriter
//
//            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
//            writer.write("Writing to a file.\n");
//            writer.write("Here is another line dammit.");
//
//            for(String name : names){
//                writer.write("\n" + name);
//            }
//
//            writer.close();
//
//
//
//        // Read from a file using buffered reader
//        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
//        String line;
//        while((line = reader.readLine()) != null){
//            System.out.println(line);
//        }
//        reader.close();
//    }


    // Array io using scanner
//    public static void main(String[] args) throws FileNotFoundException {
//        try {
//            // Specify the path to your input file
//            File inputFile = new File("input.txt");
//
//            // Create a Scanner to read from the file
//            Scanner scanner = new Scanner(inputFile);
//
//            // Read the length of the array from the first line
//            int length = scanner.nextInt();
//
//            // Create an array to store the elements
//            int[] array = new int[length];
//
//            // Read the elements from the second line
//            for (int i = 0; i < length; i++) {
//                array[i] = scanner.nextInt();
//            }
//
//            // Close the scanner when done
//            scanner.close();
//
//            // Now you have the array and its length, you can process it as needed
//            System.out.println("Length of the array: " + length);
//            System.out.print("Elements of the array: ");
//            for (int i : array) {
//                System.out.print(i + " ");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}