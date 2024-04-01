package org.repinskie.service.userServiceInterface;

import org.repinskie.dao.userDAOInterface.UserDAOInput;
import org.repinskie.dao.userDAOInterface.UserDAOInputImpl;
import org.repinskie.dao.userDAOInterface.UserDAOOutput;
import org.repinskie.dao.userDAOInterface.UserDAOOutputImpl;
import org.repinskie.service.models.User;
import org.repinskie.service.cryptorInterface.PinCodeEncryptor;
import org.repinskie.service.readerInputInterface.ReaderInput;

import java.util.List;

/**
 * Implementation of the {@link UserManager} interface, providing services for managing user accounts.
 */

public class UserService implements UserManager {
    /*private UserDAOInput userDAOInput;*/
    private UserDAOInput userDAOInput = new UserDAOInputImpl();
    private UserDAOOutput userDAOOutput = new UserDAOOutputImpl();
    /**
     * Retrieves all users from the database.
     *
     * @return A list of User objects representing all users.
     */
    @Override
    public List<User> getAllUsers() {
        return userDAOOutput.getAllUsers();
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
     * @return True if the account exists, otherwise false.
     */

    @Override
    public boolean isAccountAlreadySaved(String name, String surName) {
        return userDAOOutput.getFullName(name, surName) != null;
    }

    /**
     * Authenticates user account based on provided credentials.
     *
     * @param name        Name of the user
     * @param surName     Surname of the user
     * @param hashPinCode PIN code entered by the user
     * @return True if authentication is successful, otherwise false.
     */
    @Override
    public boolean authenticationAccount(String name, String surName, String hashPinCode) {
        User user = userDAOOutput.getUserInfo(name, surName, hashPinCode);
        if (user != null && user.checkAccountInfo(name, surName, hashPinCode)) {
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
        userDAOInput.saveUser(user);
    }

    /**
     * Changes the PIN code associated with a user's account.
     *
     * @param name    Name of the user
     * @param surName Surname of the user
     */
    @Override
    public void changePinCode(String name, String surName) {
        System.out.println("Enter current pin code:");
        String currentPin = ReaderInput.readPINCode();
        String hashCurrentPin = PinCodeEncryptor.hashPinCode(currentPin);
        String hashPinFromDB = userDAOOutput.getPinCode(name, surName);
        if (hashPinFromDB.equals(hashCurrentPin)) {
            System.out.println("Enter new pinCode (4 digits):");
            String newPin = ReaderInput.readPINCode();
            String hashPin = PinCodeEncryptor.hashPinCode(newPin);
            userDAOInput.saveNewPin(name, surName, hashPin);
        } else {
            System.out.println("Invalid current pin code.");
        }
    }
}
