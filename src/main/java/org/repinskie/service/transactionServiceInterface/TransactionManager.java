package org.repinskie.service.transactionServiceInterface;

import org.repinskie.service.models.Transaction;

import java.util.List;

/**
 * Interface for managing transactions
 */
public interface TransactionManager {
    /**
     * Retrieves all transactions.
     *
     * @return List of all transactions.
     */
    List<Transaction> getAllTransaction();

    /**
     * Saves a transaction.
     *
     * @param transaction Transaction to save
     */

    void saveTransaction(Transaction transaction);

    /**
     * Sets transaction data and saves it.
     *
     * @param senderName       Sender's name
     * @param senderSurName    Sender's surname
     * @param recipientName    Recipient's name
     * @param recipientSurName Recipient's surname
     * @param amount           Amount of the transaction
     */
    void setTransactionData(String senderName, String senderSurName, String recipientName, String recipientSurName, double amount);
}
