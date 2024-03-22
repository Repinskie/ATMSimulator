package org.repinskie.dao;

import org.repinskie.service.User;
import org.repinskie.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    private UserService userService;
    Connection connection = null;
    public void saveUser(User user) throws SQLException {
        String query = "INSERT INTO users (user) VALUES (?)";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,user.getUsername());
            statement.executeUpdate();
        }
    }
}
