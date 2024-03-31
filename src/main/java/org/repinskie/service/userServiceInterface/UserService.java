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
     * Retrieves all users from the database.
     *
     * @return A list of User objects representing all users.
     */
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    /**
     * Saves user data into the database.
     *
     * @param name    Name of the user
     * @param surName Surname of the user
     * @param pinCode PIN code associated with the user's account
     */

    @Override
    public void saveUserData(String name, String surName, String pinCode) {
        String encryptedPinCode = PinCodeEncryptor.hashPinCode(pinCode);
        User user = new User(name, surName, encryptedPinCode);
        registerAccount(user);
    }

    /**
     * Checks if an account with given details is already saved in the database.
     *
     * @param name    Name of the user
     * @param surName Surname of the user
     * @param hashPin Hashed PIN code associated with the user's account
     * @return True if the account exists, otherwise false.
     */

    @Override
    public boolean isAccountAlreadySaved(String name, String surName, String hashPin) {
        UserDAO userDAO1 = new UserDAOImpl();
        return userDAO1.getUserInfo(name, surName, hashPin) != null;
    }

    /**
     * Authenticates user account based on provided credentials.
     *
     * @param name    Name of the user
     * @param surName Surname of the user
     * @param pinCode PIN code entered by the user
     * @return True if authentication is successful, otherwise false.
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
     * Registers a new user account.
     *
     * @param user The User object representing the user account to be registered.
     */
    @Override
    public void registerAccount(User user) {
        userDAO.saveUser(user);
    }

    /**
     * Changes the PIN code associated with a user's account.
     *
     * @param name    Name of the user
     * @param surName Surname of the user
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
