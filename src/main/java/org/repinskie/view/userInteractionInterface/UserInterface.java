package org.repinskie.view.userInteractionInterface;

import org.repinskie.service.accountManagementInterface.Account;

public interface UserInterface {
    void displayStartMenu();

    void createNewAccount();

    void showLogIn();

    void showAccountOptions(String username,int pinCode);
}
