package ru.job4j.sql;

import java.sql.*;

public class SQLStorageAddData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/test";
        String username = "postgres";
        String password = "root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
         //   int foovalue = 500;
            PreparedStatement st = conn.prepareStatement("INSERT INTO product (name, type_id, expired_date, prict, id) " +
                    "VALUES (?, ?, ?, ?, ?)");
            st.setInt(5, 8);
            st.setString(1, "Морковь");
            st.setInt(2, 4);
            st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            st.setInt(4, 40);

            int rowsDeleted = st.executeUpdate();
            System.out.println(rowsDeleted + " rows updated");
            st.close();
//            PreparedStatement st = conn.prepareStatement("SELECT * FROM product as p WHERE p.id in(?, ?, ?)");
//            st.setInt(1, 3);
//            st.setInt(2, 1);
//            st.setInt(3, 5);
//            ResultSet rs = st.executeQuery();
//            while (rs.next())
//            {
//                System.out.println(String.format("%s", rs.getString("name")));
                // System.out.println(rs.getString(1));
//            } rs.close();
//            st.close();



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
