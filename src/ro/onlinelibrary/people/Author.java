package ro.onlinelibrary.people;

public class Author extends BasicInfo {
    private String country;
    private String language;

    public Author(String firstName, String lastName, String country, String language) {
        super(firstName, lastName);
        this.country = country;
        this.language = language;
    }

    public Author()
    {
        super(null, null);
        this.country = null;
        this.language = null;
    }

    //accessors(getters) for first name, last name, employer company and job
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    //mutators(setters) for first name, last name, employer company and job
    public void setFirstName(String changedFirstName) {
        this.firstName = changedFirstName;
    }

    public void setLastName(String changedLastName) {
        this.lastName = changedLastName;
    }

    public void setCountry(String changedCountry) {
        this.country = changedCountry;
    }

    public void setJob(String changedLanguage) {
        this.language = changedLanguage;
    }
}
