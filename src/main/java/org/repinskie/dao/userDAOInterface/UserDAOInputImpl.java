package org.repinskie.dao.userDAOInterface;

import org.repinskie.dao.dbConnections.DBConnection;
import org.repinskie.service.exception.DAOException;
import org.repinskie.service.models.User;
import org.repinskie.dao.util.UserMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link UserDAO} interface, providing methods for managing user-related operations.
 * This implementation interacts directly with the database to perform CRUD operations on user data.
 * By encapsulating the database interactions within this class, we promote separation of concerns
 * and maintainability in the application.
 */
public class UserDAOImpl implements UserDAO {
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
     * Retrieves user information based on the provided username, surname, and hashed PIN code.
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
     * Retrieves the hashed PIN code of a user based on the provided username and surname.
     *
     * @param name    The name of the user.
     * @param surName The surname of the user.
     * @throws DAOException If an SQL exception occurs during database interaction.
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
