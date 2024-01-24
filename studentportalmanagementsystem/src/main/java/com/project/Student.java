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

public class Student extends Person implements Serializable {
    private String registration_number;
    private Course c1;
    private Grade g1;
    private String password;
    private Fees f1;
    private Attendance a1;

    public Student(String registration_number, Course c1, Grade g1, String password, Fees f1, Attendance a1) {
        this.registration_number = registration_number;
        this.c1 = c1;
        this.g1 = g1;
        this.password = password;
        this.f1 = f1;
        this.a1 = a1;
    }

    public Student(String personId, String name, String dateOfBirth, String contactInfo, String address, String email,
            String registration_number, Course c1, Grade g1, String password, Fees f1, Attendance a1) {
        super(personId, name, dateOfBirth, contactInfo, address, email);
        this.registration_number = registration_number;
        this.c1 = c1;
        this.g1 = g1;
        this.password = password;
        this.f1 = f1;
        this.a1 = a1;
    }

    public Student() {
        super(null, null, null, null, null, null);
        this.registration_number = null;
        this.c1 = null;
        this.g1 = null;
        this.password = null;
        this.f1 = null;
        this.a1 = null;
    }

    public Student(String registration_number, Course c1, Grade g1, String password, Fees f1) {
        this.registration_number = registration_number;
        this.c1 = c1;
        this.g1 = g1;
        this.password = password;
        this.f1 = f1;
    }

    public Student(String personId, String name, String dateOfBirth, String contactInfo, String address, String email,
            String registration_number, Course c1, Grade g1, String password, Fees f1) {
        super(personId, name, dateOfBirth, contactInfo, address, email);
        this.registration_number = registration_number;
        this.c1 = c1;
        this.g1 = g1;
        this.password = password;
        this.f1 = f1;
    }

    public Student(String registration_number, Course c1, Grade g1, String password) {
        this.registration_number = registration_number;
        this.c1 = c1;
        this.g1 = g1;
        this.password = password;
    }

    public Student(String personId, String name, String dateOfBirth, String contactInfo, String address, String email,
            String registration_number, Course c1, Grade g1, String password) {
        super(personId, name, dateOfBirth, contactInfo, address, email);
        this.registration_number = registration_number;
        this.c1 = c1;
        this.g1 = g1;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student(String registration_number, Course c1, Grade g1) {
        this.registration_number = registration_number;
        this.c1 = c1;
        this.g1 = g1;
    }

    public Student(String personId, String name, String dateOfBirth, String contactInfo, String address, String email,
            String registration_number, Course c1, Grade g1) {
        super(personId, name, dateOfBirth, contactInfo, address, email);
        this.registration_number = registration_number;
        this.c1 = c1;
        this.g1 = g1;
    }

    public Student(String registration_number, Course c1) {
        this.registration_number = registration_number;
        this.c1 = c1;
    }

    public Student(String personId, String name, String dateOfBirth, String contactInfo, String address, String email,
            String registration_number, Course c1) {
        super(personId, name, dateOfBirth, contactInfo, address, email);
        this.registration_number = registration_number;
        this.c1 = c1;
    }

    // public Student() {
    // this.registration_number = null;
    // this.c1 = null;
    // this.g1 = null;
    // this.password = null;
    // this.f1 = null;
    // this.a1 = null;

    // }

    public Student(String registration_number) {
        this.registration_number = registration_number;
    }

    public Student(String personId, String name, String dateOfBirth, String contactInfo, String address, String email,
            String registration_number, String Password) {
        super(personId, name, dateOfBirth, contactInfo, address, email);
        this.registration_number = registration_number;
        this.password = Password;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    @Override
    public String toString() {
        return super.toString() + "Registration Number: " + registration_number + "\n";
    }

    public void displayFees(Student s1) {
        Fees f1 = new Fees();
        ArrayList<Fees> list = f1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getStatus().equals(null)) {
                if (this.registration_number.equals(s1.registration_number)) {
                    System.out.println(list.get(i).toString());
                }

            }
        }
    }

