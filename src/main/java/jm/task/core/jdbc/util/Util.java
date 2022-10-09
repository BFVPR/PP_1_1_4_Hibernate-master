package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {

    //    private static final String DB_DRIVER = "org.mysql.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/newdatabase";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    public static Connection getConnection() {
        Class<Driver> driverClass = Driver.class;
        try {
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
