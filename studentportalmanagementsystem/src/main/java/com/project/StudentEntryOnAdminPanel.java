package com.project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentEntryOnAdminPanel extends JFrame {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JButton b1, b2, b3, b4;
    JPanel p1, p2;

    public StudentEntryOnAdminPanel() {
        setTitle("Student Entry.");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2, 1));
        p1 = new JPanel();
        p1.setLayout(new GridLayout(8, 2));
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 4));
        l1 = new JLabel("Enter Name: ");
        t1 = new JTextField(20);
        l2 = new JLabel("Enter Person ID: ");
        t2 = new JTextField(3);
        l3 = new JLabel("Enter Date of Birth: ");
        t3 = new JTextField(5);
        l4 = new JLabel("Enter Contact: ");
        t4 = new JTextField(20);
        l5 = new JLabel("Enter Address: ");
        t5 = new JTextField(20);
        l6 = new JLabel("Enter Email: ");
        t6 = new JTextField(20);
        l7 = new JLabel("Enter Registration Number: ");
        t7 = new JTextField(20);
        l8 = new JLabel("Create Password: ");
        t8 = new JTextField(20);

        b1 = new JButton("Submit");
        b2 = new JButton("Exit");
        b3 = new JButton("Display");
        b4 = new JButton("Home");

        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(l8);
        add(t8);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);
        p1.add(l5);
        p1.add(t5);
        p1.add(l6);
        p1.add(t6);
        p1.add(l7);
        p1.add(t7);
        p1.add(l8);
        p1.add(t8);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Submit")) {
                String a = t1.getText();
                String b = t2.getText();
                String c = t3.getText();
                String d = t4.getText();
                String k = t5.getText();
                String f = t6.getText();
                String g = t7.getText();
                String h = t8.getText();
                Student s1 = new Student(b, a, c, d, k, f, g, h);
                s1.saveDataToFile(s1);
            } else if (e.getActionCommand().equals("Display")) {
                Student s1 = new Student();
                ArrayList<Student> list = s1.loadDataFromFile();
                for (int i = 0; i < list.size(); i++) {
                    JOptionPane.showMessageDialog(null, list.get(i).toString());

                }
            } else if (e.getActionCommand().equals("Exit")) {
                System.exit(0);
            } else if (e.getActionCommand().equals("Home")) {
                dispose();
                new AdminPanel();
            }
        }

    }

}
