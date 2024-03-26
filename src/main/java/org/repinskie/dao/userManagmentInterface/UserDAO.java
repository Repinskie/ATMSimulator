package org.repinskie.dao.accountManagmentInterface;

import org.repinskie.models.User;
import org.repinskie.models.Account;

import java.util.List;

public interface AccountDAO {
    List<User> getAllAccounts();
    Account getAccountById(Long id);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Long id);
}
