package com.example.bankingsystem.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/bankingsystem";
    private static final String USER = "postgres";  // Replace with your PostgreSQL username
    private static final String PASSWORD = "112233";  // Replace with your PostgreSQL password

    // Method to establish a connection to the PostgreSQL database
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL database successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the PostgreSQL database.");
            e.printStackTrace();
        }
        return conn;
    }
}
