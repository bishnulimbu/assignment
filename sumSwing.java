import javax.swing.*;
import java.awt.event.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        JFrame frame = new JFrame("Sum Calculator");
        JLabel label1 = new JLable("Enter first number");
        JLabel label2 = new JLable("Enter second number");
        JTextField text1 = new JTextField(10);
        JTextField text2 = new JTextField(10);
        JButton btn1 = new JButton("Calculate sum");

        label1.setBounds(20,20,150,30);
        text1.setBounds(180,20,100,30);
        label2.setBounds(20,20,150,30);
        text2.setBounds(180,20,100,30);
        btn1.setBounds(100,100,150,30);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    int num1 = Integer.parseInt(text1.getText());
                    int num2 = Integer.parseInt(text2.getText());
                    int sum = num1+num2;
                    JOptionPane.showMessageDialog(frame,"sum "+sum);
                }catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(frame,"Please enter valid numbers.");
                }
            }
        });
        frame.add(label1);
        frame.add(text1);
        frame.add(label2);
        frame.add(text2);
        frame.add(btn1);
        frame.setSize(350,200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
