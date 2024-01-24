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

public class UpdateEmailOnStudentPanel extends JFrame {
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1, b2, b3;
    JPanel p1, p2;

    public UpdateEmailOnStudentPanel() {
        setTitle("Update Email.");
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
        l2 = new JLabel("Enter Email: ");
        t2 = new JTextField(20);
        b1 = new JButton("Enter");
        b2 = new JButton("Display");
        b3 = new JButton("Home");
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
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
            if (e.getActionCommand().equals("Enter")) {
                Student s1 = new Student();
                String a = t1.getText();
                String b = t2.getText();
                s1.updateProfileEmail(a, b);
            } else if (e.getActionCommand().equals("Display")) {
                Student s1 = new Student();
                String a = t1.getText();
                JOptionPane.showMessageDialog(null, s1.DisplayStudent(a));
            } else if (e.getActionCommand().equals("Home")) {
                dispose();
                new StudentPanel();
            }
        }

    }

}
