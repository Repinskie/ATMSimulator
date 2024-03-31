package org.repinskie.dao.dbConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Class for establishing a database connection.
 * This class encapsulates the logic for creating a connection to the database.
 * By centralizing the database connection logic within this class,
 * we promote reusability and maintainability by avoiding duplication of connection code.
 */
public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/ATMSimulatorDB";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    public static Connection connection = null;

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        return connection;
    }
}
