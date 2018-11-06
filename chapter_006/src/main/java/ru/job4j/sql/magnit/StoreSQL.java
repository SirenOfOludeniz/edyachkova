package ru.job4j.sql.magnit;

import java.sql.*;
import java.util.ArrayList;

public class StoreSQL {
    Config config;
    Connection connection;


    public StoreSQL(Config config) throws SQLException {
        this.config = config;
        connection = DriverManager.getConnection(Constant.URL_BASE_POSTGRES,
                Constant.NAME, Constant.PASSWORD);
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
            PreparedStatement statement = connection.prepareStatement("INSERT INTO entry (id, name) " +
                    "VALUES (?, ?)");
            for (int i = 0; i < n; i++) {
                statement.setInt(1, i);
                statement.setString(2,"someName " + i );
            }
            statement.addBatch();
            int[] count = statement.executeBatch();
            connection.commit();
        } catch (SQLException e) {

        }

    }

}
