package org.repinskie.service.accountManagementInterface;

import org.repinskie.dao.AccountDAO;

public class Account{
    /*private String username;
    private int pinCode;
    private double balance;*/
    AccountDAO accountDAO = new AccountDAO();
    public Account(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }
    public Account(){}
     /*public Account(String username, int pinCode) {
        this.username = username;
        this.pinCode = pinCode;
        this.balance = 0.0;
    }*/

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public boolean authenticate(String queryUsername,int queryPinCode) {
        String query = "SELECT balance FROM accounts";
        return (accountDAO.checkAccount(query,queryUsername,queryPinCode));
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }
}
