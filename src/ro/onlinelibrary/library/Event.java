package ro.onlinelibrary.library;

import java.util.Objects;

public class Event {
    private String name;
    private String description;
    private String date;

    public Event(String name, String description, String date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDay()
    {
        String[] arrayDate = date.split("\\.");
        return Integer.parseInt(arrayDate[0]);
    }
    public int getMonth()
    {
        String[] arrayDate = date.split("\\.");
        return Integer.parseInt(arrayDate[1]);
    }
    public int getYear()
    {
        String[] arrayDate = date.split("\\.");
        return Integer.parseInt(arrayDate[2]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return name.equals(event.name) && Objects.equals(description, event.description) && date.equals(event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, date);
    }

    @Override
    public String toString() {
        return "\n\t<< " + name.toUpperCase() + " >>" +
                "\n # Date: " + date +
                "\n # Description:\n\t" + description;
    }
}
