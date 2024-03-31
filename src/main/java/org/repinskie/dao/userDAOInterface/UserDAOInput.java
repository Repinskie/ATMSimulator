package org.repinskie.dao.userDAOInterface;

import org.repinskie.service.exception.DAOException;
import org.repinskie.service.models.User;

/**
 * Data Access Object interface for managing user-related operations.
 * This interface defines methods for saving, and updating user data in the database.
 * By abstracting these operations into an interface, we achieve modularity and flexibility in our codebase,
 * allowing different implementations to be used interchangeably without affecting the rest of the application.
 */
public interface UserDAOInput {
    /**
     * Saves a new user to the database.
     *
     * @param user The user to be saved
     * @throws DAOException If an error occurs during database access
     */
    void saveUser(User user);

    /**
     * Saves a new PIN code for a user in the database.
     *
     * @param name    The name of the user
     * @param surName The surname of the user
     * @param pinCode The new PIN code to be saved
     * @throws DAOException If an error occurs during database access
     */
    void saveNewPin(String name, String surName, String pinCode);
}
