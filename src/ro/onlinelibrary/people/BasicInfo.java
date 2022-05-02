package ro.onlinelibrary.people;

public class BasicInfo {
    protected String firstName;
    protected String lastName;

    public BasicInfo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //accessors(getters) for first name and last name
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //mutators(setters) for first name and last name
    public void setFirstName(String changedFirstName) {
        this.firstName = changedFirstName;
    }

    public void setLastName(String changedLastName) {
        this.lastName = changedLastName;
    }
}
