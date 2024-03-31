package org.repinskie.service.ATMInterfaceRunnable;

import org.repinskie.service.userServiceInterface.UserManager;

public class UserInterfaceRunnable implements Runnable {
    private UserManager userManager;

    public UserInterfaceRunnable(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void run() {
    }
}
