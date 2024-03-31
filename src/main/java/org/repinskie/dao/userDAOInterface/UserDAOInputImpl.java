package org.repinskie.dao.userDAOInterface;

import org.repinskie.dao.dbConnections.DBConnection;
import org.repinskie.service.exception.DAOException;
import org.repinskie.service.models.User;

import java.sql.*;

/**
 * Implementation of the {@link UserDAOInput} interface, providing methods for managing user-related operations.
 * By encapsulating the database interactions within this class, we promote separation of concerns
 * and maintainability in the application.
 */
public class UserDAOInputImpl implements UserDAOInput {
    /**
     * Saves a new user record into the database.
     *
     * @param user The user object to be saved.
     * @throws DAOException If an SQL exception occurs during database interaction.
     */
    @Override
    public void saveUser(User user) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, surname, pinCode, balance) VALUES (?,?,?,?);", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPinCode());
            preparedStatement.setDouble(4, user.getBalance());
            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    user.setId(resultSet.getLong("id"));
                }
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        }
    }

    /**
     * Saves a new PIN code for a user in the database.
     *
     * @param name    The name of the user
     * @param surName The surname of the user
     * @param pinCode The new PIN code to be saved
     * @throws DAOException If an error occurs during database access
     */
    @Override
    public void saveNewPin(String name, String surName, String pinCode) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET pincode = ? WHERE name = ? AND surname = ?")) {
            preparedStatement.setString(1, pinCode);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surName);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("PIN changed successful.");
            } else {
                System.out.println("PIN change failed,invalid current PIN or User not found.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
