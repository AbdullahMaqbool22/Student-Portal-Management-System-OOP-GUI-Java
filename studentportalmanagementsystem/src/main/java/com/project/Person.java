package com.project;

import java.io.Serializable;

public class Person implements Serializable {
    protected String personId;
    protected String name;
    protected String dateOfBirth;
    protected String contactInfo;
    protected String address;
    protected String email;

    public Person() {
        this.personId = null;
        this.name = null;
        this.dateOfBirth = null;
        this.contactInfo = null;
        this.address = null;
        this.email = null;
    }

    public Person(String personId, String name, String dateOfBirth, String contactInfo, String address, String email) {
        this.personId = personId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contactInfo = contactInfo;
        this.address = address;
        this.email = email;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "IDUni: " + personId + "\n" + "Name: " + name + "\n" + "Date of Birth: " + dateOfBirth + "\n"
                + " Contact Info: "
                + contactInfo + "\n" + "Address: " + address + "\n" + "Email: " + email + "\n";
    }

}
