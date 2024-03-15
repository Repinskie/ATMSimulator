package org.repinskie.view.userInteractionInterface;

import org.repinskie.view.UserInputHandler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface{
    private UserInputHandler userInputHandler;
    public ConsoleUserInterface(UserInputHandler userInputHandler){
        this.userInputHandler = userInputHandler;
    }
    @Override
    public void displayStartMenu(Scanner console) {
        System.out.println(
                        "1. Create an account\n" +
                        "2. Sign In");
        System.out.println("Enter command number:");
        int commandNum;
        try {
            commandNum = console.nextInt();
            console.nextLine();
        }catch (InputMismatchException e) {
            System.out.println("Invalid command format,please enter a valid number.");
            return;
        }
            if (commandNum == 1) {
                userInputHandler.createAccountFromInput(console);
                System.out.println("Account created.");
                displayMainMenu(console);
            } else if (commandNum == 2) {
                userInputHandler.handleSignInOption(console);
                System.out.println("Successful login to the account.");
                displayMainMenu(console);
            }else {
                System.out.println("Non-existent command");
            }

    }
    public void displayMainMenu(Scanner console){
        System.out.println("Select option:\n" +
                "1. Check Balance\n" +
                "2. Withdraw\n" +
                "3. Transfer\n" +
                "4. Deposit\n" +
                "5. Change PIN code");
        userInputHandler.handleUserInput(console);
    }
    public String readName(Scanner console) {
        System.out.println("Enter your name:");
        while (true) {
            String name = console.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Field 'Name' must be filled in, enter your name.");
            } else if (!name.matches("\\p{Alpha}+")) {
                System.out.println("Invalid name, please enter letters only, reenter your name.");
            } else {
                return name;
            }
        }
    }
    public Integer readAge(Scanner console) {
        System.out.println("Enter your age:");
        int age;
        while (true) {
            try {
                age = console.nextInt();
                console.nextLine();
                if (age <= 0) {
                    System.out.println("Invalid age, reenter your age:");
                } else if (age < 18) {
                    System.out.println("You're still young, wait 18 years.");
                } else if (age > 120) {
                    System.out.println("Over the limit age, reenter your age:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid age format,please enter a valid number:");
            }
        }
        return age;
    }
    public Integer readPINCode(Scanner console) {
        System.out.println("Create new PIN code(4 digits):");
        int pinCode;
        while (true) {
            try {
                pinCode = Integer.parseInt(console.nextLine());
                if (pinCode < 1000 || pinCode > 9999) {
                    System.out.println("Invalid PIN code,please enter a 4-digit number:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid PIN code format,please enter a valid number:");
            }
        }
        return pinCode;
    }
    public void handleSignInFromInput(Scanner console){
        String username = readUserNameForSignIn(console);
        int pinCode = readPinCodeForSignIn(console);
    }

    public String readUserNameForSignIn(Scanner console) {
        System.out.println("Enter your username:");
        while (true) {
            String username = console.nextLine();
            if (username.trim().isEmpty()) {
                System.out.println("Field 'Name' must be filled in, enter your name.");
            } else if (!username.matches("\\p{Alpha}+")) {
                System.out.println("Invalid name, please enter letters only, reenter your name.");
            } else {
                return username;
            }
        }
    }
    public int readPinCodeForSignIn(Scanner console) {
        System.out.println("Enter your PIN code:");
        int pinCode;
        while (true) {
            try {
                pinCode = console.nextInt();
                console.nextLine();
                if (pinCode < 1000 || pinCode > 9999) {
                    System.out.println("The PIN code must consist of at least 4 digits,please enter a valid number:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid PIN code format, please enter valid number:");
            }
        }
        return pinCode;
    }

}
