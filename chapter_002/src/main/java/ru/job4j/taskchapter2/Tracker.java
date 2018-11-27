package ru.job4j.taskchapter2;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
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
            Class.forName(config.getProperty("app.driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("app.urlBaseTracker"),
                    config.getProperty("app.username"),
                    config.getProperty("app.password")
            );
        } catch (Exception e) {
           // e.printStackTrace();
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }
    public Item add(Item item) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO item (id, name, created, description)" +
                        "VALUES (?, ?, now(), ?)")) {
            statement.setString(1, item.getId());
            statement.setString(2, item.getName());
            statement.setString(3, item.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create issue", e);
        }
        return item;
    }
   public void update(Item item) {
       try (PreparedStatement statement = this.connection.prepareStatement(
               "UPDATE item SET id = ?, name = ?, description = ?, created = now()" +
                       "WHERE id = ?")) {
           statement.setString(1, item.getId());
           statement.setString(2, item.getName());
           statement.setString(3, item.getDescription());
           statement.setString(4, item.getId());

           statement.executeUpdate();
       } catch (SQLException e) {
           throw new IllegalStateException("Failed to create issue", e);
       }
   }
   public void delete(Item item) {
       try(PreparedStatement statement = this.connection.prepareStatement(
               "DELETE FROM item WHERE id = ?")) {
           statement.setString(1, item.getId());
           statement.executeUpdate();
       } catch (SQLException e) {
           throw new IllegalStateException("Failed to create issue", e);
       }
   }
    public ArrayList<Item> findAll() {
        ArrayList<Item> list = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM item")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new Item(rs.getString("id"), rs.getString("name"),
                        rs.getString("description"), rs.getString("datecreation"),
                        rs.getString("komment")));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create issue", e);
        }
        return list;
    }
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> list = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM item WHERE name = ?")) {
           statement.setString(1, key);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                list.add(new Item(rs.getString("id"), rs.getString("name"),
                        rs.getString("description"), rs.getString("datecreation"),
                        rs.getString("komment")));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create issue", e);
        }
        return list;
    }
    public Item findById(String id) {
        Item returnedItem = null;
        try(PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM item WHERE id = ?")) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            returnedItem = new Item(rs.getString("id"), rs.getString("name"),
            rs.getString("description"), rs.getString("datecreation"),
                    rs.getString("komment"));
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create issue", e);
        }
        return returnedItem;
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






















