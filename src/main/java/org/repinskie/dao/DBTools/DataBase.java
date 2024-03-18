package org.repinskie.dao.DBTools;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBase {
    public void connect(){
        try(Connection connection = DBConnection.start()){
            if (connection != null){
                Table.create();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
