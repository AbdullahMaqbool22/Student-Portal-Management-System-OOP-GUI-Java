package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The AdminPanel class represents the graphical user interface for the admin
 * panel.
 * It extends JFrame and provides various buttons for different administrative
 * tasks.
 */
public class AdminPanel extends JFrame {
    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JPanel p1, p2;

    /**
     * Constructor for the AdminPanel class.
     * Sets up the GUI components and initializes action listeners for buttons.
     */
    public AdminPanel() {
        setTitle("Admin Panel");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        l1 = new JLabel("Welcome to Admin Panel.");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setVerticalAlignment(JLabel.CENTER);

        b1 = new JButton("Add Student.");
        b2 = new JButton("Delete Student.");
        b3 = new JButton("Search Student.");
        b4 = new JButton("Add Attendance.");
        b5 = new JButton("Add Grade");
        b6 = new JButton("Add Fee Status");
        b7 = new JButton("Add Courses");
        b8 = new JButton("Same Courses");
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
        p2 = new JPanel(new GridLayout(5, 2));

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

    /**
     * ActionListener implementation for handling button click events.
     */
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Add Student.")) {
                dispose();
                new StudentEntryOnAdminPanel();
            } else if (e.getActionCommand().equals("Delete Student.")) {
                dispose();
                new StudentDeletionOnAdminPanel();
            } else if (e.getActionCommand().equals("Search Student.")) {
                dispose();
                new StudentSearchOnAdminPanel();
            } else if (e.getActionCommand().equals("Add Attendance.")) {
                dispose();
                new AddAttendanceOnAdminPanel();
            } else if (e.getActionCommand().equals("Add Grade")) {
                dispose();
                new AddGradeOnAdminPanel();
            } else if (e.getActionCommand().equals("Add Fee Status")) {
                dispose();
                new AddFeeStatusOnAdminPanel();
            } else if (e.getActionCommand().equals("Add Courses")) {
                dispose();
                new AddCoursesOnAdminPanel();
            } else if (e.getActionCommand().equals("Same Courses")) {
                dispose();
                new SameCoursesDisplay();
            }
        }
    }
}
