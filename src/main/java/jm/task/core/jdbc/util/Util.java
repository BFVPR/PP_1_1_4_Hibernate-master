package jm.task.core.jdbc.util;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.*;

public class Util {
    private static volatile Util INSTANCE;

    //    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/newdatabase";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    public static Util getInstance() {
        Util localInstance = INSTANCE;
        if (localInstance == null) {
            synchronized (Util.class) {
                localInstance = INSTANCE;
                if (localInstance == null) {
                    INSTANCE = localInstance = new Util();
                }
            }
        }
        return localInstance;
    }

    public static Connection getConnection() {
        Class<Driver> driverClass = Driver.class;
        try {
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
