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
 * The Admin class represents an administrator in the system.
 * It extends the Person class and implements the Serializable interface.
 */
public class Admin extends Person implements Serializable {
    private String position;
    private Student s1;
    private Attendance a1;
    private String password;

    public Student getS1() {
        return s1;
    }

    public void setS1(Student s1) {
        this.s1 = s1;
    }

    public Attendance getA1() {
        return a1;
    }

    public void setA1(Attendance a1) {
        this.a1 = a1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Default constructor for the Admin class.
     */
    public Admin() {
        this.position = null;
    }

    /**
     * Parameterized constructor for the Admin class.
     * 
     * @param position The position of the administrator.
     */
    public Admin(String position) {
        this.position = position;
    }

    /**
     * Parameterized constructor for the Admin class.
     * 
     * @param personId    The unique identifier for the person.
     * @param name        The name of the person.
     * @param dateOfBirth The date of birth of the person.
     * @param contactInfo The contact information of the person.
     * @param address     The address of the person.
     * @param email       The email address of the person.
     * @param position    The position of the administrator.
     * @param password    The password for authentication.
     */
    public Admin(String personId, String name, String dateOfBirth, String contactInfo, String address, String email,
            String position, String password) {
        super(personId, name, dateOfBirth, contactInfo, address, email);
        this.position = position;
        this.password = password;
    }

    /**
     * Getter for the position of the administrator.
     * 
     * @return The position of the administrator.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Setter for the position of the administrator.
     * 
     * @param position The position of the administrator.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Overrides the toString method to provide a string representation of the Admin
     * object.
     * 
     * @return A string representation of the Admin object.
     */
    @Override
    public String toString() {
        return super.toString() + " Position: " + position;
    }

    /**
     * Adds a student to the system.
     * 
     * @param s2 The Student object to be added.
     */
    public void addStudent(Student s2) {
        s1 = new Student();
        ArrayList<Student> list = s1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRegistration_number().equalsIgnoreCase(s2.getRegistration_number())) {
                return;
            }
        }
        s1.saveDataToFile(s2);
    }

    /**
     * Removes a student from the system.
     * 
     * @param reg_num The registration number of the student to be removed.
     */
    public void removeStudent(String reg_num) {
        s1 = new Student();
        ArrayList<Student> list = s1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRegistration_number().equalsIgnoreCase(reg_num)) {
                list.remove(i);
                break;
            }
        }
        try {
            File f = new File("path/to/Students.ser");
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
                for (int i = 0; i < list.size(); i++) {
                    oos.writeObject(list.get(i));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Searches for a student in the system using their registration number.
     * 
     * @param reg_num The registration number of the student to be searched.
     * @return True if the student is found, false otherwise.
     */
    public boolean searchFromFile(String reg_num) {
        s1 = new Student();
        ArrayList<Student> list = s1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRegistration_number().equals(reg_num)) {
                return true; // Found a match, no need to continue searching
            }
        }
        return false; // No match found in the entire list
    }

    /**
     * Adds attendance information for a student in a specific course.
     * 
     * @param reg_num   The registration number of the student.
     * @param attStatus The attendance status for the student.
     * @param cID       The course ID for which attendance is being recorded.
     */
    public void addAttendance(String reg_num, String attStatus, String cID) {
        s1 = new Student();
        a1 = new Attendance();
        ArrayList<Student> list = s1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (list.get(i).getRegistration_number().equalsIgnoreCase(reg_num)) {
                    a1.saveDataToFile(new Attendance(attStatus, reg_num, cID));
                    break;
                }
            }
        }
    }

    /**
     * Adds grade information for a student in a specific course.
     * 
     * @param reg_num The registration number of the student.
     * @param marks   The grade/marks for the student.
     * @param cID     The course ID for which the grade is being recorded.
     */
    public void addGrade(String reg_num, String marks, String cID) {
        s1 = new Student();
        Grade g1 = new Grade();
        ArrayList<Student> list = s1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (list.get(i).getRegistration_number().equalsIgnoreCase(reg_num)) {
                    g1.saveDataToFile(new Grade(marks, reg_num, cID));
                    break;
                }
            }
        }
    }

    /**
     * Authenticates the administrator's login credentials.
     * 
     * @param a The email address of the administrator.
     * @param b The password for authentication.
     * @return True if authentication is successful, false otherwise.
     */
    public boolean login(String a, String b) {
        ArrayList<Admin> list = loadDataFromFile();
        boolean flag = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (a.equalsIgnoreCase(list.get(i).getEmail()) && b.equals(list.get(i).getPassword())) {
                    flag = true;
                    break;
                }
            }
        }

        return flag;
    }

    /**
     * Saves the Admin object's data to a file.
     * 
     * @param a1 The Admin object to be saved.
     */
    public void saveDataToFile(Admin a1) {
        try {
            File f = new File("path/to/Admins.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(a1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Loads data of Admin objects from a file.
     * 
     * @return An ArrayList of Admin objects loaded from the file.
     */
    public ArrayList<Admin> loadDataFromFile() {
        ArrayList<Admin> list = new ArrayList<Admin>();
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("path/to/Admins.ser"))) {
                while (true) {
                    Admin s1 = (Admin) ois.readObject();
                    list.add(s1);
                    System.out.println(s1.toString());
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

    /**
     * Adds fee update information for a student.
     * 
     * @param f1      The Fees object containing fee information.
     * @param reg_num The registration number of the student.
     */
    public void addFeesUpdate(Fees f1, String reg_num) {
        s1 = new Student();
        f1 = new Fees();
        ArrayList<Student> list = s1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (list.get(i).getRegistration_number().equals(reg_num)) {
                    f1.saveDataToFile(f1);
                    break;
                }
            }
        }
    }
}
