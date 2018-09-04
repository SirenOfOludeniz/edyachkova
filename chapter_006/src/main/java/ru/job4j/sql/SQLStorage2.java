package ru.job4j.sql;

import java.sql.*;

public class SQLStorage2 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/test";
        String username = "postgres";
        String password = "root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("SELECT * FROM product as p WHERE p.id in(?, ?, ?)");
            st.setInt(1, 3);
            st.setInt(2, 1);
            st.setInt(3, 5);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                System.out.println(String.format("%s", rs.getString("name")));
                // System.out.println(rs.getString(1));
            } rs.close();
            st.close();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                   e.printStackTrace();
                }
            }
        }


    }
}
