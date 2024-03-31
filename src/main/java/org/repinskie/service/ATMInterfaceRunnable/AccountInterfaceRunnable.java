package org.repinskie.service.ATMInterfaceRunnable;

import org.repinskie.service.accountServiceInterface.AccountManager;
public class AccountInterfaceRunnable implements Runnable {
    private final AccountManager accountManager;

    public AccountInterfaceRunnable(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

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

