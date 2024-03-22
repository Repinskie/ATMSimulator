package org.repinskie.view.userInteractionInterface;

import org.repinskie.service.accountManagementInterface.Account;
import org.repinskie.service.accountManagementInterface.AccountService;
import org.repinskie.view.readerInterface.ReaderInput;
import org.repinskie.view.readerInterface.ReaderInterface;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private AccountService accountService;
    private Account account;

    public ConsoleUserInterface(AccountService accountService) {
        this.accountService = accountService;
    }

    public static Scanner menuScanner = new Scanner(System.in);

    @Override
    public void displayStartMenu() {
        System.out.println("\n1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
        char action = menuScanner.nextLine()
                .trim()
                .charAt(0);
        switch (action) {
            case '0':
                AccountService.isExit(true);
                break;
            case '1':
                createNewAccount();
                break;
            case '2':
                showLogIn();
                break;
            default:
                System.out.println("Unknown command,please enter a valid command:");
                displayStartMenu();
        }
    }

    @Override
    public void showAccountOptions(String username,int pinCode) {
        System.out.println("Select option:\n" +
                "1. Check Balance.\n" +
                "2. Withdraw.\n" +
                "3. Transfer.\n" +
                "4. Deposit.\n" +
                "5. Change PIN code.");
        char action = menuScanner.nextLine()
                .trim()
                .charAt(0);
        switch (action) {
            case '1':
                System.out.println("\nYour balance:");
                accountService.checkBalance();
                break;
            case '2':
                System.out.println("\nAmount of money to withdraw:");
                double withdraw = menuScanner.nextDouble();
                accountService.doWithdraw(withdraw);
                break;
            case '3':
                System.out.println("\nTo do a transfer:");
                accountService.transferFunds();
                break;
            case '4':
                System.out.println("\nAmount of money to deposit:");
                double deposit = menuScanner.nextDouble();
                accountService.doDeposit(deposit);
                break;
            case '5':
                ReaderInterface readerInterface = new ReaderInput();
                int newPIN = readerInterface.readPINCode();
                accountService.changePinCode(newPIN);
                break;
            default:
                System.out.println("Unknown command,please enter a valid command.");
        }
    }

    @Override
    public void createNewAccount() {
        ReaderInterface readerInterface1 = new ReaderInput();
        System.out.println("Enter your username:");
        String username = readerInterface1.readName();
        System.out.println("Create new pinCode (4 digits):");
        int pinCode = readerInterface1.readPINCode();
        Account account = new Account(username,pinCode);
        accountService.createAccount(account);
        showAccountOptions();
    }

    @Override
    public void showLogIn() {
        ReaderInterface readerInterface2 = new ReaderInput();
        System.out.println("Enter your username:");
        String username = readerInterface2.readName();
        System.out.println("Enter your pinCode(4 digits):");
        int pinCode = readerInterface2.readPINCode();
        accountService.authentication(username, pinCode);
        showAccountOptions();
    }
}