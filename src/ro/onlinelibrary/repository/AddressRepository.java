package ro.onlinelibrary.repository;

import ro.onlinelibrary.config.DatabaseConfig;

import java.sql.*;

public class AddressRepository {
    public void createTable()
    {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS addresses" +
                "(id int PRIMARY KEY AUTO_INCREMENT, city varchar(30), street varchar(150), number int)";
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
    public void insert(String city, String street, String number) {
        String insertSql = "INSERT INTO addresses(city, street, number) VALUES(?, ?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, city);
            preparedStatement.setString(2, street);
            preparedStatement.setString(3, number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ
    public void select() {
        String selectSql = "SELECT * FROM addresses";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            System.out.println("Addresses: ");
            while (resultSet.next()) {
                System.out.println("\tCity: " + resultSet.getString(2));
                System.out.println("\tStreet: " + resultSet.getString(3));
                System.out.println("\tNumber: " + resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(int id, String city) {
        String updateSql = "UPDATE addresses SET city=? WHERE id=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, city);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String deleteSql = "DELETE FROM addresses WHERE id=?";

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
