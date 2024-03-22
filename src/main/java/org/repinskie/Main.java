package org.repinskie;

import org.repinskie.dao.AccountDAO;
import org.repinskie.service.accountManagementInterface.Account;
import org.repinskie.service.accountManagementInterface.AccountService;
import org.repinskie.view.ATMConsoleView;
import org.repinskie.view.userInteractionInterface.ConsoleUserInterface;
import org.repinskie.view.userInteractionInterface.UserInterface;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;


public class Main {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAO();
        AccountService accountService = new AccountService(accountDAO);
        UserInterface userInterface = new ConsoleUserInterface(accountService);
        ATMConsoleView atmConsoleView = new ATMConsoleView(userInterface);
        atmConsoleView.startMenu();
    }
}
