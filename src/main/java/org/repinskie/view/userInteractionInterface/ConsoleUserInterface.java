package org.repinskie.view.userInteractionInterface;

import org.repinskie.service.Account;
import org.repinskie.service.accountManagementInterface.AccountService;
import org.repinskie.view.readerInterface.ReaderForCreate;
import org.repinskie.view.readerInterface.ReaderNamePINCode;
import org.repinskie.view.readerInterface.ReaderInterface;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private AccountService accountService;
    private Account account;
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
                Account.isExit(true);
                break;
            case '1':
                showNewAccount();
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
    public void showNewAccount() {
        ReaderInterface readerInterface1 = new ReaderForCreate();
        readerInterface1.readName();
        readerInterface1.readPINCode();
    }
    @Override
    public void showLogIn(){
        ReaderInterface readerInterface2 = new ReaderNamePINCode();
        readerInterface2.readName();
        readerInterface2.readPINCode();
    }
    @Override
    public void showAccount(){
        System.out.println("Select option:\n" +
                "1. Check Balance.\n" +
                "2. Withdraw.\n" +
                "3. Transfer.\n" +
                "4. Deposit.\n" +
                "5. Change PIN code.");
        char action = menuScanner.nextLine()
                .trim()
                .charAt(0);
        switch (action){
            case '1':
                System.out.println("\nYour balance:");
                accountService.checkBalance();
                break;
            case '2':
                System.out.println("\nEnter deposit:");
                accountService.withdraw();
                break;
            case '3':
                System.out.println("\nTo do transfer:");
                accountService.transferFunds();
                break;
            case '4':
                System.out.println("\nEnter income:");
                double amount = menuScanner.nextDouble();
                accountService.deposit(amount);
                break;
            case '5':
                ReaderInterface readerInterface = new ReaderNamePINCode();
                int newPIN = readerInterface.readPINCode();
                accountService.changePinCode(newPIN);
                break;
            default:
                System.out.println("Unknown command,please enter a valid command.");
        }
    }
}

