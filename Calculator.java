import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField input;
    String operator;
    double num1, num2, result;

    Calculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        input = new JTextField();
        input.setFont(new Font("Arial", Font.BOLD, 20));
        input.setHorizontalAlignment(SwingConstants.RIGHT);
        input.setEditable(false);
        add(input, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            input.setText(input.getText() + command);
        } else if (command.matches("[+\\-*/]")) {
            try {
                num1 = Double.parseDouble(input.getText());
                operator = command;
                input.setText("");
            } catch (Exception ex) {
                input.setText("Error");
            }
        } else if (command.equals("=")) {
            try {
                num2 = Double.parseDouble(input.getText());
                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num1 / num2; break;
                }
                input.setText(String.valueOf(result));
            } catch (Exception ex) {
                input.setText("Error");
            }
        } else if (command.equals("C")) {
            input.setText("");
            num1 = num2 = result = 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
