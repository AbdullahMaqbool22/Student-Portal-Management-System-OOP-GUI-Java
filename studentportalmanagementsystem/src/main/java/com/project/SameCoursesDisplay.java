package com.project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SameCoursesDisplay extends JFrame {
    JLabel l1;
    JTextField t1;
    JButton b1;
    JPanel p1, p2;

    public SameCoursesDisplay() {
        // Frame setup
        setTitle("Same Courses Display.");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2, 1));

        // Panel setup
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2));
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1));

        // Components setup
        l1 = new JLabel("Enter Course Name: ");
        t1 = new JTextField(20);
        b1 = new JButton("Display");

        // ActionListener setup
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);

        // Adding components to panels and frame
        p1.add(l1);
        p1.add(t1);
        p2.add(b1);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Display")) {
                // User clicked the "Display" button
                String a = t1.getText();
                Course c1 = new Course();
                ArrayList<Course> list = c1.loadDataFromFile();
                for (int i = 0; i < list.size(); i++) {
                    // Check if the course name matches the entered value
                    if (list.get(i).getCourseName().equals(a)) {
                        JOptionPane.showMessageDialog(null, list.get(i));
                    }
                }
            }
        }
    }
}
