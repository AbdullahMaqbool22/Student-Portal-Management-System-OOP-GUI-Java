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
 * The DisplayFeesOnStudentPanel class represents a JFrame for displaying
 * student fees.
 */
public class DisplayFeesOnStudentPanel extends JFrame {
    JLabel l1;
    JTextField t1;
    JButton b1;
    JPanel p1, p2;

    /**
     * Constructor for DisplayFeesOnStudentPanel.
     * Sets up the GUI components and event handling.
     */
    public DisplayFeesOnStudentPanel() {
        setTitle("Student Fees.");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        setVisible(true);
    }

    /**
     * ActionListener for handling button click events.
     */
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Display")) {
                String a = t1.getText();
                new FeesDisplayOnStudentDisplay(a);
            }
        }
    }
}
