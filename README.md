# ProiectPAO

Online Library:
Online Library este o aplicație în Java creată cu scopul digitalizării bibliotecilor din România. 
Principalele obiective care se urmăresc prin implementarea acestui proiect sunt:
 - renunțarea la mediile de stocare învechite (registre, condici), prin trecerea către un mediu online de stocare, valabil la nivel național
 - reducerea procesului birocartic întâlnit la împrumuturi, gestionarea stocului de cărți, înscrierea unei persoane ca cititor într-o bibliotecă etc.
 - încurajarea persoanelor să descopere lectura prin facilitarea accesului acestora către biblioteci
 
Aplicația este construită în jurul a 8 clase structurate pe domenii precum utilizatorilori, biblitecă și diverse :
 - pachetul People:
      - pachetul Readers: info privind utilizatorii
         - clasa Adult: utilizatori adulți (detalii despre job)
         - clasa Student: utilizatori elevi/studenți (detalii despre studiile urmate)
      - clasa Authors: detalii autori
      - clasa Personnel: detalii angajați biblitoecă
 - pachetul Library: detalii despre organizarea bibliotecii
      - clasa OnlineLibrary: prin ea se instanțiază bibliotecile cu toate cele necesare(users, cărți, personal etc.)
      - clasa Books: detalii despre cărți
      - clasa Events: detalii despre evenimentele susținute de biblioteci
 - pachetul Others:
      - clasa Address 
Pentru început, aplicația are următoarele funționalități:
 - adăugarea unui cititor(addReader)
 - adaugarea unei cărți în colecția bibliotecii (addBook)
 - adăugarea unui angajat în cadrul bibliotecii (addEmployee)
   
