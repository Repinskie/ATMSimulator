package org.repinskie;


import org.repinskie.dao.accountManagmentInterface.AccountDAO;
import org.repinskie.dao.accountManagmentInterface.AccountDAOImpl;
import org.repinskie.service.AccountService;
import org.repinskie.view.ConsoleUserInterface;
import org.repinskie.view.UserInterface;

public class ATMApplication {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAOImpl();
        AccountService accountService = new AccountService(accountDAO);
        UserInterface userInterface = new ConsoleUserInterface(accountService);
        userInterface.displayStartMenu();
    }
}
