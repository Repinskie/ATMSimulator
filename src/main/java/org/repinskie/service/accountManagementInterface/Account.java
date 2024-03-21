package org.repinskie.service.accountManagementInterface;

public class Account{
    private String username;
    private int pinCode;
    private double balance;
    public Account(){}
     public Account(String username, int pinCode) {
        this.username = username;
        this.pinCode = pinCode;
        this.balance = 0.0;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }
}
