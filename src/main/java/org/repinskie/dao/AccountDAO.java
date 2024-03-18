package org.repinskie.dao;
public class AccountDAO {
    public static final String SQL_INSERT_NEW_ACCOUNT = "INSERT INTO account (username, pin, balance) VALUES (?, ?, ?);";
    public static final String SQL_DECREASE_SENDER_BALANCE = "UPDATE card SET balance = balance - ? WHERE number = ?";
    public static final String SQL_INCREASE_RECIPIENT_BALANCE = "UPDATE card SET balance = balance + ? WHERE number = ?";

}
