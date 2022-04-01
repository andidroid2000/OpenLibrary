# ProiectPAO

Online Library:
Online Library este o aplicație în Java creată cu scopul digitalizării bibliotecilor din România. 
Principalele obiective care se urmăresc prin implementarea acestui proiect sunt:
 - renunțarea la mediile de stocare învechite (registre, condici), prin trecerea către un mediu online de stocare, valabil la nivel național
 - reducerea procesului birocartic întâlnit la împrumuturi, gestionarea stocului de cărți, înscrierea unei persoane ca cititor într-o bibliotecă etc.
 - încurajarea persoanelor să descopere lectura prin facilitarea accesului acestora către biblioteci
Aplicația este structurată cu ajutorul a 8 clase structurate în jurul utilizatorilor și al bibliotecii cu toate dependințele ei necesare:
 - pachetul PEOPLE - contine date despre toate persoanele ce relaționează cu mediul bibliotecii
 - clasa BasicInfo - superclasa cu informații de bază despre persoane
   - subpachetul Readers - info privind utilizatori
      - clasa Adult - utilizatorii adulți
      - clasa Student - utilizatorii care sunt parte a unui ciclu de învățământ
   - clasa Author - detalii despre autorii cărților
   - to do: clasa Personal - detalii despre angajații bibliotecilor
 - clasa Book - definește cărțile
 - clasa Online Library - instanțiază bibliotecile online   
 - to do: clasa Adrres - instanțiază adresele
 - to do: clasa?
   
