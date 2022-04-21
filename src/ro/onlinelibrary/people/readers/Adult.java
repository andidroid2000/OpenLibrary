package ro.onlinelibrary.people.readers;

import ro.onlinelibrary.others.Address;
import ro.onlinelibrary.people.BasicInfo;

import java.util.Objects;

public class Adult extends BasicInfo {
    private String employerCompany;
    private String job;
    private Address address;

    public Adult(String firstName, String lastName, String employerCompany, String job, Address address) {
        super(firstName, lastName);
        this.employerCompany = employerCompany;
        this.job = job;
        this.address = address;
    }

    //accessors(getters) for first name, last name, employer company and job

    public String getEmployerCompany() {
        return employerCompany;
    }

    public String getJob() {
        return job;
    }

    public Address getAddress(){
        return address;
    }

    //mutators(setters) employer company and job

    public void setEmployerCompany(String changedEmployerCompany) {
        this.employerCompany = changedEmployerCompany;
    }

    public void setJob(String changedJob) {
        this.job = changedJob;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adult adult = (Adult) o;
        return employerCompany.equals(adult.employerCompany) && job.equals(adult.job) && address.equals(adult.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employerCompany, job, address);
    }

    @Override
    public String toString() {
        return "Adult{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employerCompany='" + employerCompany + '\'' +
                ", job='" + job + '\'' +
                ", address=" + address +
                '}';
    }
}
