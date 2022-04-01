package ro.onlinelibrary.people.readers;

import ro.onlinelibrary.others.Address;
import ro.onlinelibrary.people.BasicInfo;

public class Student extends BasicInfo {
    private String school;
    private int year;
    private Address address;

    public Student(String firstName, String lastName, String school, int year, Address address) {
        super(firstName, lastName);
        this.school = school;
        this.year = year;
        this.address = address;
    }
    //accessors(getters) for first name, last name, school and year
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSchool() {
        return school;
    }

    public int getYear() {
        return year;
    }

    //mutators(setters) for first name, last name,  school and year
    public void setFirstName(String changedFirstName) {
        this.firstName = changedFirstName;
    }

    public void setLastName(String changedLastName) {
        this.lastName = changedLastName;
    }

    public void setSchool(String changedSchool) {
        this.school = changedSchool;
    }

    public void setYear(int changedYear) {
        this.year = changedYear;
    }
}
