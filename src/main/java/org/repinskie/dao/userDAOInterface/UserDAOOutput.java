package org.repinskie.dao.userDAOInterface;

import org.repinskie.service.exception.DAOException;
import org.repinskie.service.models.User;

import java.util.List;

/**
 * Data Access Object interface for managing user-related operations.
 * This interface defines methods for retrieving user data in the database.
 * By abstracting these operations into an interface, we achieve modularity and flexibility in our codebase,
 * allowing different implementations to be used interchangeably without affecting the rest of the application.
 */
public interface UserDAOOutput {
    /**
     * Retrieves user information based on username, surname, and hashed PIN code.
     *
     * @param name    The username of the user
     * @param surName The surname of the user
     * @param pinCode The pinCode of the user
     * @return The user information if found, null otherwise
     * @throws DAOException If an error occurs during database access
     */
    User getUserInfo(String name, String surName, String pinCode);

    /**
     * Retrieves user information based on username and surname.
     *
     * @param name    The username of the user
     * @param surName The surname of the user
     * @return The user information if found, null otherwise
     * @throws DAOException If an error occurs during database access
     */
    User getFullName(String name, String surName);

    /**
     * Retrieves the name of a user based on their name and surname.
     *
     * @param name    The name of the user
     * @param surName The surname of the user
     * @return The name of the user if found, null otherwise
     * @throws DAOException If an error occurs during database access
     */
    String getName(String name, String surName);

    /**
     * Retrieves the PIN code of a user based on their name and surname.
     *
     * @param name    The name of the user
     * @param surName The surname of the user
     * @return The PIN code of the user if found, null otherwise
     * @throws DAOException If an error occurs during database access
     */

    String getPinCode(String name, String surName);


    /**
     * Retrieves a list of all users from the database.
     *
     * @return A list of users
     * @throws DAOException If an error occurs during database access
     */

    List<User> getAllUsers();
}
