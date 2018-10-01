package ru.job4j.sql.magnit;

import java.sql.*;
import java.util.ArrayList;

public class StoreSQL {
    Config config;
    Connection connection;


    public StoreSQL(Config config) throws SQLException {
        this.config = config;
    }



    public ArrayList<Entry> generate(int n) {
        ArrayList<Entry> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(Constant.URL_BASE_POSTGRES,
                    Constant.NAME, Constant.PASSWORD);
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
}
