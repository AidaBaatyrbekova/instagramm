package org.example.main.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: 27.06.2023
//  Если захочешь используй мою конфигурацию, либо напиши свой!!!
public class DataBaseConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConnection() {
        Connection connection;
        try {
            connection=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
