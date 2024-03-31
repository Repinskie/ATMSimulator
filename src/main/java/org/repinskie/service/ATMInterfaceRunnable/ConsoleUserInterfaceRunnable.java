package org.repinskie.service.ATMInterfaceRunnable;

import org.repinskie.service.models.User;
import org.repinskie.view.ConsoleUserInterface;

public class ConsoleUserInterfaceRunnable implements Runnable {
    private final ConsoleUserInterface consoleUserInterface;
    private User user;
    private String userChoice;

    public ConsoleUserInterfaceRunnable(ConsoleUserInterface consoleUserInterface1, User user) {
        this.consoleUserInterface = consoleUserInterface1;
        this.user = user;
    }

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
