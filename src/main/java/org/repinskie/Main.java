package org.repinskie;

import org.repinskie.service.Account;
import org.repinskie.service.AccountService;
import org.repinskie.view.ATMConsoleView;
import org.repinskie.view.UserInputHandler;
import org.repinskie.view.userInteractionInterface.ConsoleUserInterface;

import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        Account account = new Account(new AccountService());
        AccountService accountService = new AccountService(account);
        UserInputHandler userInputHandler = new UserInputHandler(account);
        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface(userInputHandler);
        userInputHandler.setConsoleUserInterface(consoleUserInterface);
        ATMConsoleView atmConsoleView = new ATMConsoleView(consoleUserInterface);
        atmConsoleView.startMenu(new Scanner(System.in));
    }
}
