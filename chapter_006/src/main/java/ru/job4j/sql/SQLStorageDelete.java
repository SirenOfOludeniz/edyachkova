package ru.job4j.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLStorageDelete {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/test";
        String username = "postgres";
        String password = "root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            //   int foovalue = 500;
            PreparedStatement st = conn.prepareStatement("DELETE FROM product where id=?");
            st.setInt(1, 8);
            int rowsDeleted = st.executeUpdate();
            System.out.println(rowsDeleted + " rows updated");
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
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
