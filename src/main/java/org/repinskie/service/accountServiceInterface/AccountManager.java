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
     * @param hashPinCode User's hashPinCode
     * @return user's balance
     */
     double checkBalance(String name, String surName, String hashPinCode);
     /**
      * Deposit money into a user's account.
      *
      * @param name User's name
      * @param surName User's name
      * @param pinCode User's pinCode
      */
     void doDeposit(String name, String surName, String pinCode);
     /**
      * Withdraw money from a user's account.
      *
      * @param name User's name
      * @param surName User's surname
      * @param hashPinCode User's hashPinCode
      */
     void doWithdraw(String name, String surName, String hashPinCode);
     /**
      * Transfers a certain amount from one user to another.
      *
      * @param senderName User's name
      * @param senderSurname User's surname
      * @param hashPinCode User's surname;
      */
     void doTransfer(String senderName, String senderSurname, String hashPinCode);
}
