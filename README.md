# Online Library - etapa I

## Descriere
 Online Library este o aplicație în Java creată cu scopul digitalizării bibliotecilor din România. 
 
### Clase:
 Aplicația este construită în jurul a 8 clase structurate pe domenii precum utilizatorilori, biblitecă și diverse :
 - pachetul People:
      - pachetul Readers: cele două tipuri de cititori
         - clasa Adult
         - clasa Student
      - clasa Authors
      - clasa Personnel
 - pachetul Library: detalii despre organizarea bibliotecii
      - clasa OnlineLibrary: prin ea se instanțiază bibliotecile cu toate cele necesare(users, cărți, personal etc.)
      - clasa Books
      - clasa Events
 - pachetul Others:
      - clasa Address
 Clasa OnlineLibrary reprezintă scheletul aplicației, fiind echivalentul unei biblioteci reale. În ea se vor regăsi detalii despre cititori (Adult & Student), cărțile disponibile (Books, prin care se include și clasa Author), personal (Personnel), evenimente viitoare (Events) și localizarea sediului fizic (Address), fiind totdoată și mediul de unde vor fi realizate interogările aplicației (prin serviciul său). 
 
### Interogări:
 Pentru început, aplicația are următoarele funționalități:
 - adăugarea unui cititor(addReader)
 - adaugarea unei cărți în colecția bibliotecii (addBook)
 - adăugarea unui angajat în cadrul bibliotecii (addEmployee)
 - adăugarea unui eveniment în bibliotecă (addEvent)
 - înființarea unei bibliteci (generateLibrary)
 - împrumutarea unei cărți (borrowsBook)
 - interogarea unui cititor despre cărțile împrumutate (borrowedBooks)
 - afișarea cititorilor unei biblioteci împărțiti în cele 2 grupuri principale: Aduly și Student (showReaders)
 - afișarea cărților dintr-o biblitoecă (showBooks)
 - ordonarea cărților alfabetic (orderBooksAlfa)
 - afișarea autorilor din colecția biblitecii (showAuthors)  
 
## Obiective:

Principalele obiective care se urmăresc prin implementarea acestui proiect sunt:
 - renunțarea la mediile de stocare învechite (registre, condici), prin trecerea către un mediu online de stocare, valabil la nivel național
 - reducerea procesului birocartic întâlnit la împrumuturi, gestionarea stocului de cărți, înscrierea unei persoane ca cititor într-o bibliotecă etc.
 - încurajarea persoanelor să descopere lectura prin facilitarea accesului acestora către biblioteci
