package com.project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FeesDisplayOnStudentDisplay extends JFrame {
    JLabel l1, l2;
    JTextArea t1, t2;
    JButton b1;
    JPanel p1, p2;
    Fees f1 = new Fees();

    public FeesDisplayOnStudentDisplay(String reg_num) {
        setTitle("Display Fees.");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 2));
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1));
        ArrayList<Fees> list = f1.loadDataFromFile();

        // Find the Fees object associated with the given registration number
        Fees studentFees = null;
        for (Fees fees : list) {
            if (fees.getReg_num() != null && fees.getReg_num().equals(reg_num)) {
                studentFees = fees;
                break;
            }
        }

        if (studentFees != null) {
            l1 = new JLabel("Fees Status: ");
            t1 = new JTextArea(studentFees.getStatus());
            l2 = new JLabel("Total Fees: ");
            t2 = new JTextArea(studentFees.getTotal_fees());
        }

        b1 = new JButton("Home");
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p2.add(b1);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Home")) {
                dispose();
                new StudentPanel();
            }
        }
    }
}
