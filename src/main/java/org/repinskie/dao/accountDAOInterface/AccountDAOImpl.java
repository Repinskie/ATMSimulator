package org.repinskie.dao.accountDAOInterface;

import org.repinskie.dao.dbConnections.DBConnection;
import org.repinskie.dao.userDAOInterface.UserDAO;
import org.repinskie.dao.userDAOInterface.UserDAOImpl;
import org.repinskie.service.exception.DAOException;

import java.sql.*;

/**
 * Implementation of the {@link AccountDAO} interface, providing methods for managing account-related operations.
 * This implementation interacts directly with the database to perform CRUD operations on account data.
 * By encapsulating the database interactions within this class, we achieve separation of concerns,
 * allowing other parts of the application to remain unaware of the underlying database details.
 * This promotes maintainability and facilitates future changes to the database structure or technology.
 */
public class AccountDAOImpl implements AccountDAO {
    UserDAO userDAO = new UserDAOImpl();

    /**
     * @inheritDoc
     */
    @Override
    public double getBalance(String name, String surName) {
        double balance = 0.0;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT balance FROM users WHERE name = ? AND surname = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    balance = resultSet.getDouble("balance");
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return balance;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void depositBalance(String name, String surName, double amount) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET balance = balance + ? WHERE name = ? AND surname = ? ")) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surName);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Deposit failed, User not found.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public void withdrawBalance(String name, String surName, double balance) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET balance = balance - ? WHERE name = ? AND surname = ?")) {
            preparedStatement.setDouble(1, balance);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surName);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Withdraw successful.");
            } else {
                System.out.println("Withdraw failed, User not found");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public void transfer(String senderName, String senderSurName, String recipientName, String recipientSurName, double amount) {
        String recipient = userDAO.getName(recipientName, recipientSurName);
        if (recipient == null) {
            System.out.println("Transfer failed. Recipient not found.");
            return;
        }
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET balance = balance - ? WHERE name = ? AND surname = ?");
             PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE users SET balance = balance + ? WHERE  name = ? AND surname = ?")) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, senderName);
            preparedStatement.setString(3, senderSurName);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected <= 0) {
                System.out.println("Transfer failed. Sender not found or insufficient funds.");
                return;
            }
            preparedStatement1.setDouble(1, amount);
            preparedStatement1.setString(2, recipientName);
            preparedStatement1.setString(3, recipientSurName);
            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
