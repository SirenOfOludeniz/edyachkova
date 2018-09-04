package ru.job4j.sql;

import java.sql.*;

public class SQLStorageUpdateData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/test";
        String username = "postgres";
        String password = "root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            //   int foovalue = 500;
            PreparedStatement st = conn.prepareStatement("UPDATE product SET name=? where id=?");
            st.setString(1, "Розовые помидоры");
            st.setInt(2, 8);
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
