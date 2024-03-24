package org.repinskie.dao.transactionManagmentInterface;

import org.repinskie.models.Account;
import org.repinskie.models.Transaction;
import org.repinskie.models.User;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getAllTransaction();
    Transaction getTransactionById(Long id);
    void saveTransaction(Transaction transaction);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(Long id);
}
