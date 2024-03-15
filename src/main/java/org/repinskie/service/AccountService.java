package org.repinskie.service;



import java.util.Map;

public class AccountService implements AccountManager {
    private Account account;
    public AccountService(Account account){
        this.account = account;
    }
    private Map<String,Account> accountMap;

    public AccountService() {

    }

    @Override
    public double checkBalance(String username, int pinCode) {
        return account.getBalance();
    }

    @Override
    public void deposit(String username, int pinCode, double amount) {
        account.setBalance(amount);
    }

    @Override
    public void withdraw(String username, int pinCode, double amount) {

    }

    @Override
    public void transferFunds(String senderUser, int senderPin, String receiverUserName, double amount) {

    }
    public void changePinCode(int pinCode){
        account.setPinCode(pinCode);
    }

}
