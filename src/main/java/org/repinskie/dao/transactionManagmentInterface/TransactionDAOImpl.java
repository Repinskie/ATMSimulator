package org.repinskie.dao.transactionManagmentInterface;


import org.repinskie.dao.dbConnections.DBConnection;
import org.repinskie.exception.DAOException;
import org.repinskie.models.Transaction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDAOImpl {
    private Transaction transaction;
    public TransactionDAOImpl(Transaction transaction){
        this.transaction = transaction;
    }

    public void saveTransaction(String senderName, String recipientName, double amount, Date transactionDate){
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO transactions (sender_name,recipient_name,amount,transaction_date) VALUES (?,?,?,?)"))
       {
           preparedStatement.setString(1,senderName);
            preparedStatement.setString(2,recipientName);
            preparedStatement.setDouble(3,amount);
            preparedStatement.setDate(4,new java.sql.Date(transactionDate.getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new DAOException(e);
        }
    }
}
