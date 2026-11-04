package org.example;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnection {
    public Connection databaseConnection() throws SQLException {
        return DriverManager.getConnection(URL, "postgres", PASSWORD);
    }
}
