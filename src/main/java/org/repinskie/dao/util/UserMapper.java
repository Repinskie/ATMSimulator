package org.repinskie.dao.util;

import org.repinskie.service.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Utility class responsible for mapping database result sets to {@link User} objects.
 * This class provides a static method for mapping the fields of a result set to a user object.
 * By encapsulating this mapping logic within a dedicated class, we promote code organization and maintainability.
 */
public class UserMapper {
    /**
     * Maps the fields of a result set to a {@link User} object.
     *
     * @param resultSet The result set containing user data
     * @return The mapped user object
     * @throws SQLException If an error occurs while accessing the result set
     */
    public static User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setPinCode(resultSet.getString("pincode"));
        user.setBalance(resultSet.getDouble("balance"));
        return user;
    }
}
