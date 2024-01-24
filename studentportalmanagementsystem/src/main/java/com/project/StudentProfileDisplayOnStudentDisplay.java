package com.project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentProfileDisplayOnStudentDisplay extends JFrame {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextArea t1, t2, t3, t4, t5, t6, t7, t8;
    JButton b2, b3, b4;
    JPanel p1, p2;
    Student s1 = new Student();

    public StudentProfileDisplayOnStudentDisplay(String reg_num) {
        setTitle("Student Profile Display.");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2, 1));
        p1 = new JPanel();
        p1.setLayout(new GridLayout(8, 2));
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 2));
        ArrayList<Student> list = s1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getRegistration_number().equals(null)) {
                if (list.get(i).getRegistration_number().equals(reg_num)) {
                    l1 = new JLabel("Name: ");
                    t1 = new JTextArea(list.get(i).getName());
                    l2 = new JLabel("Person ID: ");
                    t2 = new JTextArea(list.get(i).getPersonId());
                    l3 = new JLabel("Enter Date of Birth: ");
                    t3 = new JTextArea(list.get(i).getDateOfBirth());
                    l4 = new JLabel("Enter Contact: ");
                    t4 = new JTextArea(list.get(i).getContactInfo());
                    l5 = new JLabel("Enter Address: ");
                    t5 = new JTextArea(list.get(i).getAddress());
                    l6 = new JLabel("Enter Email: ");
                    t6 = new JTextArea(list.get(i).getEmail());
                    l7 = new JLabel("Enter Registration Number: ");
                    t7 = new JTextArea(list.get(i).getRegistration_number());
                    l8 = new JLabel("Create Password: ");
                    t8 = new JTextArea(list.get(i).getPassword());
                }

            }
        }

        b2 = new JButton("Exit");
        b4 = new JButton("Home");

        MyActionListener a = new MyActionListener();
        b2.addActionListener(a);
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

        add(b2);
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
        p2.add(b2);
        p2.add(b4);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Exit")) {
                System.exit(0);
            } else if (e.getActionCommand().equals("Home")) {
                dispose();
                new StudentPanel();
            }
        }

    }
}
