package ro.onlinelibrary.service;
import ro.onlinelibrary.library.Book;
import ro.onlinelibrary.library.Event;
import ro.onlinelibrary.others.Address;
import ro.onlinelibrary.people.Author;
import ro.onlinelibrary.people.BasicInfo;
import ro.onlinelibrary.people.Personnel;
import ro.onlinelibrary.people.readers.Adult;
import ro.onlinelibrary.people.readers.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ServiceReadCSV {
    public static ServiceReadCSV reader;

    public static ServiceReadCSV getInstance(){
        if (reader == null){
            reader = new ServiceReadCSV();
        }
        return reader;
    }

    private ServiceReadCSV() {}

    public List<Book> readBooksFromCSV(){
        List<Book> books = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/ro/onlinelibrary/csvFiles/Books.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String currentLine = bufferedReader.readLine();
            currentLine = bufferedReader.readLine();

            while (currentLine != null) {
                var splitLine = currentLine.split(",");
                String title = splitLine[0];
                String authorFirstName = splitLine[1];
                String authorLastName = splitLine[2];
                String authorCountry = splitLine[3];
                String authorLanguage = splitLine[4];
                int publishingYear = Integer.parseInt(splitLine[5]);
                String genre = splitLine[6];
                String description = splitLine[7];
                Author currentAuthor = new Author(authorFirstName, authorLastName, authorCountry, authorLanguage);
                Book currentBook = new Book(title, currentAuthor, publishingYear, genre, description);

                books.add(currentBook);
                currentLine = bufferedReader.readLine();
            }
        }
        catch (Exception exception)
        {
            System.out.println("Exception: " + exception.getMessage());
        }
        return books;
    }

    public List<Event> readEventsFromCSV(){
        List<Event> events = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/ro/onlinelibrary/csvFiles/Events.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String currentLine = bufferedReader.readLine();
            currentLine = bufferedReader.readLine();

            while (currentLine != null) {
                var splitLine = currentLine.split(",");
                String name = splitLine[0];
                String description = splitLine[1];
                String date = splitLine[2];
                var currentEvent = new Event(name, description, date);

                events.add(currentEvent);
                currentLine = bufferedReader.readLine();
            }
        }
        catch (Exception exception)
        {
            System.out.println("Exception: " + exception.getMessage());
        }
        return events;
    }

    public <T extends BasicInfo> List<T> readPeople(Class<T> itemClass){

        List<T> items = new ArrayList<>();

        if (itemClass.toString().equalsIgnoreCase("class ro.onlinelibrary.people.readers.Adult")) {
            try {
                FileReader fileReader = new FileReader("src/ro/onlinelibrary/csvFiles/Adults.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String currentLine = bufferedReader.readLine();
                currentLine = bufferedReader.readLine();

                while (currentLine != null) {
                    var splitLine = currentLine.split(",");

                    String firstName = splitLine[0];
                    String lastName = splitLine[1];
                    String employerCompany = splitLine[2];
                    String job = splitLine[3];
                    String city = splitLine[4];
                    String population = splitLine[5];
                    String street = splitLine[6];
                    int no = Integer.parseInt(splitLine[7]);
                    var address = new Address(city, population, street, no);
                    var currentAdult = new Adult(firstName, lastName, employerCompany, job, address);
                    items.add(itemClass.cast(currentAdult));

                    currentLine = bufferedReader.readLine();
                }
            } catch (Exception exception) {
                System.out.println("Exception: " + exception.getMessage());
            }
        } else if (itemClass.toString().equalsIgnoreCase("class ro.onlinelibrary.people.readers.Student")) {
            try {
                FileReader fileReader = new FileReader("src/ro/onlinelibrary/csvFiles/Students.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String currentLine = bufferedReader.readLine();
                currentLine = bufferedReader.readLine();

                while (currentLine != null) {
                    var splitLine = currentLine.split(",");

                    String firstName = splitLine[0];
                    String lastName = splitLine[1];
                    String school = splitLine[2];
                    int year = Integer.parseInt(splitLine[3]);
                    String city = splitLine[4];
                    String population = splitLine[5];
                    String street = splitLine[6];
                    int no = Integer.parseInt(splitLine[7]);
                    var address = new Address(city, population, street, no);

                    var currentStudent = new Student(firstName, lastName, school, year, address);
                    items.add(itemClass.cast(currentStudent));

                    currentLine = bufferedReader.readLine();
                }
            } catch (Exception exception) {
                System.out.println("Exception: " + exception.getMessage());
            }
        } else if (itemClass.toString().equalsIgnoreCase("class ro.onlinelibrary.people.Personnel")) {
            try {
                FileReader fileReader = new FileReader("src/ro/onlinelibrary/csvFiles/Personnel.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String currentLine = bufferedReader.readLine();
                currentLine = bufferedReader.readLine();

                while (currentLine != null) {
                    var splitLine = currentLine.split(",");

                    String firstName = splitLine[0];
                    String lastName = splitLine[1];
                    float salary = Float.parseFloat(splitLine[2]);
                    String city = splitLine[3];
                    String population = splitLine[4];
                    String street = splitLine[5];
                    int no = Integer.parseInt(splitLine[6]);
                    var address = new Address(city, population, street, no);

                    var currentPersonnel = new Personnel(firstName, lastName, salary, address);
                    items.add(itemClass.cast(currentPersonnel));

                    currentLine = bufferedReader.readLine();
                }
            } catch (Exception exception) {
                System.out.println("Exception: " + exception.getMessage());
            }
        }
        return items;
    }

}
