package org.repinskie.service;

public interface AccountManager {
    public double checkBalance();
    public void doDeposit(double deposit);
    public void doWithdraw(double withdraw);
    public void transferFunds();
    /*public double checkBalance(String username,int pinCode);
    public void deposit(String username,int pinCode,double amount);
    public void withdraw(String username,int pinCode,double amount);
    public void transferFunds(String receiverUserName,double amount);*/
}
