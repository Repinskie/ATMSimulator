package org.repinskie.dao.userManagmentInterface;

import org.repinskie.models.User;

import java.sql.Connection;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Connection connection;
    public UserDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Long id) {

    }
}
