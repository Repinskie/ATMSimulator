package org.repinskie.view.readerInterface;

import java.util.Scanner;

public class ReaderForCreate implements ReaderInterface {
    private final Scanner console = new Scanner(System.in);

    @Override
    public String readName() {
        System.out.println("Enter your name:");
        while (true) {
            String name = console.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Field 'Name' must be filled in, enter your name:");
            } else if (!name.matches("\\p{Alpha}+")) {
                System.out.println("Invalid name, please enter letters only, reenter your name:");
            } else {
                return name;
            }
        }
    }

    @Override
    public int readPINCode() {
        System.out.println("Create new PIN code(4 digits):");
        int pinCode;
        while (true) {
            try {
                pinCode = Integer.parseInt(console.nextLine());
                if (pinCode < 1000 || pinCode > 9999) {
                    System.out.println("Invalid PIN code,please enter a 4-digit number:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid PIN code format,please enter a valid number:");
            }
        }
        return pinCode;
    }
}
