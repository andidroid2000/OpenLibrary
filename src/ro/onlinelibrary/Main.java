package ro.onlinelibrary;

import ro.onlinelibrary.library.Book;
import ro.onlinelibrary.library.Event;
import ro.onlinelibrary.library.OnlineLibrary;
import ro.onlinelibrary.service.ServiceOnlineLibrary;
import ro.onlinelibrary.others.Address;
import ro.onlinelibrary.people.Personnel;
import ro.onlinelibrary.people.readers.Adult;
import ro.onlinelibrary.people.Author;
import ro.onlinelibrary.people.readers.Student;


public class Main {

    public static void main(String[] args) {
	// generating some readers for the library
        Address adr = new Address("Bucuresti", "2000000", "Avram Iancu", 11);
        Student s1 = new Student("Diana","Tomescu", "School no. 104, Bucharest", 6, adr);
        Student s2 = new Student("Alex","Voiculescu", "Tudor Vianu National College, Bucharest", 11, adr);
        Student s3 = new Student("Paul","Mairescu", "School no. 14, Bucharest", 8, adr);
        Student s4 = new Student("Dana","Popescu", "University of Bucharest", 2, adr);
        Adult a1 = new Adult("Marcel", "Dinescu", "IBM", "accountant", adr);
        Adult a2 = new Adult("Maria-Ioana", "Banu", "BCR", "banker", adr);
        Adult a3 = new Adult("Mirel", "Radu", "KFC", "manager", adr);
        Adult a4 = new Adult("Madalin", "Olteanu", "Carturesti", "Shop assistant", adr);
    // generating some books to be read and some authors to write more books
        Author ath1 = new Author("Marcel","Proust", "Romania", "Romanian");
        Author ath2 = new Author("James","Joyce", "Romania", "Romanian");
        Author ath3 = new Author("Miguel","Cervantes", "Romania", "Romanian");
        Author ath4 = new Author( "Gabriel García","Márquez", "Romania", "Romanian");
        Author ath5 = new Author("Francis Scott","Fitzgerald", "Romania", "Romanian");
        Book b1 = new Book("In Search of Lost Time", ath1,1913, "modern literature",
                "Swann's Way, the first part of A la recherche de temps perdu, Marcel Proust's seven-part cycle, was published in 1913. In it, Proust introduces the themes that run through the entire work.");
        Book b2 = new Book("Ulysses", ath1, 1922, "fiction",
                "Ulysses chronicles the passage of Leopold Bloom through Dublin during an ordinary day, June 16, 1904. The title parallels and alludes to Odysseus (Latinised into Ulysses), the hero of Homer's Odyssey.");
        Book b3 = new Book("Don Quixote", ath3, 1605, "satire",
                "Alonso Quixano, a retired country gentleman in his fifties, lives in an unnamed section of La Mancha with his niece and a housekeeper. He has become obsessed with books of chivalry, and believes their every word to be true, despite the fact that many of the events in them are clearly impossible. ");
        Book b4 = new Book("One Hundred Years of Solitude", ath4, 1967, "fiction",
                "One of the 20th century's enduring works, One Hundred Years of Solitude is a widely beloved and acclaimed novel known throughout the world, and the ultimate achievement in a Nobel Prize–winning career. The novel tells the story of the rise and fall of the mythical town of Macondo through the history of the Buendía family.");
        Book b5 = new Book("The Great Gatsby", ath5, 1925, "historical fiction",
                "The novel chronicles an era that Fitzgerald himself dubbed the \"Jazz Age\". Following the shock and chaos of World War I, American society enjoyed unprecedented levels of prosperity during the \"roaring\" 1920s as the economy soared.");
    // generate the address for the new library
        Address adr1 = new Address("Bucharest", "2000000", "Iuliu Maniu", 15);
    // generating a library in a certain city
        Event event = new Event("Zilele portilor deschise", "O perpectiva unica si inovatoarea asupra bibliotecii moderne!", "22.04.2022");
        Personnel p1 = new Personnel("Ion", "Popescu", 2500, adr1);
        OnlineLibrary lib1 = new OnlineLibrary("Biblioteca Sector 6", adr1);
    // subscribing the readers to a library
        lib1.addReader(a1);
        lib1.addReader(a2);
        lib1.addReader(a3);
        lib1.addReader(a4);
        lib1.addReader(s2);
        lib1.addReader(s1);
        lib1.addReader(s4);
    // adding the books for the library
        lib1.addBook(b1);
        lib1.addBook(b2);
        lib1.addBook(b3);
        lib1.addBook(b4);
        lib1.addBook(b5);
    // add personnel
        lib1.addEmployee(p1);
        lib1.addEvent(event);
    // generating the knowledge for the library
        // generate the storing space
        ServiceOnlineLibrary.generateLibrary(lib1);
        // let certain readers borrow some books
        ServiceOnlineLibrary.borrowsBook(lib1, s1, b1);
        ServiceOnlineLibrary.borrowsBook(lib1, s1, b2);
        ServiceOnlineLibrary.borrowsBook(lib1, s1, b3);
        ServiceOnlineLibrary.borrowsBook(lib1, s4, b5);
        ServiceOnlineLibrary.borrowsBook(lib1, a4, b4);
        ServiceOnlineLibrary.borrowsBook(lib1, a2, b4);
        ServiceOnlineLibrary.borrowsBook(lib1, a1, b2);
    // print all the readers
        System.out.println(ServiceOnlineLibrary.showReaders(lib1));
    // print all the books
        System.out.println("Books in random order: ");
        System.out.println(ServiceOnlineLibrary.showBooks(lib1));
        ServiceOnlineLibrary.orderBooksAlfa(lib1);
        System.out.println("Books in alpha-numerical order by title: ");
        System.out.println(ServiceOnlineLibrary.showBooks(lib1));
    // print the borrowing status for certain users
        System.out.println("Books borrowed: ");
        System.out.println(ServiceOnlineLibrary.showBorrowedBooks(lib1, s1));
        System.out.println(ServiceOnlineLibrary.showBorrowedBooks(lib1, s2));
        System.out.println(ServiceOnlineLibrary.showBorrowedBooks(lib1, s4));
        System.out.println(ServiceOnlineLibrary.showBorrowedBooks(lib1, a1));
    // show authors in the Library
        System.out.println(lib1.getName() + " are urmatorii scriitori in colectia sa:\n ");
        System.out.println(ServiceOnlineLibrary.showAuthors(lib1));
    }
}
