package ro.onlinelibrary.comparators;
import ro.onlinelibrary.library.Books;

import java.util.Comparator;

public class NameComparator implements Comparator<Books> {
    @Override
    public int compare(Books b1, Books b2)
    {
        return b1.getTitle().compareTo(b2.getTitle());
    }
}
