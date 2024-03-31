package org.repinskie.service.userServiceInterface;

import org.repinskie.dao.userDAOInterface.UserDAO;
import org.repinskie.dao.userDAOInterface.UserDAOImpl;
import org.repinskie.service.models.User;
import org.repinskie.service.cryptorInterface.PinCodeEncryptor;
import org.repinskie.service.readerInputInterface.ReaderInput;

import java.util.List;

/**
 * Implementation of the {@link UserManager} interface, providing services for managing user accounts.
 */

public class UserService implements UserManager {
    private UserDAO userDAO;

    /**
     * Constructor of the UserService class.
     *
     * @param userDAO UserDAO object for accessing user data
     */
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void saveUserData(String name, String surName, String pinCode) {
        String encryptedPinCode = PinCodeEncryptor.hashPinCode(pinCode);
        User user = new User(name, surName, encryptedPinCode);
        registerAccount(user);
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean isAccountAlreadySaved(String name, String surName, String hashPin) {
        UserDAO userDAO1 = new UserDAOImpl();
        return userDAO1.getUserInfo(name, surName, hashPin) != null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean authenticationAccount(String name, String surName, String pinCode) {
        UserDAO userDAO1 = new UserDAOImpl();
        String hashUserPinCode = PinCodeEncryptor.hashPinCode(pinCode);
        User user = userDAO1.getUserInfo(name, surName, hashUserPinCode);
        if (user != null && user.checkAccountInfo(name, surName, hashUserPinCode)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public void registerAccount(User user) {
        userDAO.saveUser(user);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void changePinCode(String name, String surName) {
        UserDAO userDAO1 = new UserDAOImpl();
        System.out.println("Enter current pin code:");
        String currentPin = ReaderInput.readPINCode();
        String hashCurrentPin = PinCodeEncryptor.hashPinCode(currentPin);
        String hashPinFromDB = userDAO1.getPinCode(name, surName);
        if (hashPinFromDB.equals(hashCurrentPin)) {
            System.out.println("Enter new pinCode (4 digits):");
            String newPin = ReaderInput.readPINCode();
            String hashPin = PinCodeEncryptor.hashPinCode(newPin);
            userDAO1.saveNewPin(name, surName, hashPin);
        } else {
            System.out.println("Invalid current pin code.");
        }
    }
}
