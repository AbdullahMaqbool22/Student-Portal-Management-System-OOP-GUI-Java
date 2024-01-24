package com.project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentPanel extends JFrame {
    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JPanel p1, p2;

    public StudentPanel() {
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        l1 = new JLabel("Welcome to Student Panel.");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setVerticalAlignment(JLabel.CENTER);

        b1 = new JButton("Display Profile.");
        b2 = new JButton("Display Fees Status.");
        b4 = new JButton("Update Email.");
        b6 = new JButton("Display Grades");
        b5 = new JButton("Enroll Course");
        b3 = new JButton("Display Courses.");
        b7 = new JButton("Remove Course");
        b8 = new JButton("Display Attendance");
        MyActionListener a = new MyActionListener();

        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);
        b6.addActionListener(a);
        b7.addActionListener(a);
        b8.addActionListener(a);
        // Initialize p1 and p2
        p1 = new JPanel(new GridLayout(1, 1));
        p2 = new JPanel(new GridLayout(4, 2));

        p1.add(l1);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b7);
        p2.add(b8);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Display Profile.")) {
                dispose();
                new DisplayProfileOnStudentPanel(); // Done
            } else if (e.getActionCommand().equals("Display Fees Status.")) {
                dispose();
                new DisplayFeesOnStudentPanel(); // Done
            } else if (e.getActionCommand().equals("Update Email.")) {
                dispose();
                new UpdateEmailOnStudentPanel(); // Done
            } else if (e.getActionCommand().equals("Display Grades")) {
                dispose();
                new DisplayGradesOnStudentPanel(); // Done
            } else if (e.getActionCommand().equals("Enroll Course")) {
                dispose();
                new AddCourseOnStudentPanel(); // Done
            } else if (e.getActionCommand().equals("Display Courses.")) {
                dispose();
                new DisplayCoursesEnrolledOnStudentPanel(); // Done
            } else if (e.getActionCommand().equals("Remove Course")) {
                dispose();
                new RemoveEnrolledCoursesOnStudentPanel();
            } else if (e.getActionCommand().equals("Display Attendance")) {
                dispose();
                new DisplayAttendanceOnStudentPanel();
            }
        }

    }
}
