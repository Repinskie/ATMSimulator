package org.repinskie.service;


import org.repinskie.service.accountManagementInterface.AccountManager;
import org.repinskie.service.accountManagementInterface.AccountService;

public class Account {
    private String username;
    private int pinCode;
    private double balance;
    private AccountManager accountManager;
    public Account(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public Account(String username,int pinCode) {
        this.username = username;
        this.pinCode = pinCode;
        this.balance = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
    public static void isExit(boolean exited){
        if (exited){
            System.out.println("\nBye!");
        }
    }

}
