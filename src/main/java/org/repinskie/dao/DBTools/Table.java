package org.repinskie.dao.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Table {
    public static String activeAccountUsername;
    public static String getActiveAccountPIN;
    public static Scanner tableScanner = new Scanner(System.in);

    public static void create() {
        String sql = "CREATE TABLE IF NOT EXISTS account (" +
                "id SERIAL PRIMARY KEY NOT NULL," +
                "username VARCHAR(40)," +
                "pin VARCHAR(40)," +
                "balance INTEGER DEFAULT 0" +
                ");";
        try (Connection connection = DBConnection.start();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add(String sql, String name, String pin) {
        try (Connection connection = new DBConnection().start();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, pin);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        int income = tableScanner.nextInt();
        String sql = "UPDATE account " +
                "SET balance = balance + ? " +
                "WHERE name = ? AND pin = ?";
        try (Connection connection = DBConnection.start();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, income);
            preparedStatement.setString(2, activeAccountUsername);
            preparedStatement.setString(2, getActiveAccountPIN);

            preparedStatement.executeUpdate();

            System.out.println("\nDeposit was added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void transfer(){
        String transferAccount = tableScanner.next();

    }
}
