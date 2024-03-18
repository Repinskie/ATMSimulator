package org.repinskie.view;

import org.repinskie.view.userInteractionInterface.UserInterface;

public class ATMConsoleView {
    private UserInterface userInterface;

    public ATMConsoleView(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void startMenu() {
        userInterface.displayStartMenu();
    }
}

