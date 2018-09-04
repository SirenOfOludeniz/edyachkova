package ru.job4j.sql;

import java.sql.*;

public class SQLStorageGenerKeys {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/test";
        String username = "postgres";
        String password = "root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);

            PreparedStatement st = conn.prepareStatement("INSERT INTO product (name, type_id, expired_date, prict /*id*/) " +
                    "VALUES (?, ?, ?, ? /*?*/)", Statement.RETURN_GENERATED_KEYS);
            //st.setInt(5, 8);
            st.setString(1, "Помидоры");
            st.setInt(2, 4);
            st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            st.setInt(4, 50);

            int rowsDeleted = st.executeUpdate();
            System.out.println(rowsDeleted + " rows updated");
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                //получаем этот ключ, чтобы его потом можно было дальше передать (пользователю, например)
                System.out.println(generatedKeys.getInt(1));
            }
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
