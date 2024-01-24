package com.project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The AdminLogin class represents the graphical user interface for administrator login.
 * It extends JFrame and includes fields for entering email and password, and a button for submission.
 */
public class AdminLogin extends JFrame {
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1;
    JPanel p1, p2;

    /**
     * Constructor for the AdminLogin class.
     * Sets up the GUI components.
     */
    public AdminLogin() {
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Admin Login");
        setVisible(true);
        setLayout(new GridLayout(2, 1));

        p1 = new JPanel(new GridLayout(2, 2));
        p2 = new JPanel(new GridLayout(1, 1));

        l1 = new JLabel("Enter Email: ");
        t1 = new JTextField(20);
        l2 = new JLabel("Enter Password: ");
        t2 = new JTextField(20);

        b1 = new JButton("Submit");
        b1.addActionListener(new MyActionListener());

        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);

        p2.add(b1);

        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }

    /**
     * ActionListener implementation for handling button click events.
     */
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Submit")) {
                String email = t1.getText();
                String password = t2.getText();
                Admin admin = new Admin(null, null, null, null, null, email, null, password);
                if (admin.login(email, password)) {
                    dispose();
                    new AdminPanel();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Email or Password");
                }
            }
        }
    }

    /**
     * Main method for testing purposes.
     * Creates an instance of Admin and saves data to a file.
     */
    public static void main(String[] args) {
        Admin admin = new Admin(null, null, null, null, null, "fgh", null, "123");
        admin.saveDataToFile(admin);
    }
}
