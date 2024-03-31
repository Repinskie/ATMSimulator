package org.repinskie.service.transactionServiceInterface;

import org.repinskie.dao.transactionDAOInterface.TransactionDAO;
import org.repinskie.service.models.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Implementation of the {@link TransactionManager} interface, providing services for managing transactions.
 */
public class TransactionService implements TransactionManager {
    private TransactionDAO transactionDAO;

    /**
     * Constructor of the TransactionService class.
     *
     * @param transactionDAO TransactionDAO object for accessing transaction data
     */

    public TransactionService(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    /**
     * Retrieves all transactions from the database.
     *
     * @return A list of Transaction objects representing all transactions.
     */
    @Override
    public List<Transaction> getAllTransaction() {
        return transactionDAO.getAllTransaction();
    }

    /**
     * Saves a transaction into the database.
     *
     * @param transaction The transaction to be saved.
     */
    @Override
    public void saveTransaction(Transaction transaction) {
        transactionDAO.saveTransaction(transaction);
    }

    /**
     * Sets transaction data and saves it into the database.
     *
     * @param senderName       Name of the sender
     * @param senderSurName    Surname of the sender
     * @param recipientName    Name of the recipient
     * @param recipientSurName Surname of the recipient
     * @param amount           Amount of the transaction
     */
    @Override
    public void setTransactionData(String senderName, String senderSurName, String recipientName, String recipientSurName, double amount) {
        Transaction transaction = new Transaction(senderName, senderSurName, recipientName, recipientSurName, amount, new Date());
        transaction.setSenderName(senderName);
        transaction.setSenderSurName(senderSurName);
        transaction.setRecipientName(recipientName);
        transaction.setRecipientSurName(recipientSurName);
        transaction.setAmount(amount);
        transaction.setTransactionDate(new Date());
        saveTransaction(transaction);
    }
}
