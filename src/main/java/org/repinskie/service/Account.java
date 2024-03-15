package org.repinskie.service;


public class Account {
    private String username;
    private int pinCode;
    private double balance;
    private AccountService accountService;
    public Account(AccountService accountService){
        this.accountService = accountService;
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

}
