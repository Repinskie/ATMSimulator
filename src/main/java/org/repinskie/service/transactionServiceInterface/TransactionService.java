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
     * @inheritDoc
     */
    @Override
    public List<Transaction> getAllTransaction() {
        return transactionDAO.getAllTransaction();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void saveTransaction(Transaction transaction) {
        transactionDAO.saveTransaction(transaction);
    }

    /**
     * @inheritDoc
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
