package com.project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// Represents the home screen of the Student Portal Management System
public class HomeScreenDisplay extends JFrame {
    JLabel l1;
    JButton b1, b2, b3;

    // Constructor to initialize the home screen
    public HomeScreenDisplay() {
        // Set the size and default close operation for the JFrame
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Set the layout of the JFrame to a 4x1 grid layout
        setLayout(new GridLayout(4, 1));

        // Create a label with a welcome message
        l1 = new JLabel("Welcome to Student Portal Management System!");
        // Set the alignment of the label to the center
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setVerticalAlignment(JLabel.CENTER);

        // Create buttons for user interaction
        b1 = new JButton("User Panel");
        b2 = new JButton("Admin Panel");
        b3 = new JButton("Exit");

        // Add components to the JFrame
        add(l1);
        add(b1);
        add(b2);
        add(b3);

        // Create an ActionListener for button actions
        MyActionListener a = new MyActionListener();
        // Attach the ActionListener to each button
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);

        // Set the JFrame to be visible
        setVisible(true);
    }

    // ActionListener class to handle button actions
    public class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Check which button was clicked and perform corresponding actions
            if (e.getActionCommand().equals("User Panel")) {
                dispose(); // Close the current frame
                new StudentLogin(); // Open the Student Login frame
            } else if (e.getActionCommand().equals("Admin Panel")) {
                dispose(); // Close the current frame
                new AdminLogin(); // Open the Admin Login frame
            } else if (e.getActionCommand().equals("Exit")) {
                System.exit(0); // Exit the application
            }
        }
    }
}
