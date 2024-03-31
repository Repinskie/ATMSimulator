package org.repinskie.service.models;

import org.repinskie.dao.userDAOInterface.UserDAO;

/**
 * Represents a user account in the system.
 * Each user has a unique identifier, a username, a surname, a PIN code, and a balance.
 */
public class User {
    private Long id;
    private String username;
    private String surname;
    private String pinCode;
    private double balance;

    public User() {
    }

    /**
     * Constructs a User object with the provided username, surname, and PIN code.
     *
     * @param username Username of the user
     * @param surname  Surname of the user
     * @param pinCode  PIN code associated with the user's account
     */
    public User(String username, String surname, String pinCode) {
        this.username = username;
        this.surname = surname;
        this.pinCode = pinCode;
    }

    /**
     * Constructs a User object with the provided details.
     *
     * @param id       Unique identifier for the user
     * @param username Username of the user
     * @param surname  Surname of the user
     * @param pinCode  PIN code associated with the user's account
     */
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
