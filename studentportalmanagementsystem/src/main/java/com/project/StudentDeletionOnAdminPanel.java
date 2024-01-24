package com.project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDeletionOnAdminPanel extends JFrame {
    JLabel l1;
    JTextField t1;
    JButton b1, b2;
    JPanel p1, p2;

    public StudentDeletionOnAdminPanel() {
        setTitle("Student Delete.");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2, 1));
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2));
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 2));
        l1 = new JLabel("Enter Registration Number: ");
        t1 = new JTextField(20);
        b1 = new JButton("Delete");
        b2 = new JButton("Home");
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        p1.add(l1);
        p1.add(t1);
        p2.add(b1);
        p2.add(b2);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }

    class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Delete")) {
                Admin a1 = new Admin();
                String a = t1.getText();
                a1.removeStudent(a);
            } else if (e.getActionCommand().equals("Home")) {
                dispose();
                new AdminPanel();
            }
        }

    }
}
