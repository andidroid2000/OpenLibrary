package ro.onlinelibrary.service;

import ro.onlinelibrary.comparators.NameComparator;
import ro.onlinelibrary.exception.SpecialExceptions;
import ro.onlinelibrary.library.Book;
import ro.onlinelibrary.library.Event;
import ro.onlinelibrary.others.Address;
import ro.onlinelibrary.people.Author;
import ro.onlinelibrary.people.Personnel;
import ro.onlinelibrary.people.readers.Adult;
import ro.onlinelibrary.people.readers.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ServiceOnlineLibrary implements InterfaceOnlineLibrary {
    private List<Book> books = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private List<Personnel> personnel = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Adult> adults = new ArrayList<>();

    private ServiceUpdateCSV csvFileWriter = ServiceUpdateCSV.getInstance();

    public ServiceOnlineLibrary(List<Book> books, List<Event> events, List<Personnel> personnel, List<Adult> adults, List<Student> students) {
        this.books = books;
        this.events = events;
        this.personnel = personnel;
        this.adults = adults;
        this.students = students;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Personnel> getPersonnel() {
        return personnel;
    }

    public void setPersonnel(List<Personnel> personnel) {
        this.personnel = personnel;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Adult> getAdults() {
        return adults;
    }

    public void setAdults(List<Adult> adults) {
        this.adults = adults;
    }

    private Address readPersonAddress(Scanner scanner) {
        System.out.println(" #Address:");
        System.out.println("\t*City:");
        String city = scanner.nextLine();
        System.out.println("\t*City's population:");
        String population = scanner.nextLine();
        System.out.println("\t*Street:");
        String street = scanner.nextLine();
        System.out.println("\t*Number:");
        int number = scanner.nextInt();
        scanner.nextLine();

        return new Address(city, population, street, number);
    }

    private void addBook(Scanner scanner, ServiceAudit audit) throws IOException {
        audit.writeActionToFile("AddedBook");

        System.out.println("\t<< Insert a new BOOK into Books.csv file >>\n");

        System.out.println(" #Book details:");
        System.out.println("\t*Title:");
        String title = scanner.nextLine();
        System.out.println("\t*Publishing year:");
        int publishingYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\t*Genre:");
        String genre = scanner.nextLine();
        System.out.println("\t*Description: ");
        String description = scanner.nextLine();

        System.out.println(" #Author's details:");
        System.out.println("\t*First name:");
        String authorFirstName = scanner.nextLine();
        System.out.println("\t*Last name:");
        String authorLastName = scanner.nextLine();
        System.out.println("\t*Birthplace (country):");
        String authorCountry = scanner.nextLine();
        System.out.println("\t*Language spoken:");
        String authorLanguage = scanner.nextLine();

        Author author = new Author(authorFirstName, authorLastName, authorCountry, authorLanguage);
        Book currentBook = new Book(title, author, publishingYear, genre, description);
        books.add(currentBook);
        csvFileWriter.writeToBooksCSV(currentBook);
    }

    private void addEvent(Scanner scanner, ServiceAudit audit) throws IOException {
        audit.writeActionToFile("AddedEvent");

        System.out.println("\t<< Insert a new EVENT into Events.csv file >>\n");

        System.out.println(" #Title:");
        String title = scanner.nextLine();
        System.out.println(" #Description:");
        String description = scanner.nextLine();
        System.out.println(" #Date (format - dd.mm.yyyy): ");
        String date = scanner.nextLine();

        Event currentEvent = new Event(title, description, date);
        events.add(currentEvent);
        csvFileWriter.writeToEventsCSV(currentEvent);
    }

    private void addAdult(Scanner scanner, ServiceAudit audit) throws IOException {
        audit.writeActionToFile("AddedAdultReader");

        System.out.println("\t<< Register a new ADULT READER >>\n");

        System.out.println(" #General details:");
        System.out.println("\t*First name:");
        String firstName = scanner.nextLine();
        System.out.println("\t*Last name:");
        String lastName = scanner.nextLine();

        System.out.println(" #Job details:");
        System.out.println("\t*Employer:");
        String employer = scanner.nextLine();
        System.out.println("\t*Job:");
        String job = scanner.nextLine();

        Adult adult = new Adult(firstName, lastName, employer, job, readPersonAddress(scanner));
        adults.add(adult);
        csvFileWriter.writePeopleToCSV(adult, Adult.class);
    }

    private void addStudent(Scanner scanner, ServiceAudit audit) throws IOException {
        audit.writeActionToFile("AddedStudentReader");

        System.out.println("\t<< Register a new STUDENT READER >>\n");

        System.out.println(" #General details:");
        System.out.println("\t*First name:");
        String firstName = scanner.nextLine();
        System.out.println("\t*Last name:");
        String lastName = scanner.nextLine();

        System.out.println(" #Education:");
        System.out.println("\t*School:");
        String school = scanner.nextLine();
        System.out.println("\t*Year:");
        int year = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(firstName, lastName, school, year, readPersonAddress(scanner));
        students.add(student);
        csvFileWriter.writePeopleToCSV(student, Student.class);
    }

    private void addPersonnel(Scanner scanner, ServiceAudit audit) throws IOException {
        audit.writeActionToFile("AddedPersonnel");

        System.out.println("\t<< Upload a new EMPLOYEE >>\n");

        System.out.println(" #General details:");
        System.out.println("\t*First name:");
        String firstName = scanner.nextLine();
        System.out.println("\t*Last name:");
        String lastName = scanner.nextLine();
        System.out.println("\t*Salary:");
        float salary = scanner.nextFloat();
        scanner.nextLine();

        Personnel p = new Personnel(firstName, lastName, salary, readPersonAddress(scanner));
        personnel.add(p);
        csvFileWriter.writePeopleToCSV(p, Personnel.class);
    }

    private static <T> Consumer<T> withCounter(BiConsumer<Integer, T> consumer) {
        AtomicInteger counter = new AtomicInteger(0);
        return item -> consumer.accept(counter.getAndIncrement(), item);
    }

    private void showBooks(ServiceAudit audit) throws IOException {
        audit.writeActionToFile("ShownBooks");

        NameComparator bookNameComparator = new NameComparator();
        books.sort(bookNameComparator);

        System.out.println(" << List of books (alphabetical order) >>");
        books.forEach(withCounter((i, book) -> {System.out.println("\n\t" + (i+1)+". " + book);}));;
    }

    private void showBooksPublishedTheSameYear(int publishingYear, ServiceAudit audit) throws IOException {
        audit.writeActionToFile("ShownBooksFromTheSameYear");

        System.out.println(" << List of book titles published in the year " + publishingYear + " >>");
        var booksStream = books;
        booksStream.stream()
                   .filter(x -> x.getPublishingYear() == publishingYear)
                   .map(Book::getTitle)
                   .forEach(withCounter((i, book) -> {System.out.println("\n\t" + (i+1)+". " + book);}));;
    }

    private void showEvents(ServiceAudit audit) throws IOException{
        audit.writeActionToFile("ShownEvents");
        System.out.println(" << List of upcoming events >>");
        LocalDate date = LocalDate.now();
        var day = date.getDayOfMonth();
        var month = date.getMonthValue();
        var year = date.getYear();
        var eventsStream = events;
        //eventsStream.removeIf(event -> event.getYear() <year || (event.getYear() == year && event.getMonth() <month) || event.getYear() == year && event.getMonth() == month && event.getDay() < day);
        eventsStream.stream()
                .filter(ev -> ev.getYear() > year ||
                              (ev.getYear() == year && ev.getMonth() > month)||
                              (ev.getYear() == year && ev.getMonth() == month && ev.getDay() == day))
                .forEach(System.out::println);
    }

    private void showAdultReaders(ServiceAudit audit) throws IOException{
        audit.writeActionToFile("ShownAdultReaders");
        System.out.println(" << List of adult readers >>");
        adults.sort((Adult a1, Adult a2) -> a1.getFirstName().compareTo(a2.getFirstName()));
        adults.forEach(withCounter((i, adult) -> {System.out.println("\n<" + (i+1)+"> " + adult);}));
    }

    private void showStudentReaders(ServiceAudit audit) throws IOException{
        audit.writeActionToFile("ShownStudentReaders");
        System.out.println(" << List of student readers >>");
        students.sort((Student s1, Student s2) -> s1.getFirstName().compareTo(s2.getFirstName()));
        students.forEach(withCounter((i, student) -> {System.out.println("\n<" + (i+1) + "> " + student);}));
    }

    private void showPersonnel(ServiceAudit audit) throws IOException{
        audit.writeActionToFile("ShownEmployees");
        System.out.println(" << List of employees >>");
        personnel.sort((Personnel p1, Personnel p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
        personnel.forEach(withCounter((i, person) -> {System.out.println("\n<" + (i+1) + "> " + person);}));
    }

    @Override
    public void menu(Scanner scanner, ServiceOnlineLibrary generalAccess, ServiceAudit audit) throws IOException {
        audit.writeActionToFile("Menu");

        System.out.println("\t << MENU >>");

        while (true) {

            int option1;

            while (true) {
                System.out.println("\n #OPTIONS:");
                System.out.println("\t*1* Show books");
                System.out.println("\t*2* Show upcoming events");
                System.out.println("\t*3* Show readers");
                System.out.println("\t*4* Show the employees");
                System.out.println("\t*5* Upload a book");
                System.out.println("\t*6* Plan an event");
                System.out.println("\t*7* Register a reader");
                System.out.println("\t*8* Upload an employee");
                System.out.println("\t*9* Exit the menu");

                try {
                    System.out.println(" #Insert the number of the option:");
                    option1 = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (Exception exception) {
                    scanner.nextLine();
                    System.out.println("\tOptions are between 1 and 9!");
                }
            }

            switch (option1) {
                case (1):
                    int option2;
                    while (true) {
                        System.out.println(" #Books register:");
                        System.out.println("\t*1* Show all the books");
                        System.out.println("\t*2* Show books from a certain year");
                        try {
                            System.out.println(" #Insert the number of the option:");
                            option2 = scanner.nextInt();
                            break;
                        } catch (Exception exception) {
                            scanner.nextLine();
                            System.out.println("\tOptions are between 1 and 2!");
                        }
                    }
                    switch (option2) {
                        case (1) :
                            showBooks(audit);
                            break;
                        case (2) :
                            System.out.println(" #Year:");
                            int publishingYear = scanner.nextInt();
                            scanner.nextLine();
                            try {
                                if (publishingYear <= 0){
                                    throw new SpecialExceptions("");
                                }
                                showBooksPublishedTheSameYear(publishingYear, audit);
                                break;
                            }
                            catch (SpecialExceptions exception){
                                System.out.println("Year must be positive!");
                            }
                            break;
                    }
                    break;
                case (2):
                    System.out.println(" #Upcoming events:");
                    showEvents(audit);
                    break;
                case (3):
                    int option3;
                    while (true) {
                        System.out.println(" #Readers:");
                        System.out.println("\t*1* Show all the readers");
                        System.out.println("\t*2* Show all the adult readers");
                        System.out.println("\t*3* Show all the student readers");
                        try {
                            System.out.println(" #Insert the number of the option:");
                            option3 = scanner.nextInt();
                            break;
                        } catch (Exception exception) {
                            scanner.nextLine();
                            System.out.println("\tOptions are between 1 and 3!");
                        }
                    }
                    switch (option3) {
                        case (1) :
                            showAdultReaders(audit);
                            showStudentReaders(audit);
                            break;
                        case (2) :
                            showAdultReaders(audit);
                            break;
                        case (3) :
                            showStudentReaders(audit);
                            break;
                    }
                    break;
                case (4):
                    System.out.println(" #Employees:");
                    showPersonnel(audit);
                    break;
                case (5):
                    addBook(scanner, audit);
                    break;
                case (6):
                    addEvent(scanner, audit);
                    break;
                case (7):
                    int option4;
                    while(true)
                    {
                        System.out.println(" #Add readers:");
                        System.out.println("\t*1* Adult reader");
                        System.out.println("\t*2* Student reader");
                        try {
                            System.out.println(" #Insert the number of the option:");
                            option4 = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (Exception exception) {
                            scanner.nextLine();
                            System.out.println("\tOptions are between 1 and 2!");
                        }
                    }
                    switch (option4) {
                        case (1):
                            addAdult(scanner, audit);
                            break;
                        case (2):
                            addStudent(scanner, audit);
                            break;
                    }
                    break;
                case (8):
                    addPersonnel(scanner, audit);
                    break;
                case (9):
                    System.out.println(" #MENU CLOSED");
                    return;
            }
        }
    }
}