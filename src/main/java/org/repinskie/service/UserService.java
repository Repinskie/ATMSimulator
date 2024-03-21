package org.repinskie.service;

import org.repinskie.dao.UserDAO;

import java.sql.SQLException;

public class UserService {
    private UserDAO userDAO;
    public void createUser(User user) {
        try {
            userDAO.save(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
