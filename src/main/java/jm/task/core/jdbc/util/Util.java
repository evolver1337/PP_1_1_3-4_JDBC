package jm.task.core.jdbc.util;

import java.net.URL;
import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection connection = null;
    private static Util instance = null;

    private Util(){
        try {
            if (null == connection || connection.isClosed() ) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }


    public static Connection getConnection() {
        return connection;
    }

}
