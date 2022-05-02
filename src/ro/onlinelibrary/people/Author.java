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

    //accessors(getters) for country and language

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    //mutators(setters) for country and language

    public void setCountry(String changedCountry) {
        this.country = changedCountry;
    }

    public void setJob(String changedLanguage) {
        this.language = changedLanguage;
    }
}
