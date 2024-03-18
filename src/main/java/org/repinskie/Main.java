package org.repinskie;

import org.repinskie.view.ATMConsoleView;
import org.repinskie.view.userInteractionInterface.ConsoleUserInterface;
import org.repinskie.view.userInteractionInterface.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new ConsoleUserInterface();
        ATMConsoleView atmConsoleView = new ATMConsoleView(userInterface);
        atmConsoleView.startMenu();
    }
}
