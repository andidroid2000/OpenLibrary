package ro.onlinelibrary.people;

import ro.onlinelibrary.others.Address;

import java.util.Objects;

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
        Personnel personnel = (Personnel) o;
        return Float.compare(personnel.salary, salary) == 0 && address.equals(personnel.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary, address);
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }
}
