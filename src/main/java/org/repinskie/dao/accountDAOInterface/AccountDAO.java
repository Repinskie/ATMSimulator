package org.repinskie.dao.accountDAOInterface;

import java.sql.SQLException;

/**
 * Data Access Object interface for managing account-related operations.
 * This interface provides a contract for accessing and manipulating account data in the database.
 * By defining these methods, we establish a consistent and standardized way to interact with the account data,
 * promoting modularity and maintainability in the application.
 */
public interface AccountDAO {
    /**
     * Retrieves the balance of the specified user.
     *
     * @param name    User's name
     * @param surName User's surname
     * @return Balance of the user
     */
    double getBalance(String name, String surName);

    /**
     * Deposits the specified amount to the user's account.
     *
     * @param name    User's name
     * @param surName User's surname
     * @param amount  Amount to deposit
     */

    void depositBalance(String name, String surName, double amount);

    /**
     * Withdraws the specified amount from the user's account.
     *
     * @param name    User's name
     * @param surName User's surname
     * @param balance Amount to withdraw
     */

    void withdrawBalance(String name, String surName, double balance);

    /**
     * Transfers the specified amount from the sender's account to the recipient's account.
     *
     * @param senderName       Sender's name
     * @param senderSurName    Sender's surname
     * @param recipientName    Recipient's name
     * @param recipientSurName Recipient's surname
     * @param amount           Amount to transfer
     */

    void transfer(String senderName, String senderSurName, String recipientName, String recipientSurName, double amount);
}
