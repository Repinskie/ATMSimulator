package org.repinskie.service.readerInputInterface;


import java.util.Scanner;

/**
 * Class for reading user input from the console.
 */

public class ReaderInput {
    private static final Scanner console = new Scanner(System.in);

    /**
     * Reads the user's name from the console.
     *
     * @return The user's name
     */
    public static String readName() {
        do {
            String username = console.nextLine();
            if (username.trim().isEmpty()) {
                System.out.println("Field 'Name' must be filled in, enter name:");
            } else if (!username.matches("\\p{Alpha}+")) {
                System.out.println("Invalid name, please enter letters only, reenter name:");
            } else {
                return username;
            }
        } while (true);
    }

    /**
     * Reads the user's surname from the console.
     *
     * @return The user's surname
     */
    public static String readSurName() {
        do {
            String surName = console.nextLine();
            if (surName.trim().isEmpty()) {
                System.out.println("Field 'Surname' must be filled in, enter surname:");
            } else if (!surName.matches("\\p{Alpha}+")) {
                System.out.println("Invalid surname, please enter letters only, reenter surname:");
            } else {
                return surName;
            }
        } while (true);
    }

    /**
     * Reads the user's PIN code from the console.
     *
     * @return The user's PIN code
     */
    public static String readPINCode() {
        String pinCode = null;
        boolean isValid = false;
        do {
            try {
                pinCode = console.nextLine();
                if (pinCode.length() != 4) {
                    throw new NumberFormatException();
                }
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid PIN code format, please enter valid PIN code consisting of exactly 4 digits.");
            }
        } while (!isValid);
        return pinCode;
    }
}
