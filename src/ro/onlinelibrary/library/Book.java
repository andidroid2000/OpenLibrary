package ro.onlinelibrary.library;

import ro.onlinelibrary.people.Author;

import java.util.Objects;

public class Book implements Comparable<Book>{
    protected Integer id;
    protected String title;
    protected int publishingYear;
    protected String genre;
    protected String description;
    protected Author author;

    public Book(String title, Author author, int publishingYear, String genre, String description) {
        this.title = title;
        this.publishingYear = publishingYear;
        this.genre = genre;
        this.description = description;
        this.author = author;
    }

    public Book(Integer id, String title, int publishingYear, String genre, String description, Author author) {
        this.id = id;
        this.title = title;
        this.publishingYear = publishingYear;
        this.genre = genre;
        this.description = description;
        this.author = author;
    }

    public Book(Integer id, String title, int publishingYear, String genre, String description) {
        this.id = id;
        this.title = title;
        this.publishingYear = publishingYear;
        this.genre = genre;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publishingYear == book.publishingYear && title.equals(book.title) && Objects.equals(genre, book.genre) && Objects.equals(description, book.description) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publishingYear, genre, description, author);
    }

    @Override
    public String toString() {
        return  "<< " + title.toUpperCase() + " >>" +
                "\n # Author: " + author.getFirstName() + " " + author.getLastName() +
                "\n # Genre: " + genre +
                "\n # Publishing year: " + publishingYear +
                "\n # Description:\n\t" + description;
    }

    @Override
    public int compareTo(Book book)
    {
        return this.publishingYear - book.publishingYear;
    }
}
