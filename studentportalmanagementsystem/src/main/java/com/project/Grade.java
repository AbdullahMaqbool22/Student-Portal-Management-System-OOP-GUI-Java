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

// Represents the grading information for students
public class Grade implements Serializable {
    // Grade value (e.g., A, B, C)
    private String gradeValue;
    // Registration number of the student
    private String reg_num;
    // Course ID associated with the grade
    private String cID;

    // Constructors

    // Parameterized constructor with grade value and registration number
    public Grade(String gradeValue, String reg_num) {
        this.gradeValue = gradeValue;
        this.reg_num = reg_num;
    }

    // Default constructor
    public Grade() {
    }

    // Parameterized constructor with grade value, registration number, and course
    // ID
    public Grade(String gradeValue, String reg_num, String cID) {
        this.gradeValue = gradeValue;
        this.reg_num = reg_num;
        this.cID = cID;
    }

    // Getter and Setter methods

    public String getReg_num() {
        return reg_num;
    }

    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
    }

    // String representation of the Grade object
    @Override
    public String toString() {
        return "Grade " + gradeValue + "\n" + "Registration Number " + reg_num + "\n" + "Course ID " + cID;
    }

    // Save Grade data to a file using serialization
    public void saveDataToFile(Grade g1) {
        try {
            // File path for storing Grades data
            File f = new File("path_to_grades_file.ser");
            ObjectOutputStream oos;

            // Check if the file exists and append if necessary
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            // Write the Grade object to the file
            oos.writeObject(g1);
            oos.close();
        } catch (IOException e) {
            // Handle IOException
            System.out.println(e.getMessage());
        }
    }

    // Load Grade data from a file using deserialization
    public ArrayList<Grade> loadDataFromFile() {
        // List to store loaded Grade objects
        ArrayList<Grade> list = new ArrayList<>();

        try {
            // File path for loading Grades data
            File file = new File("path_to_grades_file.ser");

            // Check if the file exists
            if (file.exists()) {
                // Open an ObjectInputStream to read from the file
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    // Continue reading objects until EOFException is caught
                    while (true) {
                        // Read a Grade object from the file
                        Grade g1 = (Grade) ois.readObject();
                        // Add the Grade object to the list
                        list.add(g1);
                        // Print the Grade object (or perform other processing)
                        System.out.println(g1.toString());
                    }
                }
            }
        } catch (ClassNotFoundException | EOFException e) {
            // Handle ClassNotFoundException or EOFException
            System.out.println(e.getMessage());
        } catch (IOException e) {
            // Handle IOException
            System.out.println(e.getMessage());
        }

        // Return the list of loaded Grade objects
        return list;
    }
}
