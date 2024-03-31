package org.repinskie.dao.transactionDAOInterface;

import org.repinskie.service.exception.DAOException;
import org.repinskie.service.models.Transaction;

import java.util.List;
/**
 * Data Access Object interface for managing transaction-related operations.
 * This interface defines methods for retrieving and saving transactions in the database.
 * By abstracting these operations into an interface, we achieve modularity and flexibility in our codebase,
 * allowing different implementations to be used interchangeably without affecting the rest of the application.
 */
public interface TransactionDAO {
    /**
     * Retrieves all transactions from the database.
     *
     * @return A list of transactions
     * @throws DAOException If an error occurs during database access
     */
    List<Transaction> getAllTransaction();
    /**
     * Saves a transaction to the database.
     *
     * @param transaction The transaction to be saved
     * @throws DAOException If an error occurs during database access
     */
    void saveTransaction(Transaction transaction);
}
