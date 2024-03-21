package org.repinskie.dao;


import java.sql.Connection;

public class TransactionDAO {
    private Connection connection;

    public TransactionDAO(Connection connection) {
        this.connection = connection;
    }
    /*public void save(Transaction transaction) throws SQLException{
        String query = "INSERT INTO transactions (user_id,amount,type) VALUES (?,?,?)";
       try(PreparedStatement statement = connection.prepareStatement(query)){
           statement.setInt(1,transaction.getUserId());
            statement.setBigDecimal(2,transaction.getAmount());
            statement.setString(3,transaction.getType());
            statement.executeUpdate();
        }
    }*/
}
