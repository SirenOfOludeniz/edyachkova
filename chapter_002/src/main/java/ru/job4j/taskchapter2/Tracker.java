package ru.job4j.taskchapter2;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
public class Tracker implements AutoCloseable{
   // private ArrayList<Item> items = new ArrayList<>();
    private Connection connection;


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
   /* public Item add(Item item) {
        this.items.add(item);
        return item;
    }*/

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


    /*public ArrayList<Item> getItems() {
        return items;
    }*/

    @Override
    public void close() throws Exception {
       try (Tracker tracker = new Tracker();) {
            tracker.connection.close();
       } catch (IOException e) {

       }
    }
}






















