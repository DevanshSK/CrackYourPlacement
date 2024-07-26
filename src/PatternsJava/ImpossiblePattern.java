package PatternsJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//public class ImpossiblePattern extends JFrame {
//
//    private JTextField textField;
//
//    public ImpossiblePattern() {
//        setTitle("Text Converter");
//        setSize(300, 200);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Create components
//        textField = new JTextField();
//        textField.setHorizontalAlignment(JTextField.CENTER);
//
//        // Add mouse listener to the text field
//        textField.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (SwingUtilities.isLeftMouseButton(e)) {
//                    // Left mouse button clicked, convert to uppercase
//                    String text = textField.getText();
//                    textField.setText(text.toUpperCase());
//                } else if (SwingUtilities.isRightMouseButton(e)) {
//                    // Right mouse button clicked, convert to lowercase
//                    String text = textField.getText();
//                    textField.setText(text.toLowerCase());
//                }
//            }
//        });
//
//        // Add components to the frame
//        setLayout(new BorderLayout());
//        add(textField, BorderLayout.CENTER);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            ImpossiblePattern app = new ImpossiblePattern();
//            app.setVisible(true);
//        });
//    }
//}

public class ImpossiblePattern {
    public static void main(String[] args) {
        String dash = "---";
        String star = ".|.";
//        int row = 7, col = 21;
        int row = 11, col = 33;
        int halves = row/2;
        int welcome = (col - 7) / 2;

        // Uper half
        for(int i = 1; i<= halves; i++){
            for(int j = halves - i + 1; j >= 1; j--){
                System.out.print(dash);
            }
            for(int j = 1; j <= (2 * i) - 1; j++){
                System.out.print(star);
            }
            for(int j = halves - i + 1; j >= 1; j--){
                System.out.print(dash);
            }

            System.out.println();
        }
        // Print welcome
        for (int i = 1; i <= welcome; i++) {
            System.out.print("-");
        }
        System.out.print("WELCOME");
        for (int i = 1; i <= welcome; i++) {
            System.out.print("-");
        }
        System.out.println();
        // Lower half
        for(int i = halves; i >= 1; i--){
            for(int j = halves - i + 1; j >= 1; j--){
                System.out.print(dash);
            }
            for(int j = 1; j <= (2 * i) - 1; j++){
                System.out.print(star);
            }
            for(int j = halves - i + 1; j >= 1; j--){
                System.out.print(dash);
            }

            System.out.println();
        }
    }
}
