package ro.onlinelibrary.people;

public class Author extends BasicInfo {
    private Integer id;
    private String country;
    private String language;

    public Author(String firstName, String lastName, Integer id, String country, String language) {
        super(firstName, lastName);
        this.id = id;
        this.country = country;
        this.language = language;
    }

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

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
