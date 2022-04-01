package ro.onlinelibrary.people;

import ro.onlinelibrary.others.Address;

public class Personnel extends BasicInfo{
    private float salary;
    private Address address;
    public Personnel(String firstName, String lastName, float salary, Address address) {
        super(firstName, lastName);
        this.salary = salary;
        this.address = address;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
}
