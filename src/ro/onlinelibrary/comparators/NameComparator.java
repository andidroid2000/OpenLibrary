package ro.onlinelibrary.comparators;
import ro.onlinelibrary.library.Book;

import java.util.Comparator;

public class NameComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2)
    {
        return b1.getTitle().compareTo(b2.getTitle());
    }
}
