package com.main;

import java.sql.*;

public class Main {
    private final static String url = "jdbc:postgresql://localhost:5432/games";
    private final static String driverName = "org.postgresql.Driver";
    private final static String username = "postgres";
    private final static String password = "hamza";

    public static void main(String[] args) {
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM games");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " - " + rs.getString(2));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("==\nError : \n" + e.getMessage() + "\n===");
        }
    }
}
