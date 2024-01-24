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

public class StudentLogin extends JFrame {
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1;
    JPanel p1, p2;
    String a;

    public StudentLogin() {
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Student Login");
        setVisible(true);
        setLayout(new GridLayout(2, 1));

        p1 = new JPanel(new GridLayout(2, 2));
        p2 = new JPanel(new GridLayout(1, 1));

        l1 = new JLabel("Enter Email: ");
        t1 = new JTextField(20);
        a = t1.getText();
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

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Submit")) {
                String email = t1.getText();
                String password = t2.getText();
                Student student = new Student(email, null, null, password, null);
                if (student.login(email, password)) {
                    new StudentPanel();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Email or Password");
                }
            }
        }
    }
}

