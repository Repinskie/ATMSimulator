package org.repinskie.dao.accountDAOInterface;

import org.repinskie.dao.dbConnections.DBConnection;
import org.repinskie.dao.userDAOInterface.UserDAOInput;
import org.repinskie.dao.userDAOInterface.UserDAOInputImpl;
import org.repinskie.dao.userDAOInterface.UserDAOOutput;
import org.repinskie.dao.userDAOInterface.UserDAOOutputImpl;
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
    UserDAOOutput userDAOOutput= new UserDAOOutputImpl();

    /**
     * Retrieves the balance of a user based on their name and surname from the database.
     *
     * @param name    A string representing the user's first name.
     * @param surName A string representing the user's last name.
     * @param hashPinCode A string representing the user's hashPinCone.
     * @return The balance of the user.
     */

    @Override
    public double getBalance(String name, String surName, String hashPinCode) {
        double balance = 0.0;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT balance FROM users WHERE name = ? AND surname = ? AND pincode = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surName);
            preparedStatement.setString(3, hashPinCode);
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
     * Deposits a specified amount to the balance of a user.
     *
     * @param name    A string representing the user's first name.
     * @param surName A string representing the user's last name.
     * @param pinCode A string representing the user's pinCode.
     * @param amount  A double representing the amount to be deposited.
     */
    @Override
    public void depositBalance(String name, String surName, String pinCode, double amount) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET balance = balance + ? WHERE name = ? AND surname = ? AND pincode = ?")) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surName);
            preparedStatement.setString(4, pinCode);
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
     * Withdraws a specified amount from the balance of a user.
     *
     * @param name    A string representing the user's first name.
     * @param surName A string representing the user's last name.
     * @param hashPinCode A string representing the user's hashPinCode.
     * @param balance A double representing the amount to be withdrawn.
     */

    @Override
    public void withdrawBalance(String name, String surName, String hashPinCode, double balance) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET balance = balance - ? WHERE name = ? AND surname = ? AND pincode = ?")) {
            preparedStatement.setDouble(1, balance);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surName);
            preparedStatement.setString(4, hashPinCode);
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
     * Transfers a specified amount from one user's account to another user's account.
     *
     * @param senderName       A string representing the sender's first name.
     * @param senderSurName    A string representing the sender's last name.
     * @param recipientName    A string representing the recipient's first name.
     * @param recipientSurName A string representing the recipient's last name.
     * @param amount           A double representing the amount to be transferred.
     */
    @Override
    public void transfer(String senderName, String senderSurName, String hashPinCode, String recipientName, String recipientSurName, double amount) {
        String recipient = userDAOOutput.getName(recipientName, recipientSurName);
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
