package org.repinskie.service.accountServiceInterface;


import org.repinskie.dao.accountDAOInterface.AccountDAO;
import org.repinskie.dao.accountDAOInterface.AccountDAOImpl;
import org.repinskie.dao.userDAOInterface.UserDAOOutput;
import org.repinskie.dao.userDAOInterface.UserDAOOutputImpl;
import org.repinskie.service.transactionServiceInterface.TransactionManager;
import org.repinskie.service.readerInputInterface.AmountReaderInput;
import org.repinskie.service.readerInputInterface.ReaderInput;

/**
 * Service class for managing user accounts. This class implements the {@link AccountManager} interface
 * and provides methods to interact with user accounts, including checking balance, depositing money,
 * withdrawing money, and transferring funds between accounts.
 */
public class AccountService implements AccountManager {
    private UserDAOOutput userDAOOutput = new UserDAOOutputImpl();
    private AccountDAO accountDAO = new AccountDAOImpl();
    private TransactionManager transactionManager;

    /**
     * Constructor of the AccountService class.
     *
     * @param transactionManager TransactionManager object for managing transaction.
     */
    public AccountService( TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * Retrieves the balance for a given account.
     *
     * @param name    The name associated with the account.
     * @param surName The surname associated with the account.
     * @param hashPinCode The hashPinCode associated with the account.
     * @return The current balance of the account.
     */

    @Override
    public double checkBalance(String name, String surName, String hashPinCode) {
        return accountDAO.getBalance(name, surName, hashPinCode);
    }

    /**
     * Deposits an amount of money into the specified account.
     *
     * @param name    The name associated with the account.
     * @param surName The surname associated with the account.
     * @param pinCode The pinCode associated with the account.
     */
    @Override
    public void doDeposit(String name, String surName, String pinCode) {
        System.out.println("\nAmount of money to deposit:");
        double amount = AmountReaderInput.readAmount();
        accountDAO.depositBalance(name, surName, pinCode, amount);
    }

    /**
     * Withdraws an amount of money from the specified account.
     *
     * @param name    The name associated with the account.
     * @param surName The surname associated with the account.
     * @param hashPinCode THe surname associated with the account.
     */
    @Override
    public void doWithdraw(String name, String surName, String hashPinCode) {
        System.out.println("\nAmount of money to withdraw:");
        double withdrawAmount = AmountReaderInput.readAmount();
        double currentBalance = accountDAO.getBalance(name, surName, hashPinCode);
        if (currentBalance >= withdrawAmount) {
            double newBalance = currentBalance - withdrawAmount;
            accountDAO.withdrawBalance(name, surName, hashPinCode, withdrawAmount);
            System.out.println("\nOperation complete, your current balance:\n" + newBalance);
        } else {
            System.out.println("Insufficient funds in the account.");
        }
    }

    /**
     * Transfers an amount of money from one account to another.
     *
     * @param senderName    The name associated with the sender's account.
     * @param senderSurName The surname associated with the sender's account.
     * @param hashPinCode The hashPinCode associated with the sender's account.
     */
    @Override
    public void doTransfer(String senderName, String senderSurName, String hashPinCode) {
        System.out.println("Enter an amount for transfer:");
        double amount = AmountReaderInput.readAmount();
        double senderBalance = accountDAO.getBalance(senderName, senderSurName, hashPinCode);
        if (amount <= 0 || senderBalance < amount) {
            System.out.println("Insufficient funds in the account.");
            return;
        }
        System.out.println("Enter account name for transfer: ");
        String recipientName = ReaderInput.readName();
        System.out.println("Enter account surname for transfer:");
        String recipientSurName = ReaderInput.readSurName();
        String recipientNameFromDB = userDAOOutput.getName(recipientName, recipientSurName);
        if (recipientNameFromDB == null) {
            System.out.println("Recipient not found.");
        } else if (!recipientName.equals(recipientNameFromDB)) {
            System.out.println("Recipient account not found.");
        } else {
            accountDAO.transfer(senderName, senderSurName, hashPinCode, recipientName, recipientSurName, amount);
            transactionManager.setTransactionData(senderName, senderSurName, recipientName, recipientSurName, amount);
            System.out.println("Transfer successful.");
        }
    }
}
