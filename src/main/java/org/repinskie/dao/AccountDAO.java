package org.repinskie.dao;

import org.repinskie.dao.dbConnections.DBConnection;
import org.repinskie.service.accountManagementInterface.Account;

import java.sql.*;

public class AccountDAO {
    public static String activeUsername;
    public static int activePinCode;

    public void addNewAccount(Account account) {
        String query = "INSERT INTO accounts (\"username\",pincode,balance) VALUES (?,?,?)";
        try (Connection connection = DBConnection.start();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, account.getUsername());
            statement.setInt(2, account.getPinCode());
            statement.setDouble(3, account.getBalance());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBalance(Account account) {
       
    }

    public boolean checkAccount(String sql, String queryUsername, int queryPinCode) {
        try (Connection connection = DBConnection.start();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                int pinCode = resultSet.getInt("pinCode");
                if (queryUsername.equals(username) && (queryPinCode == pinCode)) {
                    activeUsername = queryUsername;
                    activePinCode = queryPinCode;
                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /*public static final String SQL_INSERT_NEW_ACCOUNT = "INSERT INTO account (username, pin, balance) VALUES (?, ?, ?);";
        public static final String SQL_DECREASE_SENDER_BALANCE = "UPDATE card SET balance = balance - ? WHERE number = ?";
        public static final String SQL_INCREASE_RECIPIENT_BALANCE = "UPDATE card SET balance = balance + ? WHERE number = ?";*/
}
