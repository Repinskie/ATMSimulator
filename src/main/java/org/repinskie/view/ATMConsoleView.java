
package org.repinskie.view;

import org.repinskie.view.userInteractionInterface.ConsoleUserInterface;

import java.util.Scanner;

public class ATMConsoleView {
    private final ConsoleUserInterface consoleUserInterface;
    public ATMConsoleView(ConsoleUserInterface consoleUserInterface){
        this.consoleUserInterface = consoleUserInterface;
    }
    public void startMenu(Scanner console) {
        consoleUserInterface.displayStartMenu(console);

    }
}

