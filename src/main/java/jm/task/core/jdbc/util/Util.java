package jm.task.core.jdbc.util;

import java.net.URL;
import java.sql.*;

public class Util {
    private final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private static Connection connection = null;


    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
