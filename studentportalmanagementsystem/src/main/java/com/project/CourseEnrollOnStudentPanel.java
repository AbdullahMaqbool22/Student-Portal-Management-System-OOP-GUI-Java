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
 * The CourseEnrollOnStudentPanel class represents a GUI window for enrolling in
 * courses on the student panel.
 * It allows the user to enter the registration number and course ID, then
 * enroll in a course or display enrolled courses.
 */
public class CourseEnrollOnStudentPanel extends JFrame {
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1, b2;
    JPanel p1, p2;

    /**
     * Constructor for CourseEnrollOnStudentPanel class.
     * Sets up the GUI components and initializes the window.
     */
    public CourseEnrollOnStudentPanel() {
        setTitle("Course Enroll.");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2, 1));

        p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 2));
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 2));

        l1 = new JLabel("Enter Registration Number: ");
        t1 = new JTextField(20);
        l2 = new JLabel("Enter Course ID: ");
        t2 = new JTextField(20);

        b1 = new JButton("Enter");
        b2 = new JButton("Display");

        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);

        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);

        p2.add(b1);
        p2.add(b2);

        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }

    /**
     * ActionListener implementation for handling button clicks.
     */
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Enter")) {
                Student s1 = new Student();
                String regNum = t1.getText();
                String courseID = t2.getText();
                s1.addCourse(regNum, courseID);
            } else if (e.getActionCommand().equals("Display")) {
                Student s1 = new Student();
                String regNum = t1.getText();
                JOptionPane.showMessageDialog(null, s1.displayCoursesEnrolled(regNum));
            }
        }
    }
}
