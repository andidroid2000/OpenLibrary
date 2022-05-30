package ro.onlinelibrary.repository;

import ro.onlinelibrary.config.DatabaseConfig;

import java.sql.*;

public class AuthorsRepository {
    public void createTable()
    {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS authors" +
                "(id int PRIMARY KEY AUTO_INCREMENT, firstName varchar(30), lastName varchar(30), country varchar(30), language varchar(30))";
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
    public void insert(String firstName, String lastName, String country, String language) {
        String insertSql = "INSERT INTO authors(firstName, lastName, country, language) VALUES(?, ?, ?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, country);
            preparedStatement.setString(4, language);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ
    public void select() {
        String selectSql = "SELECT * FROM authors";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            System.out.println("Authors: ");
            while (resultSet.next()) {
                System.out.println("\tFirst name: " + resultSet.getString(2));
                System.out.println("\tLast name: " + resultSet.getString(3));
                System.out.println("\tCountry: " + resultSet.getString(4));
                System.out.println("\tLanguage: " + resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(int id, String country) {
        String updateSql = "UPDATE authors SET country=? WHERE id=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, country);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String deleteSql = "DELETE FROM authors WHERE id=?";

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
