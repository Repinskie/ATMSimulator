package org.repinskie.service;


public class User {
    private String userName;
    private int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*public void addAccount(String userName,int userAge,int pinCode){
        authenticationManager.addAccount(userName,userAge,pinCode);
    }
    public void authentication(String userName, int pinCode){
        authenticationManager.authenticate(userName,pinCode);

    }
    public void PINCodeChanges(int PINCode){
        if(pinCode != PINCode){
            System.out.println("Operation declined, incorrect PIN code.");
        }
    }
    public void createAccount(String userName,int userAge,int pinCode){
        authenticationManager.addAccount(userName,userAge,pinCode);

    }
    public void signIN(String username, int pinCode){
        authenticationManager.authenticate(username,pinCode);
    }*/
}
