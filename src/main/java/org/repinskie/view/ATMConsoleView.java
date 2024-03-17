
package org.repinskie.view;


import org.repinskie.view.userInteractionInterface.UserInterface;

import java.util.Scanner;

public class ATMConsoleView {
    private UserInterface userInterface;

    public ATMConsoleView(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void startMenu() {
        userInterface.displayStartMenu();

    }

}

