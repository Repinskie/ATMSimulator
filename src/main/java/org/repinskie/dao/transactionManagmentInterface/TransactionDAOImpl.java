package org.repinskie.dao.transactionManagmentInterface;


import org.repinskie.models.Transaction;

import java.sql.Connection;

public class TransactionDAOImpl {
    private Connection connection;

    public TransactionDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public void saveTransaction(Transaction transaction) {
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
