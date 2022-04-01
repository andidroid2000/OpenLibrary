package ro.onlinelibrary.library;

import ro.onlinelibrary.people.Author;

public class Books implements Comparable<Books>{
    protected String title;
    protected int publishingYear;
    protected String genre;
    protected String description;
    protected Author author;

    public Books(String title, Author author, int publishingYear, String genre, String description) {
        this.title = title;
        this.publishingYear = publishingYear;
        this.genre = genre;
        this.description = description;
        this.author = author;
    }

   public Books() {
        this.title = null;
        this.publishingYear = 0;
        this.genre = null;
        this.author = new Author();
        this.description = null;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public Author getAuthor() {return author;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(Author author) {this.author = author;}

    @Override
    public int compareTo(Books book)
    {
        return this.publishingYear - book.publishingYear;
    }
}
