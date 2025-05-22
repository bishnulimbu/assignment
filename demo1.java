
package org.example;

import javax.swing.*;

public class StudentInsert extends JFrame {
    JPanel panel1;
    JLabel lroll, lname, laddress, lphone, lemail, lgender;
    JTextField troll, tname, taddress, tphone, temail;
    JComboBox cgender;
    JButton submit,operation,display;

    Connection conn = Database.connect();
    Statement st = null;

    void init(){
        setSize(400,300);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setResizable(false);
    }

}
