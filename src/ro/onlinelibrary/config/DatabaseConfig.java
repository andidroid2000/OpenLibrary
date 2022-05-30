package ro.onlinelibrary.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_onlinelibrary";
    private static final String USER = "root";
    private static final String PASSWORD = "MSPa55UWE!";

    private static Connection databaseConnection;

    private DatabaseConfig(){

    }
    public static Connection getDatabaseConnection(){
        try {
            if (databaseConnection == null || databaseConnection.isClosed()) {
                databaseConnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
        } catch (SQLException e){
             e.printStackTrace();
        }
        return databaseConnection;
    }
    public static void closeDatabaseConfiguration(){
        try{
            if(databaseConnection != null && !databaseConnection.isClosed()){
                databaseConnection.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
