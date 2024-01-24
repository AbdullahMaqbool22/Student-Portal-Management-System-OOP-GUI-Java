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
 * The Attendance class represents the attendance records for students in a
 * course.
 * It includes information such as course details, date, attendance status,
 * registration number, and student details.
 * The class implements Serializable to support object serialization.
 */
public class Attendance implements Serializable {
    private Course c1;
    private Date d1;
    private String attendanceStatus;
    private String reg_num;
    private String cID;
    private Student s1;

    /**
     * Parameterized constructor to initialize the Attendance object with specific
     * values.
     *
     * @param att The attendance status.
     * @param reg The registration number of the student.
     * @param c   The course ID.
     */
    public Attendance(String att, String reg, String c) {
        this.attendanceStatus = att;
        this.reg_num = reg;
        this.cID = c;
    }

    /**
     * Parameterized constructor to initialize the Attendance object with specific
     * values.
     *
     * @param cID    The course ID.
     * @param attend The attendance status.
     */
    public Attendance(String cID, String attend) {
        new Course(cID);
        this.attendanceStatus = attend;
    }

    /**
     * Default constructor for the Attendance class.
     * Initializes the attendance status to null.
     */
    public Attendance() {
        this.attendanceStatus = null;
    }

    /**
     * Parameterized constructor to initialize the Attendance object with specific
     * values.
     *
     * @param c1               The course associated with the attendance.
     * @param d1               The date of the attendance record.
     * @param attendanceStatus The attendance status.
     * @param reg_num          The registration number of the student.
     * @param s1               The student associated with the attendance.
     */
    public Attendance(Course c1, Date d1, String attendanceStatus, Student s1) {
        this.c1 = c1;
        this.d1 = d1;
        this.attendanceStatus = attendanceStatus;
        this.s1 = s1;
    }

    /**
     * Parameterized constructor to initialize the Attendance object with specific
     * values.
     *
     * @param c1               The course associated with the attendance.
     * @param d1               The date of the attendance record.
     * @param attendanceStatus The attendance status.
     */
    public Attendance(Course c1, Date d1, String attendanceStatus) {
        this.c1 = c1;
        this.d1 = d1;
        this.attendanceStatus = attendanceStatus;
    }

    /**
     * Parameterized constructor to initialize the Attendance object with specific
     * values.
     *
     * @param c1               The course associated with the attendance.
     * @param attendanceStatus The attendance status.
     */
    public Attendance(Course c1, String attendanceStatus) {
        this.c1 = c1;
        this.attendanceStatus = attendanceStatus;
    }

    /**
     * Parameterized constructor to initialize the Attendance object with a specific
     * course.
     *
     * @param c1 The course associated with the attendance.
     */
    public Attendance(Course c1) {
        this.c1 = c1;
    }

    /**
     * Getter method for the course associated with the attendance.
     *
     * @return The course associated with the attendance.
     */
    public Course getC1() {
        return c1;
    }

    /**
     * Setter method for the course associated with the attendance.
     *
     * @param c1 The course to be set.
     */
    public void setC1(Course c1) {
        this.c1 = c1;
    }

    /**
     * Getter method for the attendance status.
     *
     * @return The attendance status.
     */
    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    /**
     * Setter method for the attendance status.
     *
     * @param attendanceStatus The attendance status to be set.
     */
    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    /**
     * Getter method for the date of the attendance record.
     *
     * @return The date of the attendance record.
     */
    public Date getD1() {
        return d1;
    }

    /**
     * Setter method for the date of the attendance record.
     *
     * @param d1 The date to be set.
     */
    public void setD1(Date d1) {
        this.d1 = d1;
    }

    /**
     * Getter method for the student associated with the attendance.
     *
     * @return The student associated with the attendance.
     */
    public Student getS1() {
        return s1;
    }

    /**
     * Setter method for the student associated with the attendance.
     *
     * @param s1 The student to be set.
     */
    public void setS1(Student s1) {
        this.s1 = s1;
    }

    /**
     * Getter method for the registration number of the student.
     *
     * @return The registration number of the student.
     */
    public String getReg_num() {
        return reg_num;
    }

    /**
     * Setter method for the registration number of the student.
     *
     * @param reg_num The registration number to be set.
     */
    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }

    /**
     * Getter method for the course ID.
     *
     * @return The course ID.
     */
    public String getcID() {
        return cID;
    }

    /**
     * Setter method for the course ID.
     *
     * @param cID The course ID to be set.
     */
    public void setcID(String cID) {
        this.cID = cID;
    }

    /**
     * Saves the Attendance object to a file using object serialization.
     *
     * @param a1 The Attendance object to be saved.
     */
    public void saveDataToFile(Attendance a1) {
        try {
            File f = new File("path/to/your/project/resources/Attendances.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(a1);
            oos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Loads Attendance objects from a file using object deserialization.
     *
     * @return An ArrayList of Attendance objects loaded from the file.
     */
    public ArrayList<Attendance> loadDataFromFile() {
        ArrayList<Attendance> list = new ArrayList<>();
        try {
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("path/to/your/project/resources/Attendances.ser"))) {
                while (true) {
                    Attendance a1 = (Attendance) ois.readObject();
                    list.add(a1);
                    System.out.println(a1.toString());
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
     * Returns a string representation of the Attendance object.
     *
     * @return A string representation of the Attendance object.
     */
    @Override
    public String toString() {
        return "Reg Num " + reg_num + "\n" + "Course ID " + cID + "\n" + " Attendance Status: " + attendanceStatus
                + "\n";
    }
}
