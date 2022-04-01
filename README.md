# ProiectPAO

Online Library:
Online Library este o aplicație în Java creată cu scopul digitalizării bibliotecilor din România. 
Principalele obiective care se urmăresc prin implementarea acestui proiect sunt:
 - renunțarea la mediile de stocare învechite (registre, condici), prin trecerea către un mediu online de stocare, valabil la nivel național
 - reducerea procesului birocartic întâlnit la împrumuturi, gestionarea stocului de cărți, înscrierea unei persoane ca cititor într-o bibliotecă etc.
 - încurajarea persoanelor să descopere lectura prin facilitarea accesului acestora către biblioteci
 
Aplicația este construită în jurul a 8 clase structurate pe domenii precum utilizatorilori, biblitecă și diverse :
 - pachetul People:
      - pachetul Readers:
         - clasa Adult: utilizatori adulți (detalii despre job)
         - clasa Student: utilizatori elevi/studenți (detalii despre studiile urmate)
     
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
   
