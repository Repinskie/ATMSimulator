package org.repinskie.service;

import org.repinskie.dao.userManagmentInterface.UserDAO;
import org.repinskie.models.User;

public class UserService {
    private UserDAO userDAO;
    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    public void registerUser(User user){

        userDAO.createUser(user);
    }

}
