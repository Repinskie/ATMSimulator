package org.repinskie.service.accountManagementInterface;

import org.repinskie.dao.AccountDAO;
import org.repinskie.service.UserService;


public class AccountService implements AccountManager {
    private Account account;
    private UserService userService;
    private AccountDAO accountDAO;
    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public AccountService() {
    }

    @Override
    public double checkBalance(String queryUsername,int pinCode) {
        return account.getBalance();
    }

    @Override
    public void doDeposit(double amount) {
        account.setBalance(amount);
    }

    @Override
    public void doWithdraw(double withdraw) {
        if (withdraw <= 0) {
            System.out.println("Invalid amount.");
        }
        if (account.getBalance() >= withdraw) {
            double newBalance = account.getBalance() - withdraw;
            account.setBalance(newBalance);
            System.out.println("Withdraw successful. New balance :" + newBalance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void transferFunds() {
        /*if (amount <= 0) {
            System.out.println("Invalid amount.");
        }
        if (account.getBalance() >= amount) {
            double senderBalance = account.getBalance() - amount;
            double recipientBalance = recipientAccount.setBalance(senderBalance) + account;
        }*/
    }

    public void changePinCode(int pinCode) {
        if (pinCode != account.getPinCode()) {
            System.out.println("Operation declined, incorrect PIN code.");
        } else {
            account.setPinCode(pinCode);
        }
    }

    public void createAccount(Account account) {
            accountDAO.addNewAccount(account);
    }


    public void authentication(String username, int pinCode) {
        /*if (username.equals(account.getUsername()) && (account.getPinCode() == pinCode)) {
            System.out.println("Login was successful");
        } else {
            System.out.println("Incorrect username or pinCode!");
        }*/


    }

    public static void isExit(boolean exited) {
        if (exited) {
            System.out.println("\nBye!");
        }
    }
}
