package org.repinskie.dao.util;

import org.repinskie.service.models.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Utility class responsible for mapping database result sets to {@link Transaction} objects.
 * This class provides a static method for mapping the fields of a result set to a transaction object.
 */
public class TransactionMapper {
    /**
     * Maps the fields of a result set to a {@link Transaction} object.
     *
     * @param resultSet The result set containing transaction data
     * @return The mapped transaction object
     * @throws SQLException If an error occurs while accessing the result set
     */
    public static Transaction mapResultSetToTransaction(ResultSet resultSet) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setId(resultSet.getLong("id"));
        transaction.setTransactionDate(resultSet.getDate("transaction_date"));
        transaction.setSenderName(resultSet.getString("sender_name"));
        transaction.setRecipientName(resultSet.getString("recipient_name"));
        transaction.setAmount(resultSet.getDouble("amount"));
        return transaction;
    }
}
