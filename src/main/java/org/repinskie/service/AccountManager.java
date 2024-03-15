package org.repinskie.service;

public interface AccountManager {
        public double checkBalance(String username,int pinCode);
        public void deposit(String username,int pinCode,double amount);
        public void withdraw(String username,int pinCode,double amount);
        public void transferFunds(String senderUser,int senderPin,String receiverUserName,double amount);
}
