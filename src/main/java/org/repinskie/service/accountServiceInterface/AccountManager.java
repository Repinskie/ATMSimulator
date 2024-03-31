package org.repinskie.service.accountServiceInterface;
/**
 * Interface for managing user accounts. This interface defines methods to interact with user accounts,
 * including checking balance, depositing money, withdrawing money, and transferring funds between accounts.
 */
public interface AccountManager {
     /**
     * Check the balance of a user.
     *
     * @param name User's name
     * @param surName User's surname
     * @ return user's balance
     */
     double checkBalance(String name, String surName);
     /**
      * Deposit money into a user's account.
      *
      * @param name User's name
      * @param surName User's name*/
     void doDeposit(String name, String surName);
     /**
      * Withdraw money from a user's account.
      *
      * @param name User's name
      * @param surName User's surname*/
     void doWithdraw(String name, String surName);
     /**
      * Transfers a certain amount from one user to another.
      *
      * @param senderName User's name
      * @param senderSurname User's surname*/
     void transferAmount(String senderName, String senderSurname);
}
