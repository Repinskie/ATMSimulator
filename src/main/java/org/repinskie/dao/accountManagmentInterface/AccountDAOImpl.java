package org.repinskie.dao.accountManagmentInterface;

import org.repinskie.dao.dbConnections.DBConnection;
import org.repinskie.exception.DAOException;
import org.repinskie.models.Account;

import java.sql.*;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public double getBalance(String username) {
        double balance = 0.0;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT balance FROM users WHERE username = ?")) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    balance = resultSet.getDouble("balance");
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return  balance;
    }

    @Override
    public void depositBalance(String username, double amount) {
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET balance = balance + ? WHERE username = ?")){
            preparedStatement.setDouble(1,amount);
            preparedStatement.setString(2,username);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Deposit successful.");
            }else {
                System.out.println("Deposit failed, User not found.");
            }
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public void withdrawBalance(String username, double amount) {
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  users SET balance = balance - ? WHERE username = ?")){
            preparedStatement.setDouble(1,amount);
            preparedStatement.setString(2,username);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Withdraw successful.");
            }else {
                System.out.println("Deposit failed, User not found");
            }
        }catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public void updateUser(Account account) {

    }
}
