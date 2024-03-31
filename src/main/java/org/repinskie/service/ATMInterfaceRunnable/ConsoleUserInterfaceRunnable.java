package org.repinskie.service.ATMInterfaceRunnable;

import org.repinskie.service.models.User;
import org.repinskie.view.ConsoleUserInterface;
/**
 * A Runnable implementation for managing console user interface operations.
 * This class is responsible for executing user interface operations in a separate thread.
 */
public class ConsoleUserInterfaceRunnable implements Runnable {
    private final ConsoleUserInterface consoleUserInterface1;
    private User user;
    private String userChoice;
    /**
     * Constructs a ConsoleUserInterfaceRunnable with the specified ConsoleUserInterface and User.
     *
     * @param consoleUserInterface1 The ConsoleUserInterface to be used for user interactions.
     * @param user                 The User associated with the console user interface.
     */
    public ConsoleUserInterfaceRunnable(ConsoleUserInterface consoleUserInterface1, User user) {
        this.consoleUserInterface1 = consoleUserInterface1;
        this.user = user;
    }
    /**
     * Executes console user interface operations.
     * This method contains the logic to perform various user interface operations.
     */
    @Override
    public void run() {
        /*synchronized (consoleUserInterface) {
            consoleUserInterface.displayStartMenu();
            try {
                consoleUserInterface.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (consoleUserInterface) {
                userChoice = consoleUserInterface.getUserChoice();
            }
            synchronized (consoleUserInterface) {
                consoleUserInterface.performUserOperation(userChoice);
            }

        }*/
    }
}
