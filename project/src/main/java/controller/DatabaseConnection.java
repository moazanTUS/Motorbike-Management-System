package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection() throws Exception {
        Class.forName("org.hsqldb.jdbcDriver");

        Connection con = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost/oneDB", "sa", ""
        );

        return con;
    }
}
