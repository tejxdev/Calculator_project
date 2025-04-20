
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    private JFrame frame;
    private JTextField textField;
    private double num1, num2, result;
    private String operator;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Calculator window = new Calculator();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Calculator() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setBounds(10, 11, 364, 50);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        // Buttons for digits and operations
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        int xPos = 10, yPos = 70;
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.setBounds(xPos, yPos, 80, 80);
            frame.getContentPane().add(button);

            // Action listeners for button clicks
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = textField.getText();

                    switch (label) {
                        case "C":
                            textField.setText("");
                            break;
                        case "=":
                            num2 = Double.parseDouble(text);
                            switch (operator) {
                                case "+":
                                    result = num1 + num2;
                                    break;
                                case "-":
                                    result = num1 - num2;
                                    break;
                                case "*":
                                    result = num1 * num2;
                                    break;
                                case "/":
                                    result = num1 / num2;
                                    break;
                            }
                            textField.setText(String.valueOf(result));
                            break;
                        case "+":
                        case "-":
                        case "*":
                        case "/":
                            operator = label;
                            num1 = Double.parseDouble(text);
                            textField.setText("");
                            break;
                        default:
                            textField.setText(text + label);
                            break;
                    }
                }
            });

            xPos += 90;
            if (xPos > 300) {
                xPos = 10;
                yPos += 90;
            }
        }
    }
}
