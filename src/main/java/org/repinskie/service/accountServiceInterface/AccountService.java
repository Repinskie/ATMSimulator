package org.repinskie.service.accountServiceInterface;


import org.repinskie.dao.accountDAOInterface.AccountDAO;
import org.repinskie.dao.userDAOInterface.UserDAO;
import org.repinskie.service.transactionServiceInterface.TransactionManager;
import org.repinskie.service.readerInputInterface.AmountReaderInput;
import org.repinskie.service.readerInputInterface.ReaderInput;
/**
 * Implementation of the {@link AccountManager} interface, providing services for managing user accounts.
 */
public class AccountService implements AccountManager {
    private UserDAO userDAO;
    private AccountDAO accountDAO;
    private TransactionManager transactionManager;
    /**
     * Constructor of the AccountService class.
     *
     * @param userDAO UserDAO object for accessing user data
     * @param accountDAO AccountDAO object for accessing user data
     * @param transactionManager TransactionManager object for managing transaction.
     */
    public AccountService(UserDAO userDAO, AccountDAO accountDAO, TransactionManager transactionManager) {
        this.userDAO = userDAO;
        this.accountDAO = accountDAO;
        this.transactionManager = transactionManager;
    }
    /**
     * @inheritDoc
     */
    @Override
    public double checkBalance(String name, String surName) {
        return accountDAO.getBalance(name, surName);
    }
    /**
     * @inheritDoc
     */
    @Override
    public void doDeposit(String name, String surName) {
        System.out.println("\nAmount of money to deposit:");
        double amount = AmountReaderInput.readAmount();
        accountDAO.depositBalance(name, surName, amount);
    }
    /**
     * @inheritDoc
     */
    @Override
    public void doWithdraw(String name, String surName) {
        System.out.println("\nAmount of money to withdraw:");
        double withdrawAmount = AmountReaderInput.readAmount();
        double currentBalance = accountDAO.getBalance(name,surName);
        if (currentBalance >= withdrawAmount) {
            double newBalance = currentBalance - withdrawAmount;
            accountDAO.withdrawBalance(name, surName, withdrawAmount);
            System.out.println("\nOperation complete, your current balance:\n" + newBalance);
        } else {
            System.out.println("Insufficient funds in the account.");
        }
    }
    /**
     * @inheritDoc
     */
    @Override
    public void transferAmount(String senderName, String senderSurName) {
        System.out.println("Enter an amount for transfer:");
        double amount = AmountReaderInput.readAmount();
        if (amount <= 0) {
            System.out.println("Insufficient funds in the account.");
            return;
        }
        double senderBalance = accountDAO.getBalance(senderName, senderSurName);
        if (senderBalance < amount) {
            System.out.println("Insufficient funds in the account.");
            return;
        }
        System.out.println("Enter account name for transfer: ");
        String recipientName = ReaderInput.readName();
        System.out.println("Enter account surname for transfer:");
        String recipientSurName = ReaderInput.readSurName();
        String recipientNameFromDB = userDAO.getName(recipientName, recipientSurName);
        if (recipientNameFromDB == null) {
            System.out.println("Recipient not found.");
        } else if (!recipientName.equals(recipientNameFromDB)) {
            System.out.println("Recipient account not found.");
        } else {
            accountDAO.transfer(senderName, senderSurName, recipientName, recipientSurName, amount);
            transactionManager.setTransactionData(senderName, senderSurName, recipientName, recipientSurName, amount);
            System.out.println("Transfer successful.");
        }
    }
}
