package org.repinskie.dao.dbConnections;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.Driver;
import org.postgresql.ds.PGSimpleDataSource;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/ATMSimulatorDB";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";
    public static Connection connection = null;

    public static Connection start() throws SQLException {
        PGSimpleDataSource simpleDataSource = new PGSimpleDataSource();
        simpleDataSource.setURL(URL);
        simpleDataSource.setUser(USERNAME);
        simpleDataSource.setPassword(PASSWORD);
        try {
            connection = simpleDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return connection;
    }
}
