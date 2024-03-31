package org.repinskie.service.readerInputInterface;


import java.util.Scanner;

/**
 * Class for reading amount from console input.
 */
public class AmountReaderInput {
    private static final Scanner console = new Scanner(System.in);

    /**
     * Reads the amount of money from the console.
     *
     * @return The amount of money
     */
    public static double readAmount() {
        double amount = 0.0;
        boolean isValid = false;
        do {
            try {
                String input = console.nextLine();
                if (input.trim().isEmpty()) {
                    throw new NumberFormatException("Empty input.");
                }
                amount = Double.parseDouble(input);
                if (amount <= 0) {
                    System.out.println("The amount cannot be negative.");
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount format, please enter valid amount.");
            }
        } while (!isValid);
        return amount;
    }
}
