package org.repinskie.service.userServiceInterface;

import org.repinskie.service.models.User;

import java.util.List;

/**
 * interface for managing user accounts.
 */
public interface UserManager {
    /**
     * Registers a new user account.
     *
     * @param user User object containing account information
     */
    void registerAccount(User user);

    /**
     * Checks if an account with the specified name, surname, and hashed PIN code already exists.
     *
     * @param name    User's name
     * @param surName User's surname
     * @param hashPin Hashed PIN code
     * @return True if the account already exists, false otherwise
     */

    boolean isAccountAlreadySaved(String name, String surName, String hashPin);

    /**
     * Changes the PIN code of a user account.
     *
     * @param name    User's name
     * @param surName User's surname
     */

    void changePinCode(String name, String surName);

    /**
     * Saves user data including name, surname, and PIN code.
     *
     * @param name    User's name
     * @param surName User's surname
     * @param pinCode PIN code to save
     */

    void saveUserData(String name, String surName, String pinCode);

    /**
     * Authenticates a user account based on the provided name, surname, and PIN code.
     *
     * @param name    User's name
     * @param surName User's surname
     * @param pinCode PIN code to authenticate
     * @return True if authentication is successful, false otherwise
     */

    boolean authenticationAccount(String name, String surName, String pinCode);

    /**
     * Retrieves a list of all users.
     *
     * @return List of all users
     */
    List<User> getAllUsers();
}
