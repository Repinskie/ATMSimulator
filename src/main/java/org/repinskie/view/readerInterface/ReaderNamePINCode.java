package org.repinskie.view.readerInterface;

import java.util.Scanner;

public class ReaderNamePINCode implements ReaderInterface{
    private final Scanner console = new Scanner(System.in);
    @Override
    public String readName() {
        System.out.println("Enter your username:");
        while (true) {
            String username = console.nextLine();
            if (username.trim().isEmpty()) {
                System.out.println("Field 'Name' must be filled in, enter your name.");
            } else if (!username.matches("\\p{Alpha}+")) {
                System.out.println("Invalid name, please enter letters only, reenter your name.");
            } else {
                return username;
            }
        }
    }

    @Override
    public int readPINCode() {
        System.out.println("Enter your PIN code:");
        int pinCode;
        while (true) {
            try {
                pinCode = console.nextInt();
                console.nextLine();
                if (pinCode < 1000 || pinCode > 9999) {
                    System.out.println("The PIN code must consist of at least 4 digits,please enter a valid number:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid PIN code format, please enter valid number:");
            }
        }
        return pinCode;
    }
}
