package ru.job4j.sql;

import java.sql.*;
import java.util.Properties;

public class SQLStorage {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/test";
        String username = "postgres";
        String password = "root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM product");
            while (rs.next())
            {
                System.out.println(String.format("%s %s", rs.getString("name")));
               // System.out.println(rs.getString(1));
            } rs.close();
            st.close();



        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("SQL Exception");
                }
            }
        }


    }
}
