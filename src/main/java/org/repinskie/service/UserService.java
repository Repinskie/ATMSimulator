package org.repinskie.service;


import java.util.Map;

public class UserService {
    private Map<String ,Account> userMap;
    public UserService(Map<String,Account> userMap){
        this.userMap = userMap;
    }
    public boolean authenticationUser(String username,int pinCode){
        if (userMap.containsKey(username)){
            Account account = userMap.get(username);
            return account.getPinCode() == pinCode;
        }
        return false;
    }
    public boolean changePin(String username,int oldPin,int newPin){
        if (userMap.containsKey(username)){
            Account account = userMap.get(username);
            if (account.getPinCode() == oldPin){
                account.setPinCode(newPin);
                return true;
            }
        }
        return false;
    }

}
