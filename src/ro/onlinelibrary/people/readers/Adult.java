package ro.onlinelibrary.people.readers;

import ro.onlinelibrary.others.Address;
import ro.onlinelibrary.people.BasicInfo;

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
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployerCompany() {
        return employerCompany;
    }

    public String getJob() {
        return job;
    }

    //mutators(setters) for first name, last name, employer company and job
    public void setFirstName(String changedFirstName) {
        this.firstName = changedFirstName;
    }

    public void setLastName(String changedLastName) {
        this.lastName = changedLastName;
    }

    public void setEmployerCompany(String changedEmployerCompany) {
        this.employerCompany = changedEmployerCompany;
    }

    public void setJob(String changedJob) {
        this.job = changedJob;
    }
}
