import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    //different types of functionButtons
    JButton additonButton, subtractButton, multiplyButton, divideButton;
    JButton decimalButton, equalsButton, deleteButton, clearButton;
    //panel to store all the buttons
    JPanel panel;

    Font myFont = new Font("Segoe UI", Font.TRUETYPE_FONT, 25);
    ImageIcon calc;
    ImageIcon del;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(415, 550);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setBounds(50, 35, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //function buttons
        additonButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("<-");
        clearButton = new JButton("C");

        //add function buttons to the array ("functionButtons")
        functionButtons[0] = additonButton;
        functionButtons[1] = subtractButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;

        //add actionlistener to the function buttons
        for(int i = 0; i < 8; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setBackground(Color.PINK);
            functionButtons[i].setFocusable(false);
        }

        //instantiating the array numberButtons & converting "i" to a String
        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setBackground(Color.WHITE);
            numberButtons[i].setFocusable(false);
        }

        deleteButton.setBounds(280, 140, 70, 50);
        deleteButton.setBackground(Color.ORANGE);
        clearButton.setBounds(202, 140, 70, 50);
        clearButton.setBackground(Color.RED);

        equalsButton.setBackground(Color.GREEN);

        panel = new JPanel();
        panel.setBounds(50, 200, 300, 280);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        //add buttons to the panel
        //first row
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(additonButton);

        //second row
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);

        //third row
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divideButton);

        frame.add(panel);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
        calc = new ImageIcon("src/Icons/calc.jpg");
        frame.setIconImage(calc.getImage());
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decimalButton){
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == additonButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource() == subtractButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if(e.getSource() == multiplyButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if(e.getSource() == divideButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if(e.getSource() == equalsButton){
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == clearButton){
            textField.setText("");
        }

        if(e.getSource() == deleteButton){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length() -1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }
}