package com.project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A GUI class for adding courses on the admin panel.
 */
public class AddCoursesOnAdminPanel extends JFrame {
    // Components
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;
    JPanel p1, p2;

    /**
     * Constructor to initialize the GUI components.
     */
    public AddCoursesOnAdminPanel() {
        // Frame settings
        setTitle("Courses Update.");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(2, 1));

        // Panel 1 settings
        p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 2));

        // Panel 2 settings
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1));

        // Labels and TextFields
        l1 = new JLabel("Enter Registration Number: ");
        t1 = new JTextField(20);
        l2 = new JLabel("Enter Course ID: ");
        t2 = new JTextField(20);
        l3 = new JLabel("Enter Course Name: ");
        t3 = new JTextField(20);

        // Buttons
        b1 = new JButton("Submit");
        b2 = new JButton("Home");

        // Action Listener
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);

        // Adding components to Panel 1
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);

        // Adding buttons to Panel 2
        p2.add(b1);
        p2.add(b2);

        // Adding panels to the frame
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }

    /**
     * ActionListener for handling button clicks.
     */
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Submit")) {
                // Retrieve input values
                String a = t1.getText();
                String b = t2.getText();
                String c = t3.getText();

                // Create a Course object and save data to file
                Course c1 = new Course(b, c, a);
                c1.saveDataToFile(c1);
            } else if (e.getActionCommand().equals("Home")) {
                // Dispose the current frame and open the AdminPanel
                dispose();
                new AdminPanel();
            }
        }
    }
}