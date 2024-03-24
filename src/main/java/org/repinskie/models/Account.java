package org.repinskie.models;

import java.math.BigDecimal;

public class Account {
    private int id;
    private String username;
    private int pinCode;
    private double balance;

    public Account() {
    }

    public Account(String username, int pinCode) {
        this.username = username;
        this.pinCode = pinCode;
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
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

    @Override
    public String toString() {
        return "Account{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", pinCode=" + pinCode +
               ", balance=" + balance +
               '}';
    }
}
