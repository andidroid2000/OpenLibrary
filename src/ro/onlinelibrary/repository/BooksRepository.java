package ro.onlinelibrary.repository;

import ro.onlinelibrary.config.DatabaseConfig;

import java.sql.*;

public class BooksRepository {
    public void createTable()
    {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS books" +
                "(id int PRIMARY KEY AUTO_INCREMENT, title varchar(30), publishingYear int, genre varchar(30), description varchar(150), idAuthor int)";
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
    public void insert(String title, int publishingYear, String genre, String description, int idAuthor) {
        String insertSql = "INSERT INTO books(title, publishingYear, genre, description, idAuthor) VALUES(?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, publishingYear);
            preparedStatement.setString(3, genre);
            preparedStatement.setString(4, description);
            preparedStatement.setInt(5, idAuthor);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ
    public void select() {
        String selectSql = "SELECT * FROM books";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            System.out.println("Books: ");
            while (resultSet.next()) {
                System.out.println("\tTitle: " + resultSet.getString(2));
                System.out.println("\tPublishing Year: " + resultSet.getString(3));
                System.out.println("\tGenre: " + resultSet.getString(4));
                System.out.println("\tDescription: " + resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(int id, String title) {
        String updateSql = "UPDATE books SET title=? WHERE id=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String deleteSql = "DELETE FROM books WHERE id=?";

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
