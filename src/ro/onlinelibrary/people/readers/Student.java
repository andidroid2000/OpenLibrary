package ro.onlinelibrary.people.readers;

import ro.onlinelibrary.others.Address;
import ro.onlinelibrary.people.BasicInfo;

import java.util.Objects;

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
    //accessors(getters) for school and year

    public String getSchool() {
        return school;
    }

    public int getYear() {
        return year;
    }

    //mutators(setters) for school and year

    public void setSchool(String changedSchool) {
        this.school = changedSchool;
    }

    public void setYear(int changedYear) {
        this.year = changedYear;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && school.equals(student.school) && address.equals(student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(school, year, address);
    }

    @Override
    public String toString() {
        return  firstName.toUpperCase() + " " + lastName.toUpperCase() +
                "\n # Education: studies at " +  school.toUpperCase() + ", year: " + year +
                "\n # Address: " + getAddress().getCity() + ", " + getAddress().getStreet() + ", " + getAddress().getNumber() ;
    }
}
