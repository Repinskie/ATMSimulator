package org.repinskie.service;


import org.repinskie.dao.accountManagmentInterface.AccountDAO;
import org.repinskie.models.User;

import java.util.Scanner;


public class AccountService implements AccountManager {
    private static final Scanner console = new Scanner(System.in);
    private AccountDAO accountDAO;

    private User user;

    public AccountService(User user, AccountDAO accountDAO) {
        this.user = user;
        this.accountDAO = accountDAO;

    }

    @Override
    public double checkBalance(String username) {
        return accountDAO.getBalance(username);
    }

    @Override
    public void doDeposit(String username) {
        System.out.println("\nAmount of money to deposit:");
        double deposit = console.nextDouble();
        accountDAO.depositBalance(username, deposit);
    }

    @Override
    public void doWithdraw(String username) {
        System.out.println("\nAmount of money to withdraw:");
        double withdraw = console.nextDouble();
        if (withdraw <= 0) {
            System.out.println("Invalid amount.");
        }
        if (accountDAO.getBalance(username) >= withdraw) {
            double newBalance = accountDAO.getBalance(username) - withdraw;
            accountDAO.withdrawBalance(username, newBalance);
            System.out.println("New balance :" + "\n" + newBalance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void transferAmount(String senderName) {
        System.out.println("Enter an amount for transfer:");
        double amount = console.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        }
        if (accountDAO.getBalance(senderName) >= amount) {
            System.out.println("Enter account name for transfer: ");
            String recipient = console.nextLine();
            accountDAO.transfer(senderName, recipient, amount);
        }
    }

    public void changePinCode(int pinCode) {
        /*UserDAO userDAO = new UserDAOImpl();
        UserDAOImpl.getInstance();
        User user = userDAO.getPincode();
        if (pinCode != user.getPinCode()) {
            System.out.println("Operation declined, incorrect PIN code.");
        } else {
            user.setPinCode(pinCode);

        }*/
    }

    public static void isExit(boolean exited) {
        if (exited) {
            System.out.println("\nBye!");
        }
    }
}
