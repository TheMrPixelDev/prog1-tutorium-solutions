package de.uni_passau.fim.prog1.tutorium.aufgabe06;

import java.util.Random;

/**
 * Create a program that calculates the greatest common divisor of two numbers a and b
 * using the Euclidean algorithm. The values for a and b can be randomly determined.
 * This can be done with:
 * <code>int a = new Random().nextInt(100);</code>
 * <code>int b = new Random().nextInt(100);</code>
 */
public class GGT {
    public static void main(String[] args) {
        int a = new Random().nextInt(100);
        int b = new Random().nextInt(100);

        // Solution in a separate method
        int ggT = ggT(a, b);
        System.out.println("The greatest common divisor of "
                + a + " and " + b + " is " + ggT + ".");

        // Solution in main method
        int outputA = a;
        int outputB = b;

        if (a != 0 && b != 0) {
            while (b != 0) {
                if (a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            System.out.println("The greatest common divisor of "
                    + outputA + " und " + outputB + " ist " + a + ".");
        }

        System.out.println("(b) Recursiv:\nThe greatest common divisor of " +
                + outputA + " and " + outputB + " is " + ggTRecursive(outputA, outputB) + ".\"");
    }

    /**
     * Gives back the greatest common divisor of a and b.
     */
    private static int ggT(int a, int b) {
        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    /**
     * Gives back the greatest common divisor of a and b recursively
     */
    private static int ggTRecursive(int a, int b) {
        if (b == 0) {
            return a;
        } else if (a > b) {
            return ggTRecursive(a - b, b);
        } else {
            return ggTRecursive(a, b - a);
        }
    }
}