package com.project;

import java.io.Serializable;

/**
 * The Date class represents a date with day, month, and year attributes.
 */
class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    /**
     * Default constructor for Date class.
     * Initializes day, month, and year to 0.
     */
    public Date() {
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    /**
     * Parameterized constructor for Date class.
     * 
     * @param d The day.
     * @param m The month.
     * @param y The year.
     */
    public Date(int d, int m, int y) {
        this.day = d;
        this.month = m;
        this.year = y;
    }

    /**
     * Copy constructor for Date class.
     * 
     * @param d The Date object to be copied.
     */
    public Date(Date d) {
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }

    /**
     * Setter method for setting the day.
     * 
     * @param day The day to set.
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Setter method for setting the month.
     * 
     * @param month The month to set.
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Setter method for setting the year.
     * 
     * @param year The year to set.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Getter method for retrieving the day.
     * 
     * @return The day.
     */
    public int getDay() {
        return day;
    }

    /**
     * Getter method for retrieving the month.
     * 
     * @return The month.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Getter method for retrieving the year.
     * 
     * @return The year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Display method to print the date in the format "day - month - year".
     */
    public void Display() {
        System.out.println(day + " - " + month + " - " + year);
    }

    /**
     * toString method to represent the Date object as a string.
     * 
     * @return A string representation of the Date object.
     */
    public String toString() {
        return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
    }
}
