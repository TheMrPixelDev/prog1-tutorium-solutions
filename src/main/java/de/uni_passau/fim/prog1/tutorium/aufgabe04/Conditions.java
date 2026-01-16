package de.uni_passau.fim.prog1.tutorium.aufgabe04;

import java.util.Random;

/**
 * Create a program that outputs for an int variable <code>number</code> whether it is divisible by 3,
 * by 5, or by neither of the two numbers.The value of the variable number should be
 * randomly determined with the following program code:
 * <code>int number = new Random().nextInt(100);</code>
 * Hint: Use the modulo operation
 */
public class Conditions {
    public static void main(String[] args) {

        // Generates a new integer between 0 and n;
        int number = new Random().nextInt(100);

        if ((number % 3 == 0) && (number % 5 == 0)) {
            System.out.println(("The number " + number + " is divided by 3 or 5."));
        } else if (number % 3 == 0) {
            System.out.println("The number " + number + " is divided by 3.");
        } else if (number % 5 == 0) {
            System.out.println("The number " + number + " is divided by 5.");
        } else {
            // No condition matches
            System.out.println("The number can't be divided by 3 and 5.");
        }
    }
}
