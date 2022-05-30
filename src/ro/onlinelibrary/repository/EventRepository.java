package ro.onlinelibrary.repository;

import ro.onlinelibrary.config.DatabaseConfig;

import java.sql.*;

public class EventRepository {
    public void createTable()
    {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS event" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30), description varchar(150), date varchar(30))";
        Connection connection = DatabaseConfig.getDatabaseConnection();
        try{
            Statement statement = connection.createStatement();
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //CREATE - INSERT, READ - SELECT, UPDATE, DELETE

    //INSERT
    public void insert(String name, String description, String date) {
        String insertSql = "INSERT INTO event(name, description, date) VALUES(?, ?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, date);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ
    public void select() {
        String selectSql = "SELECT * FROM event";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            System.out.println("Events: ");
            while (resultSet.next()) {
                System.out.println("\tName: " + resultSet.getString(2));
                System.out.println("\tDescription: " + resultSet.getString(3));
                System.out.println("\tDate: " + resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(int id, String name) {
        String updateSql = "UPDATE event SET name=? WHERE id=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String deleteSql = "DELETE FROM event WHERE id=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
