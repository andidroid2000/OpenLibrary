package ro.onlinelibrary.library;

import ro.onlinelibrary.library.Books;
import ro.onlinelibrary.library.OnlineLibrary;
import ro.onlinelibrary.people.readers.Adult;
import ro.onlinelibrary.people.readers.Student;


public interface ServiceOnlineLibraryInterface {
    static public void borrowsBook(OnlineLibrary onlineLibrary, Student student, Books book){}

    static public void borrowsBook(OnlineLibrary onlineLibrary, Adult adult, Books book){}

    static public String showBorrowedBooks(OnlineLibrary onlineLibrary, Student student) {
        return null;
    }

    static public String showBorrowedBooks(OnlineLibrary onlineLibrary, Adult adult) {
        return null;
    }

    static public String showReaders(OnlineLibrary onlineLibrary) {
        return null;
    }

    static public String showBooks(OnlineLibrary onlineLibrary) {
        return null;
    }
}
