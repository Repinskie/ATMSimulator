package org.repinskie.service.models;

import org.repinskie.dao.userDAOInterface.UserDAO;


public class User {
    private Long id;
    private String username;
    private String surname;
    private String pinCode;
    private double balance;

    private UserDAO userDAO;
    public User(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public User() {
    }

    public User(String username, String surname, String pinCode) {
        this.username = username;
        this.surname = surname;
        this.pinCode = pinCode;
    }

    public User(Long id, String username, String surname, String pinCode) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.pinCode = pinCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean checkAccountInfo(String enteredName, String enteredSurName, String enteredPinCode) {
        return username.equals(enteredName) && surname.equals(enteredSurName) && pinCode.equals(enteredPinCode);
    }
}
