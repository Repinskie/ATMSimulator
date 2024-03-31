package org.repinskie;


import org.repinskie.service.accountServiceInterface.AccountManager;
import org.repinskie.service.accountServiceInterface.AccountService;
import org.repinskie.service.transactionServiceInterface.TransactionManager;
import org.repinskie.service.transactionServiceInterface.TransactionService;
import org.repinskie.service.userServiceInterface.UserManager;
import org.repinskie.service.userServiceInterface.UserService;
import org.repinskie.view.ConsoleUserInterface;

/**
 * Main class for running the ATM application.
 */
public class ATMApplication {
    /**
     * Main method to start the ATM application.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        TransactionManager transactionManager = new TransactionService();
        AccountManager accountManager = new AccountService(transactionManager);
        UserManager userManager = new UserService();

        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface(accountManager, userManager);
        consoleUserInterface.displayStartMenu();


        /** Code for multi-threading implementation
         */
        /*ConsoleUserInterfaceRunnable consoleUserInterfaceRunnable = new ConsoleUserInterfaceRunnable(consoleUserInterface, user);
        AccountInterfaceRunnable accountInterfaceRunnable = new AccountInterfaceRunnable(accountManager);

        Thread consoleThread = new Thread(consoleUserInterfaceRunnable);
        Thread accountThread = new Thread(accountInterfaceRunnable);

        consoleThread.start();
        try {
            synchronized (consoleUserInterface){
                consoleUserInterface.wait();
            }
            synchronized (consoleUserInterface){
                consoleUserInterface.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountThread.start();
        try {
            synchronized (consoleUserInterface){
                consoleUserInterface.wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }*/
    }
}
