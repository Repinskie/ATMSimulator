package org.repinskie.dao.userManagmentInterface;


import org.repinskie.models.User;

import java.util.List;

public interface UserDAO  {
    List<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}
