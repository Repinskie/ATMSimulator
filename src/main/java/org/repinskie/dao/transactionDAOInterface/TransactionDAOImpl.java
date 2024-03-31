package org.repinskie.dao.transactionDAOInterface;


import org.repinskie.dao.dbConnections.DBConnection;
import org.repinskie.service.exception.DAOException;
import org.repinskie.service.models.Transaction;
import org.repinskie.dao.util.TransactionMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link TransactionDAO} interface, providing methods for managing transaction-related operations.
 * This implementation interacts directly with the database to perform CRUD operations on transaction data.
 * By encapsulating the database interactions within this class, we promote separation of concerns
 * and maintainability in the application.
 */
public class TransactionDAOImpl implements TransactionDAO {
    /**
     * Retrieves all transactions stored in the database.
     *
     * @return A list of Transaction objects representing all transactions.
     * @throws DAOException If an SQL exception occurs during database operations.
     */
    @Override
    public List<Transaction> getAllTransaction() {
        List<Transaction> transactions = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM transactions")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                transactions.add(TransactionMapper.mapResultSetToTransaction(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return transactions;
    }

    /**
     * Saves a new transaction into the database.
     *
     * @param transaction The Transaction object representing the transaction to be saved.
     * @throws DAOException If an SQL exception occurs during database operations.
     */
    @Override
    public void saveTransaction(Transaction transaction) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO transactions (sender_name, sender_surname, recipient_name, recipient_surname, amount,transaction_date) VALUES (?,?,?,?,?,?)")) {
            preparedStatement.setString(1, transaction.getSenderName());
            preparedStatement.setString(2, transaction.getSenderSurName());
            preparedStatement.setString(3, transaction.getRecipientName());
            preparedStatement.setString(4, transaction.getRecipientSurName());
            preparedStatement.setDouble(5, transaction.getAmount());
            preparedStatement.setTimestamp(6, new java.sql.Timestamp(transaction.getTransactionDate().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
