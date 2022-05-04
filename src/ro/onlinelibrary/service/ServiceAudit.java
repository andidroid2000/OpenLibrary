package ro.onlinelibrary.service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ServiceAudit {
    FileWriter writeToFile;

    public ServiceAudit(){
        try {
            String fileName = "src/ro/onlinelibrary/csvFiles/Audit.csv";

            this.writeToFile = new FileWriter(fileName, true);


            writeToFile.append("Action");
            writeToFile.append(",");
            writeToFile.append("Time");
            writeToFile.append("\n");
        }
        catch (Exception exception){
            System.out.printf("\n\t\tException: " + exception.getMessage() + "\n");
        }
    }

    public void writeActionToFile(String actionName) throws IOException {
        if (writeToFile != null){
            writeToFile.append(actionName);
            writeToFile.append(",");

            LocalDateTime dateAndTime = LocalDateTime.now();
            writeToFile.append(dateAndTime.toString());

            writeToFile.append("\n");
            writeToFile.flush();
        }
    }
}
