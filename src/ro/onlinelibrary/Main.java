package ro.onlinelibrary;

import ro.onlinelibrary.service.ServiceOnlineLibrary;
import ro.onlinelibrary.service.ServiceAudit;
import ro.onlinelibrary.service.ServiceReadCSV;
import ro.onlinelibrary.people.Personnel;
import ro.onlinelibrary.people.readers.Adult;
import ro.onlinelibrary.people.readers.Student;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        ServiceReadCSV CSVService = ServiceReadCSV.getInstance();
        var books = CSVService.readBooksFromCSV();
        var events = CSVService.readEventsFromCSV();
        var adults = CSVService.readPeople(Adult.class);
        var students = CSVService.readPeople(Student.class);
        var personnel = CSVService.readPeople(Personnel.class);

        ServiceOnlineLibrary generalAccess = new ServiceOnlineLibrary(books, events, personnel, adults, students);
        ServiceAudit audit = new ServiceAudit();
        generalAccess.menu(scanner, generalAccess, audit);
    }
}
