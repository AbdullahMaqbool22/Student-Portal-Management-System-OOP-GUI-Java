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
 * The DisplayAttendanceOnStudentPanel class represents a JFrame for displaying
 * attendance information for a student.
 */
public class DisplayAttendanceOnStudentPanel extends JFrame {
    JLabel l1;
    JTextField t1;
    JButton b1;
    JPanel p1, p2;

    /**
     * Constructor for DisplayAttendanceOnStudentPanel.
     * Sets up the GUI components and event handling.
     */
    public DisplayAttendanceOnStudentPanel() {
        setTitle("Display Attendance.");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2, 1));
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2));
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1));
        l1 = new JLabel("Enter Registration Number: ");
        t1 = new JTextField(20);
        b1 = new JButton("Display");
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        p1.add(l1);
        p1.add(t1);
        p2.add(b1);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }

    /**
     * ActionListener for handling button click events.
     */
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Display")) {
                Student s1 = new Student();
                String a = t1.getText();
                JOptionPane.showMessageDialog(null, s1.displayAttendance(a));
            }
        }
    }
}
