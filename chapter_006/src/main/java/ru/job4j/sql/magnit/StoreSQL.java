package ru.job4j.sql.magnit;

import java.sql.*;
import java.util.ArrayList;

public class StoreSQL {
    Config config;
    Connection connection;


    public StoreSQL(Config config) throws SQLException {
        this.config = config;
        this.connection = config.getConnection();
    }

    public ArrayList<Entry> get(int n) {
        ArrayList<Entry> list = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM entry");
            while(rs.next()) {
                list.add(new Entry(rs.getString("columnName")));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public void generate(int n) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO entry (id) " +
                    "VALUES (?)");
            for (int i = 0; i < n; i++) {
                statement.setInt(1, i);
                statement.addBatch();
            }

            int[] count = statement.executeBatch();
            connection.commit();
        } catch (SQLException e) {

        }

    }

    /**
     * generate new table entry
     */
    public void generateTable() {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS entry (field integer)");
            statement.executeUpdate();
        } catch (SQLException e) {
           throw new IllegalStateException("Failed to create table");
        }
    }

    /**
     * delete old records in table entry, if it exist,
     * and insert new n records in table entry
     */
    public void insertRecords(int number) {
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM entry");
            //если есть записи, мы их удаляем перед вставкой
            if (rs.next()) {
               st.executeUpdate("DELETE FROM entry");
            }
            //вставляем в таблицу entry n записей
            generate(number);

        } catch (SQLException e) {
            throw new IllegalStateException("Failed to delete old records or insert new records");
        }

    }


}
