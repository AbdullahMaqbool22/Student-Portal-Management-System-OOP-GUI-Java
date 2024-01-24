package com.project;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * The Fees class represents the fees information of a student.
 */
public class Fees implements Serializable {
    private String status;
    private String total_fees;
    private String reg_num;

    /**
     * Constructor for Fees class.
     * 
     * @param status     The status of fees (e.g., "Paid" or "Unpaid").
     * @param total_fees The total amount of fees.
     * @param reg_num    The registration number of the student.
     */
    public Fees(String status, String total_fees, String reg_num) {
        this.status = status;
        this.total_fees = total_fees;
        this.reg_num = reg_num;
    }

    /**
     * Default constructor for Fees class.
     */
    public Fees() {
        this.status = null;
        this.total_fees = null;
        new Student();
    }

    /**
     * Constructor for Fees class without registration number.
     * 
     * @param status     The status of fees (e.g., "Paid" or "Unpaid").
     * @param total_fees The total amount of fees.
     */
    public Fees(String status, String total_fees) {
        this.status = status;
        this.total_fees = total_fees;
    }

    /**
     * Get the status of fees.
     * 
     * @return The status of fees.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status of fees.
     * 
     * @param status The status of fees.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the total amount of fees.
     * 
     * @return The total amount of fees.
     */
    public String getTotal_fees() {
        return total_fees;
    }

    /**
     * Set the total amount of fees.
     * 
     * @param total_fees The total amount of fees.
     */
    public void setTotal_fees(String total_fees) {
        this.total_fees = total_fees;
    }

    /**
     * Get the registration number of the student.
     * 
     * @return The registration number of the student.
     */
    public String getReg_num() {
        return reg_num;
    }

    /**
     * Set the registration number of the student.
     * 
     * @param reg_num The registration number of the student.
     */
    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }

    /**
     * Override toString method to represent the Fees object as a string.
     * 
     * @return String representation of Fees object.
     */
    @Override
    public String toString() {
        return " Status: " + status + " Total Fees:" + total_fees + "\n" + " Registration Number: " + reg_num;
    }

    /**
     * Save Fees data to a file.
     * 
     * @param f1 The Fees object to be saved.
     */
    public void saveDataToFile(Fees f1) {
        try {
            File f = new File(
                    "D:\\University Stuff\\Abdullah University-3\\OOP\\Lab\\Lab Work\\Final Semester Project\\studentportalmanagementsystem\\src\\main\\resources\\Fees.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(f1);
            oos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Load Fees data from a file.
     * 
     * @return List of Fees objects loaded from the file.
     */
    public ArrayList<Fees> loadDataFromFile() {
        ArrayList<Fees> list = new ArrayList<Fees>();
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                    "D:\\University Stuff\\Abdullah University-3\\OOP\\Lab\\Lab Work\\Final Semester Project\\studentportalmanagementsystem\\src\\main\\resources\\Fees.ser"))) {
                while (true) {
                    Fees f1 = (Fees) ois.readObject();
                    list.add(f1);
                    System.out.println(f1.toString());
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            return list;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
