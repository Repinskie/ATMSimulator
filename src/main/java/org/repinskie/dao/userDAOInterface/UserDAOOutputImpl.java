package org.repinskie.dao.userDAOInterface;

import org.repinskie.dao.dbConnections.DBConnection;
import org.repinskie.dao.util.UserMapper;
import org.repinskie.service.exception.DAOException;
import org.repinskie.service.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link UserDAOOutput} interface, providing methods for managing user-related operations.
 * By encapsulating the database interactions within this class, we promote separation of concerns
 * and maintainability in the application.
 */
public class UserDAOOutputImpl implements UserDAOOutput {
    /**
     * Retrieves user information based on the provided username, surname, and hashed PIN code.
     *
     * @param name    The name of the user.
     * @param surName The surname of the user.
     * @param pinCode The pinCode of the user.
     * @return The user object containing the information retrieved from the database, or null if no user matches the criteria.
     * @throws DAOException If an SQL exception occurs during database interaction.
     */
    @Override
    public User getUserInfo(String name, String surName, String pinCode) {
        User user = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE name = ? AND surname = ? AND pincode = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surName);
            preparedStatement.setString(3, pinCode);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setPinCode(resultSet.getString("pinCode"));
                    user.setBalance(resultSet.getDouble("balance"));
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return user;
    }

    /**
     * Retrieves user information based on the provided username, surname.
     *
     * @param name    The name of the user.
     * @param surName The surname of the user.
     * @return The user object containing the information retrieved from the database, or null if no user matches the criteria.
     * @throws DAOException If an SQL exception occurs during database interaction.
     */
    @Override
    public User getFullName(String name, String surName) {
        User user = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE name = ? AND surname = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setPinCode(resultSet.getString("pinCode"));
                    user.setBalance(resultSet.getDouble("balance"));
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return user;
    }

    /**
     * Retrieves the name of a user based on the provided username and surname.
     *
     * @param name    The name of the user.
     * @param surName The surname of the user.
     * @return The name of the user retrieved from the database, or null if no user matches the criteria.
     * @throws DAOException If an SQL exception occurs during database interaction.
     */
    @Override
    public String getName(String name, String surName) {
        String DBUserName = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM users WHERE name = ? AND surname = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    DBUserName = resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return DBUserName;
    }

    /**
     * Retrieves the hashed PIN code of a user based on the provided username and surname.
     *
     * @param name    The name of the user.
     * @param surName The surname of the user.
     * @throws DAOException If an SQL exception occurs during database interaction.
     */
    @Override
    public String getPinCode(String name, String surName) {
        String DBPinCode = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT pincode FROM users WHERE name = ? AND surname = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    DBPinCode = resultSet.getString("pincode");
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return DBPinCode;
    }

    /**
     * Retrieves a list of all users from the database.
     *
     * @return A list containing all user records stored in the database.
     * @throws DAOException If an SQL exception occurs during database interaction.
     */

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM transactions")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(UserMapper.mapResultSetToUser(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return users;
    }
}
