package ro.onlinelibrary.library;

import java.util.*;

import ro.onlinelibrary.people.Author;
import ro.onlinelibrary.people.readers.Student;
import ro.onlinelibrary.people.readers.Adult;

public class ServiceOnlineLibrary implements ServiceOnlineLibraryInterface {

    // generate the storage place for the info of the library
    public static void generateLibrary(OnlineLibrary onlineLibrary) {

        List<List<Books>> booksBorrowedByStudents = new ArrayList<>();
        List<List<Books>> booksBorrowedByAdults = new ArrayList<>();

        for (int i = 0; i < onlineLibrary.getNoOfStudentReaders(); i++) {
            List<Books> arrayBooksBorrowedByStudent = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Books aux = new Books();
                arrayBooksBorrowedByStudent.add(aux);
            }
            booksBorrowedByStudents.add(arrayBooksBorrowedByStudent);
        }
        onlineLibrary.setBooksBorrowedByStudents(booksBorrowedByStudents);

        for (int i = 0; i < onlineLibrary.getNoOfAdultReaders(); i++) {
            List<Books> arrayBooksBorrowedByAdult = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Books aux = new Books();
                arrayBooksBorrowedByAdult.add(aux);
            }
            booksBorrowedByAdults.add(arrayBooksBorrowedByAdult);
        }
        onlineLibrary.setBooksBorrowedByAdults(booksBorrowedByAdults);
    }

    // using polymorphism (overloading), I upload the info for specific person (student or adult) about the books he borrowed
    static public void borrowsBook(OnlineLibrary onlineLibrary, Student student, Books book) {
        onlineLibrary.studentBorrowsBook(student, book);
    }

    static public void borrowsBook(OnlineLibrary onlineLibrary, Adult adult, Books book) {
        onlineLibrary.adultBorrowsBook(adult, book);
    }

    // using polymorphism (overloading), I get the info for specific person (student or adult) about the books he borrowed
    static public String showBorrowedBooks(OnlineLibrary onlineLibrary, Student student) {
        int max = 4;
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        List<Books> booksBorrowed = onlineLibrary.getBooksBorrowedByStudents().get(onlineLibrary.getStudents().indexOf(student));
        return onlineLibrary.showBorrowedBooks(firstName, lastName, max, booksBorrowed);
    }

    static public String showBorrowedBooks(OnlineLibrary onlineLibrary, Adult adult) {
        int max = 3;
        String firstName = adult.getFirstName();
        String lastName = adult.getLastName();
        List<Books> booksBorrowed = onlineLibrary.getBooksBorrowedByAdults().get(onlineLibrary.getAdults().indexOf(adult));
        return onlineLibrary.showBorrowedBooks(firstName, lastName, max, booksBorrowed);
    }

    // method to show all the readers
    static public String showReaders(OnlineLibrary onlineLibrary) {
        return onlineLibrary.showReaders();
    }
    // methods to show all the books + ordered books
    static public String showBooks(OnlineLibrary onlineLibrary) {
        return onlineLibrary.showBooks();
    }

    static public void orderBooksAlfa(OnlineLibrary onlineLibrary) {
        onlineLibrary.sort(onlineLibrary.getBooks());
    }

    static public String showAuthors(OnlineLibrary onlineLibrary)
    {
        Set<Author> authors;
        authors = onlineLibrary.getDistinctAuthors();
        return onlineLibrary.showAuthors(authors);
    }
}