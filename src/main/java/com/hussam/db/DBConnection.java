package com.hussam.db;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/SQL_Course";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "0000";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
