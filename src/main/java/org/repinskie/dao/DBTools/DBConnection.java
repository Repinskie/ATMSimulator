package org.repinskie.dao.DBTools;
import java.sql.Connection;
import java.sql.SQLException;
import  org.postgresql.ds.PGSimpleDataSource;
public class DBConnection {
    static Connection connection = null;

    public static Connection start() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        /*dataSource.setServerName("localhost");
        dataSource.setPortNumber(5432);
        dataSource.setDatabaseName("ATMSimulatorDB");
        dataSource.setUser("postgres");
        dataSource.setPassword("postgres");*/
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
