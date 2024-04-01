package org.repinskie.view;

import org.repinskie.service.accountServiceInterface.AccountManager;
import org.repinskie.service.cryptorInterface.PinCodeEncryptor;
import org.repinskie.service.userServiceInterface.UserManager;
import org.repinskie.service.readerInputInterface.ReaderInput;

import java.util.Scanner;
/**
 * Console user interface class for interacting with the application through the console.
 */
public class ConsoleUserInterface {
    private AccountManager accountManager;
    private UserManager userManager;

    /**
     * Constructor of the ConsoleUserInterface class.
     *
     * @param accountManager AccountManager object for managing user accounts
     * @param userManager    UserManager object for managing users
     */
    public ConsoleUserInterface(AccountManager accountManager, UserManager userManager) {
        this.accountManager = accountManager;
        this.userManager = userManager;
    }

    /**
     * Scanner object for reading user input from the console.
     */
    public static final Scanner menuScanner = new Scanner(System.in);

    /**
     * Displays the start menu options.
     */
    public void displayStartMenu() {
        System.out.println("\n1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
        String input = menuScanner.nextLine().trim();
        if (input.length() == 1) {
            char action = input.charAt(0);
            switch (action) {
                case '0':
                    System.out.println("See you later.");
                    System.exit(0);
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
        } else {
            System.out.println("Invalid input. Please enter only a single digit.");
            displayStartMenu();
        }
    }
    /**
     * Creates a new user account.
     */
    public void createNewAccount() {
        System.out.println("Enter your name:");
        String name = ReaderInput.readName();
        System.out.println("Enter your Surname:");
        String surName = ReaderInput.readSurName();
        System.out.println("Create new pinCode (4 digits):");
        String pinCode = ReaderInput.readPINCode();
        if (!userManager.isAccountAlreadySaved(name, surName)) {
            userManager.saveUserData(name, surName, pinCode);
            showAccountOptions(name, surName, pinCode);
        } else {
            System.out.println("Account already created.");
        }
    }
    /**
     * Displays the login interface for users to authenticate.
     */
    public void showLogIn() {
        System.out.println("Enter account name:");
        String name = ReaderInput.readName();
        System.out.println("Enter account Surname:");
        String surName = ReaderInput.readSurName();
        System.out.println("Enter account pinCode (4 digits):");
        String pinCode = ReaderInput.readPINCode();
        String hashPinCode = PinCodeEncryptor.hashPinCode(pinCode);
        if (userManager.authenticationAccount(name, surName, hashPinCode)) {
            System.out.println("Authentication successful.");
            showAccountOptions(name, surName, hashPinCode);
        } else {
            System.out.println("Authentication failed. Please check account name, surname or pinCode.");
        }
    }

    /**
     * Displays account options menu for the specified user.
     *
     * @param name    User's name
     * @param surName User's surname
     * @param hashPinCode User's hashPinCode
     */
    public void showAccountOptions(String name, String surName, String hashPinCode) {
        System.out.println("\n Select option:\n" +
                "1. Check Balance.\n" +
                "2. Withdraw.\n" +
                "3. Transfer.\n" +
                "4. Deposit.\n" +
                "5. Change PIN code.\n" +
                "0. Exit.");
        String input = menuScanner.nextLine().trim();
        if (input.length() == 1) {
            char action = input.charAt(0);
            switch (action) {
                case '0':
                    System.out.println("See you later.");
                    System.exit(0);
                    break;
                case '1':
                    double balance = accountManager.checkBalance(name, surName, hashPinCode);
                    System.out.println("\nYour balance:" +
                            "\n" + balance);
                    break;
                case '2':
                    accountManager.doWithdraw(name, surName, hashPinCode);
                    break;
                case '3':
                    accountManager.doTransfer(name, surName, hashPinCode);
                    break;
                case '4':
                    accountManager.doDeposit(name, surName, hashPinCode);
                    break;
                case '5':
                    userManager.changePinCode(name, surName);
                    break;
                default:
                    System.out.println("Unknown command,please enter a valid command.");
                    showAccountOptions(name, surName, hashPinCode);
            }
        } else {
            System.out.println("Invalid input. Please enter only a single digit.");
            showAccountOptions(name, surName, hashPinCode);
        }
    }
}