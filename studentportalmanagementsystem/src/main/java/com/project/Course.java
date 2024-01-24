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
 * The Course class represents a course in the student portal management system.
 * It includes information such as course ID, course name, instructor,
 * registration number, and associated student details.
 * The class implements Serializable to support object serialization.
 */
public class Course implements Serializable {
    private String courseID;
    private String courseName;
    private String instructor;
    private String reg_num;
    private Student s1;

    /**
     * Parameterized constructor to initialize the Course object with specific
     * values.
     *
     * @param cID     The course ID.
     * @param reg_num The registration number of the student associated with the
     *                course.
     */
    public Course(String cID, String reg_num) {
        this.courseID = cID;
        this.reg_num = reg_num;
    }

    /**
     * Default constructor for the Course class.
     * Initializes the course ID, course name, and instructor to null.
     */
    public Course() {
        this.courseID = null;
        this.courseName = null;
        this.instructor = null;
    }

    /**
     * Parameterized constructor to initialize the Course object with a specific
     * course ID.
     *
     * @param cID The course ID.
     */
    public Course(String cID) {
        this.courseID = cID;
    }

    /**
     * Parameterized constructor to initialize the Course object with specific
     * values.
     *
     * @param courseID   The course ID.
     * @param reg_num    The registration number of the student associated with the
     *                   course.
     * @param courseName The course name.
     */
    public Course(String courseID, String reg_num, String courseName) {
        this.courseID = courseID;
        this.reg_num = reg_num;
        this.courseName = courseName;
    }

    /**
     * Getter method for the course ID.
     *
     * @return The course ID.
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Setter method for the course ID.
     *
     * @param courseID The course ID to be set.
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * Getter method for the course name.
     *
     * @return The course name.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Setter method for the course name.
     *
     * @param courseName The course name to be set.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Getter method for the instructor of the course.
     *
     * @return The instructor of the course.
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * Setter method for the instructor of the course.
     *
     * @param instructor The instructor to be set.
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    /**
     * Getter method for the registration number of the student associated with the
     * course.
     *
     * @return The registration number of the student.
     */
    public String getReg_num() {
        return reg_num;
    }

    /**
     * Setter method for the registration number of the student associated with the
     * course.
     *
     * @param reg_num The registration number to be set.
     */
    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }

    /**
     * Getter method for the student associated with the course.
     *
     * @return The student associated with the course.
     */
    public Student getS1() {
        return s1;
    }

    /**
     * Setter method for the student associated with the course.
     *
     * @param s1 The student to be set.
     */
    public void setS1(Student s1) {
        this.s1 = s1;
    }

    /**
     * Returns a string representation of the Course object.
     *
     * @return A string representation of the Course object.
     */
    @Override
    public String toString() {
        return "CourseID: " + courseID + "\n" + "Reg_num: " + reg_num + "\n" + "Course name: " + courseName;
    }

    /**
     * Saves the Course object to a file using object serialization.
     *
     * @param c1 The Course object to be saved.
     */
    public void saveDataToFile(Course c1) {
        try {
            File f = new File("path/to/your/project/resources/Courses.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(c1);
            oos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a course to the list of courses.
     * If the course with the same course ID already exists, it displays a message
     * indicating that the course already exists.
     *
     * @param c2 The Course object to be added.
     */
    public void addCourse(Course c2) {
        ArrayList<Course> list = loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getCourseID().equalsIgnoreCase(c2.getCourseID())) {
                saveDataToFile(c2);
            } else {
                System.out.println("Course already exists!");
                return;
            }
        }
    }

    /**
     * Loads Course objects from a file using object deserialization.
     *
     * @return An ArrayList of Course objects loaded from the file.
     */
    public ArrayList<Course> loadDataFromFile() {
        ArrayList<Course> list = new ArrayList<>();
        try {
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("path/to/your/project/resources/Courses.ser"))) {
                while (true) {
                    Course c1 = (Course) ois.readObject();
                    list.add(c1);
                    System.out.println(c1.toString());
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
