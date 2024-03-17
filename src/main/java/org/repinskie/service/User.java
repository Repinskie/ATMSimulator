package org.repinskie.service;


public class User {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /*public void addAccount(String userName,int pinCode){
        authenticationManager.addAccount(userName,pinCode);
    }
    public void authentication(String userName, int pinCode){
        authenticationManager.authenticate(userName,pinCode);

    }
    public void PINCodeChanges(int PINCode){
        if(pinCode != PINCode){
            System.out.println("Operation declined, incorrect PIN code.");
        }
    }
    public void createAccount(String userName,int pinCode){
        authenticationManager.addAccount(userName,pinCode);

    }
    public void signIN(String username, int pinCode){
        authenticationManager.authenticate(username,pinCode);
    }*/
}
