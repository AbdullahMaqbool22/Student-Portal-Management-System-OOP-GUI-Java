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

public class RemoveEnrolledCoursesOnStudentPanel extends JFrame {
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1, b2, b3;
    JPanel p1, p2;

    public RemoveEnrolledCoursesOnStudentPanel() {
        setTitle("Remove Enrolled Courses");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2, 1));
        p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 2));
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 3));
        l1 = new JLabel("Enter Registration Number: ");
        t1 = new JTextField(20);
        l2 = new JLabel("Enter CourseID: ");
        t2 = new JTextField(20);
        b1 = new JButton("Remove");
        b2 = new JButton("Display");
        b3 = new JButton("Home");
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Remove")) {
                // User clicked the "Remove" button
                Student s1 = new Student();
                String registrationNumber = t1.getText();
                String courseID = t2.getText();
                s1.removeCourse(registrationNumber, courseID);
            } else if (e.getActionCommand().equals("Display")) {
                // User clicked the "Display" button
                Student s1 = new Student();
                String registrationNumber = t1.getText();
                JOptionPane.showMessageDialog(null, s1.displayCoursesEnrolled(registrationNumber));
            } else if (e.getActionCommand().equals("Home")) {
                // User clicked the "Home" button
                dispose();
                new StudentPanel();
            }
        }
    }
}