    public String displayCoursesEnrolled(String reg_num) {
        Course c1 = new Course();
        ArrayList<Course> list = c1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getReg_num().equals(null))
                if (list.get(i).getReg_num().equals(reg_num)) {
                    return list.get(i).toString();
                }
        }
        return "No Data to Display";
    }

    public void updateProfileEmail(String reg_num, String email) {
        ArrayList<Student> list = loadDataFromFile();
        boolean studentFound = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRegistration_number().equalsIgnoreCase(reg_num)) {
                list.get(i).setEmail(email);
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Student not found!");
            return;
        }

        try {
            File f = new File(
                    "D:\\University Stuff\\Abdullah University-3\\OOP\\Lab\\Lab Work\\Final Semester Project\\studentportalmanagementsystem\\src\\main\\resources\\Students.ser");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }

            oos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // public void enrollInCourse(String reg_num, String CourseID) {
    // ArrayList<Course> list = c1.loadDataFromFile();
    // boolean courseFound = false;

    // for (int i = 0; i < list.size(); i++) {
    // if (list.get(i)..equals(reg_num) &&
    // list.get(i).getCourseID().equalsIgnoreCase(CourseID)) {
    // setC1(c1); // Make sure setC1 method is correctly implemented
    // courseFound = true;
    // break;
    // }
    // }

    // if (!courseFound) {
    // System.out.println("Course doesn't Exist!");
    // return;
    // }
    // try {
    // File f = new File(
    // "D:\\University Stuff\\Abdullah University-3\\OOP\\Lab\\Lab Work\\Final
    // Semester
    // Project\\studentportalmanagementsystem\\src\\main\\resources\\Students.ser");
    // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

    // for (int i = 0; i < list.size(); i++) {
    // oos.writeObject(list.get(i));
    // }

    // oos.close();
    // } catch (IOException e) {
    // System.out.println(e.getMessage());
    // }
    // }

    public void displayGrade(Student s1) {
        ArrayList<Grade> list = g1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (this.registration_number.equalsIgnoreCase(s1.registration_number)) {
                System.out.println(list.get(i).getGradeValue());
            }
        }
    }

    public void addCourse(Course c2) {
        ArrayList<Course> list = c1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getCourseID().equalsIgnoreCase(c2.getCourseID())) {
                c1.saveDataToFile(c2);
            } else {
                System.out.println("Course already exists!");
                return;
            }
        }
    }

    public void removeCourse(String reg_num, String cID) {
        ArrayList<Student> list = loadDataFromFile();
        boolean courseFound = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRegistration_number().equals(reg_num)) {

                if (list.get(i).c1.getCourseID().equals(cID)) {
                    courseFound = true;
                    list.remove(i);
                }
            }
        }

        if (!courseFound) {
            System.out.println("Course doesn't Exist!");
            return;
        }
        try {
            File f = new File(
                    "D:\\University Stuff\\Abdullah University-3\\OOP\\Lab\\Lab Work\\Final Semester Project\\studentportalmanagementsystem\\src\\main\\resources\\Students.ser");
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
                for (int j = 0; j < list.size(); j++) {
                    oos.writeObject(list.get(j));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveDataToFile(Student s1) {
        try {
            File f = new File(
                    "D:\\University Stuff\\Abdullah University-3\\OOP\\Lab\\Lab Work\\Final Semester Project\\studentportalmanagementsystem\\src\\main\\resources\\Students.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(s1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Student> loadDataFromFile() {
        ArrayList<Student> list = new ArrayList<Student>();
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                    "D:\\University Stuff\\Abdullah University-3\\OOP\\Lab\\Lab Work\\Final Semester Project\\studentportalmanagementsystem\\src\\main\\resources\\Students.ser"))) {
                while (true) {
                    Student s1 = (Student) ois.readObject();
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

    public Course getC1() {
        return c1;
    }

    public void setC1(Course c1) {
        this.c1 = c1;
    }

    public Grade getG1() {
        return g1;
    }

    public void setG1(Grade g1) {
        this.g1 = g1;
    }

    public Fees getF1() {
        return f1;
    }

    public void setF1(Fees f1) {
        this.f1 = f1;
    }

    public Attendance getA1() {
        return a1;
    }

    public void setA1(Attendance a1) {
        this.a1 = a1;
    }

    public boolean login(String a, String b) {
        ArrayList<Student> list = loadDataFromFile();
        boolean flag = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (a.equalsIgnoreCase(list.get(i).getRegistration_number()) && b.equals(list.get(i).getPassword())) {
                    flag = true;
                    break;
                }
            }
        }

        return flag;
    }

    public boolean displayStudent(String reg_num) {
        ArrayList<Student> list = loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRegistration_number().equals(reg_num)) {
                return true;
            }

        }
        return false;
    }

    public String DisplayStudent(String reg_num) {
        ArrayList<Student> list = loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRegistration_number().equals(reg_num)) {
                return list.get(i).toString();
            }

        }
        return "No Data to display";
    }

    public String DisplayFeesStatus(String reg_num) {
        ArrayList<Student> list = loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRegistration_number().equals(reg_num)) {
                return list.get(i).f1.getStatus();
            }

        }
        return "No Data to display";
    }

    public String DisplayGradeStatus(String reg_num) {
        Grade g1 = new Grade();
        ArrayList<Grade> list = g1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getReg_num().equals(reg_num)) {
                if (!list.get(i).getGradeValue().equals(null)) {
                    return list.get(i).getGradeValue();

                }
            }

        }
        return "No Data to display";
    }

    public void addCourse(String reg_num, String cID) {
        Course c1 = new Course();
        ArrayList<Course> list = c1.loadDataFromFile();
        boolean courseFound = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCourseID() != null && list.get(i).getCourseID().equals(cID)) {
                courseFound = true;
                break;
            }
        }

        if (!courseFound) {
            System.out.println("Course doesn't Exist!");
            return;
        } else {
            c1.saveDataToFile(new Course(cID, reg_num));
        }

        try {
            File f = new File(
                    "D:\\University Stuff\\Abdullah University-3\\OOP\\Lab\\Lab Work\\Final Semester Project\\studentportalmanagementsystem\\src\\main\\resources\\Courses.ser");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String displayAttendance(String reg_num) {
        Attendance a1 = new Attendance();
        ArrayList<Attendance> list = a1.loadDataFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getAttendanceStatus().equals(null))
                if (list.get(i).getReg_num().equals(reg_num)) {
                    return list.get(i).toString();
                }
        }
        return "No Data to Display";
    }

}
