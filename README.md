# OpenLibrary

### Description

---

OpenLibrary is a Java application created with the aim of digitizing libraries in Romania. 

### Reasoning behind the app 

---

The main objectives pursued through the implementation of this project are:
 - abandoning outdated storage media (registers, conditions), by switching to an online storage medium, valid at national level;
 - reducing the bureaucratic process (loans, book stock management, registering a person as a reader in a library etc.);
 - encouraging people to discover reading by facilitating their access to libraries.

### Structure

---

The application is built around 8 classes structured by domains such as users, library and various:
 - package People:
      - package Readers - 2 subtypes
         - class Adult
         - class Student
      - class Authors
      - class Personnel
 - package Library - details about the organization of the library
      - class OnlineLibrary: through it the libraries are instantiated with everything necessary (users, books, staff, etc.)
      - class Books
      - class Events
 - package Others:
      - class Address
 
The OnlineLibrary class represents the skeleton of the application, being the equivalent of a real library. In it you will find details about the readers (Adult & Student), the available books (Books, which also includes the Author class), personnel (Personnel), future events (Events) and the location of the physical headquarters (Address), being also the environment from where the application's queries will be made (via its service).
 
### Actions

---

 - `generateLibrary` -> creating a library 
 - `addReader` -> adds a reader 
 - `addBook` -> adds a book to the library collection 
 - `addEmployee` -> adds an employee to the library 
 - `addEvent` -> adds an event to the library 
 - `borrowsBook` -> user borrows a book 
 - `borrowedBooks` -> a reader's query about borrowed books 
 - `showReaders` -> displaying the readers of a library divided into the 2 main groups: Adults and Students 
 - `showBooks` -> displaying books from a library 
 - `orderBooksAlfa` -> order books alphabetically 
 - `showAuthors` -> displaying authors from the library collection 
