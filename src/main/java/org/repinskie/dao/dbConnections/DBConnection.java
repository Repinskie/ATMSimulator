package org.repinskie.dao.dbConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/ATMSimulatorDB";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    public static Connection connection = null;
    private DBConnection(){
    }
    public static Connection getConnection() throws SQLException{
        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            return connection;
    }
}
