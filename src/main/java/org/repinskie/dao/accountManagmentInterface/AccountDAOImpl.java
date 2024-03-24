package org.repinskie.dao.accountManagmentInterface;

import org.repinskie.dao.dbConnections.DBConnection;
import org.repinskie.exception.DAOException;
import org.repinskie.models.User;
import org.repinskie.models.Account;

import java.sql.*;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    private static final AccountDAOImpl INSTANCE = new AccountDAOImpl();
    private static final String DELETE_SQL = "DELETE FROM accounts WHERE id = ?";
    private static final String SAVE_SQL = "INSERT INTO accounts (username, pinCode, balance) VALUES (?,?,?);";

    public AccountDAOImpl() {
    }

    public static AccountDAOImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<User> getAllAccounts() {
        return null;
    }

    @Override
    public Account getAccountById(Long id) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Long id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setInt(2, account.getPinCode());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    account.setId(resultSet.getInt("id"));
                }
            }
        } catch (SQLException exception) {
            throw new DAOException(exception);
        }
    }
}
