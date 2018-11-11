package ru.job4j.taskchapter2;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Tracker implements AutoCloseable{
    private Connection connection;

    public boolean init() {
        try(InputStream in = Tracker.class.getClassLoader()
        .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("username"),
                    config.getProperty("password"),
                    config.getProperty("app.urlBaseTracker")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }
    public void add(Item item) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO item (id, name, created, description)" +
                        "VALUES (?, ?, now(), ?)")) {
            statement.setInt(1, item.getId());
            statement.setString(2, item.getName());
            statement.setString(3, item.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create issue", e);
        }
    }
   public void update(Item item) {
       try (PreparedStatement statement = this.connection.prepareStatement(
               "UPDATE item SET id = ?, name = ?, description = ?, created = now()" +
                       "WHERE id = ?")) {
           statement.setInt(1, item.getId());
           statement.setString(2, item.getName());
           statement.setString(3, item.getDescription());
           statement.setInt(4, item.getId());

           statement.executeUpdate();
       } catch (SQLException e) {
           throw new IllegalStateException("Failed to create issue", e);
       }
   }
   public void delete(Item item) {
       try(PreparedStatement statement = this.connection.prepareStatement(
               "DELETE FROM item WHERE id = ?")) {
           statement.setInt(1, item.getId());
           statement.executeUpdate();
       } catch (SQLException e) {
           throw new IllegalStateException("Failed to create issue", e);
       }
   }
    public void findAll() {
        try(PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM item")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create issue", e);
        }
    }
    public void findByName(String key) {
        try(PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM item WHERE name = ?")) {
           statement.setString(1, key);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create issue", e);
        }
    }
    public void findById(int id) {
        try(PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM item WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create issue", e);
        }
    }
    @Override
    public void close() throws Exception {
        try{
            if(!this.connection.isClosed()) {
                this.connection.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }
}






















