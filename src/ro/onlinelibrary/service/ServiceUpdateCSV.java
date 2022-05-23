package ro.onlinelibrary.service;

import ro.onlinelibrary.library.Book;
import ro.onlinelibrary.library.Event;
import ro.onlinelibrary.people.Personnel;
import ro.onlinelibrary.people.readers.Adult;
import ro.onlinelibrary.people.readers.Student;

import java.io.FileWriter;

public class ServiceUpdateCSV {
    public static ServiceUpdateCSV writer;

    public static ServiceUpdateCSV getInstance(){
        if (writer == null){
            writer = new ServiceUpdateCSV();
        }
        return writer;
    }

    private ServiceUpdateCSV() {}

    public void writeToBooksCSV(Book currentBook){
        String fileName = "src/ro/onlinelibrary/csvFiles/Books.csv";
        try (FileWriter fileWriter = new FileWriter(fileName, true)){
            
            fileWriter.append("\n");
            fileWriter.append(currentBook.getTitle());
            fileWriter.append(",");
            fileWriter.append(currentBook.getAuthor().getFirstName());
            fileWriter.append(",");
            fileWriter.append(currentBook.getAuthor().getLastName());
            fileWriter.append(",");
            fileWriter.append(currentBook.getAuthor().getCountry());
            fileWriter.append(",");
            fileWriter.append(currentBook.getAuthor().getLanguage());
            fileWriter.append(",");
            fileWriter.append(String.valueOf(currentBook.getPublishingYear()));
            fileWriter.append(",");
            fileWriter.append(currentBook.getGenre());
            fileWriter.append(",");
            fileWriter.append(currentBook.getDescription());

            fileWriter.flush();
        }
        catch (Exception exception) {
            System.out.printf("\n\t\tException: " + exception.getMessage() + "\n");
        }
    }

    public void writeToEventsCSV(Event currentEvent){
        String fileName = "src/ro/onlinelibrary/csvFiles/Events.csv";
        try (FileWriter fileWriter = new FileWriter(fileName, true)){

            fileWriter.append("\n");
            fileWriter.append(currentEvent.getName());
            fileWriter.append(",");
            fileWriter.append(currentEvent.getDescription());
            fileWriter.append(",");
            fileWriter.append(currentEvent.getDate());

            fileWriter.flush();
        }
        catch (Exception exception) {
            System.out.printf("\n\t\tException: " + exception.getMessage() + "\n");
        }
    }

    public <T> void writePeopleToCSV(T item, Class<T> itemClass){
        if (itemClass.toString().equalsIgnoreCase("class ro.onlinelibrary.people.readers.Adult")){
            String fileName = "src/ro/onlinelibrary/csvFiles/Adults.csv";

            try (FileWriter fileWriter = new FileWriter(fileName, true)){
                Adult adult = (Adult) item;

                fileWriter.append("\n");
                fileWriter.append(adult.getFirstName());
                fileWriter.append(",");
                fileWriter.append(adult.getLastName());
                fileWriter.append(",");
                fileWriter.append(adult.getEmployerCompany());
                fileWriter.append(",");
                fileWriter.append(adult.getJob());
                fileWriter.append(",");
                fileWriter.append(adult.getAddress().getCity());
                fileWriter.append(",");
                fileWriter.append(adult.getAddress().getPopulation());
                fileWriter.append(",");
                fileWriter.append(adult.getAddress().getStreet());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(adult.getAddress().getNumber()));

                fileWriter.flush();
            }
            catch (Exception exception) {
                System.out.printf("\n\t\tException: " + exception.getMessage() + "\n");
            }

        } else if (itemClass.toString().equalsIgnoreCase("class ro.onlinelibrary.people.readers.Student")) {
            String fileName = "src/ro/onlinelibrary/csvFiles/Students.csv";

            try (FileWriter fileWriter = new FileWriter(fileName, true)){
                Student student = (Student) item;

                fileWriter.append("\n");
                fileWriter.append(student.getFirstName());
                fileWriter.append(",");
                fileWriter.append(student.getLastName());
                fileWriter.append(",");
                fileWriter.append(student.getSchool());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(student.getYear()));
                fileWriter.append(",");
                fileWriter.append(student.getAddress().getCity());
                fileWriter.append(",");
                fileWriter.append(student.getAddress().getPopulation());
                fileWriter.append(",");
                fileWriter.append(student.getAddress().getStreet());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(student.getAddress().getNumber()));

                fileWriter.flush();
            }
            catch (Exception exception) {
                System.out.printf("\n\t\tException: " + exception.getMessage() + "\n");
            }

        } else if (itemClass.toString().equalsIgnoreCase("class ro.onlinelibrary.people.Personnel")) {
            String fileName = "src/ro/onlinelibrary/csvFiles/Personnel.csv";

            try (FileWriter fileWriter = new FileWriter(fileName, true)){
                Personnel personnel = (Personnel) item;

                fileWriter.append("\n");
                fileWriter.append(personnel.getFirstName());
                fileWriter.append(",");
                fileWriter.append(personnel.getLastName());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(personnel.getSalary()));
                fileWriter.append(",");
                fileWriter.append(personnel.getAddress().getCity());
                fileWriter.append(",");
                fileWriter.append(personnel.getAddress().getPopulation());
                fileWriter.append(",");
                fileWriter.append(personnel.getAddress().getStreet());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(personnel.getAddress().getNumber()));

                fileWriter.flush();
            }
            catch (Exception exception) {
                System.out.printf("\n\t\tException: " + exception.getMessage() + "\n");
            }
        }
    }
}
