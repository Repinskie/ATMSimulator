package org.repinskie.dao;


import org.repinskie.service.UserService;
import org.repinskie.service.accountManagementInterface.Account;
import org.repinskie.service.accountManagementInterface.AccountService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
    private AccountService accountService;
    public AccountDAO(){}

    public AccountDAO(AccountService accountService) {
        this.accountService = accountService;
    }

    /*public static final String SQL_INSERT_NEW_ACCOUNT = "INSERT INTO account (username, pin, balance) VALUES (?, ?, ?);";
        public static final String SQL_DECREASE_SENDER_BALANCE = "UPDATE card SET balance = balance - ? WHERE number = ?";
        public static final String SQL_INCREASE_RECIPIENT_BALANCE = "UPDATE card SET balance = balance + ? WHERE number = ?";*/
    private Connection connection = null;

    public void save(Account account) throws SQLException {
        String query = "INSERT INTO accounts (user,pin,balance) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, account.getUsername());
            statement.setInt(2, account.getPinCode());
            statement.setDouble(3, account.getBalance());
            statement.executeUpdate();
        }
    }
}
