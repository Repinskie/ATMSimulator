package org.repinskie.service.ATMInterfaceRunnable;

import org.repinskie.service.accountServiceInterface.AccountManager;

/**
 * A Runnable implementation for account management operations.
 * This class is responsible for executing account operations in a separate thread.
 */
public class AccountInterfaceRunnable implements Runnable {
    private final AccountManager accountManager;

    /**
     * Constructs an AccountInterfaceRunnable with the specified AccountManager.
     *
     * @param accountManager The AccountManager to be used for account operations.
     */
    public AccountInterfaceRunnable(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    /**
     * Executes account management operations.
     * This method contains the logic to perform various account operations.
     */
    @Override
    public void run() {
       /* System.out.println("Enter your name:");
        String name = ReaderInput.readName();
        System.out.println("Enter your Surname:");
        String surName = ReaderInput.readSurName();
        synchronized (accountManager) {
            accountManager.checkBalance(name, surName);
            try {
                accountManager.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (accountManager) {
            accountManager.doWithdraw(name, surName);
            try {
                accountManager.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (accountManager) {
            accountManager.doDeposit(name, surName);
            try {
                accountManager.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (accountManager) {
            accountManager.transferAmount(name, surName);
            try {
                accountManager.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}

