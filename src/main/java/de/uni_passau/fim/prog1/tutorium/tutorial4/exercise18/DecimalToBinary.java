package de.uni_passau.fim.prog1.tutorium.tutorial4.exercise18;

/**
 * Write a method called decimalToBinary which iteratively converts a decimal number into its binary representation.
 * The number can be any which int is able to represent.
 *
 * Hint: You can use the following code in order to compute a to the power of b
 * int c = Math.pow ( a , b ) ;
 * Example: Math.pow(2, 5) equals 2 to the power of 5 and returns 32.
 * Example: The call decimalToBinay(42) returns "101010".
 * <p>
 * IMPORTANT: this task has a wide variety of possible solutions!
 *
 * @author <a href="http://github.com/werli">Phil Werli</a>
 */
public class DecimalToBinary {

    public static void main(String[] args) {
        System.out.println("Dec: 8 == Bin: " + decimalToBinary(8));
        System.out.println("Dec: 7 == Bin: " + decimalToBinary(7));
        System.out.println("Dec: 8 == Bin: " + decimalToBinaryWithPow(8));
        System.out.println("Dec: 7 == Bin: " + decimalToBinaryWithPow(7));
    }

    /**
     * Returns the binary representation of a given number as string.
     *
     * @param number the number whose binary representation will be computed
     * @return the binary representation of the number as string
     */
    private static String decimalToBinary(int number) {
        String output = "";

        // Vorgehenweise: Vergleiche Ziffernsumme
        while (number > 0) {
            // number % 2 liefert entweder 0 oder 1. Das wird dann links konkateniert, da hier zuerst die kleinen
            // Potenzen und danach dann die größeren überprüft werden.
            output = (number % 2) + output;
            number = number / 2;
        }

        return output;
    }

    /**
     * Returns the binary representation of a given number as string.
     *
     * @param number the number whose binary representation will be computed
     * @return the binary representation of the number as string
     */
    private static String decimalToBinaryWithPow(int number) {
        String output = "";

        // Variable started verhindert führende Nullen. Wird auf true gesetzt, sobald die erste 1 geschrieben wird.
        boolean started = false;
        for (int i = 31; i >= 0; i--) {
            double pow = Math.pow(2, i);
            if (pow <= number) {
                number -= pow;

                // Konkatenieren rechts des outputs, da die großen Zahlen vor den kleinen überprüft werden sollen.
                output = output + 1;
                started = true;
            } else if (started) {
                output = output + 0;
            }
        }
        return output;
    }

    /**
     * Returns the binary representation of a given number as string.
     *
     * @param number the number whose binary representation will be computed
     * @return the binary representation of the number as string
     */
    private static String decimalToBinaryWithToBinaryString(int number) {
        // ruft die statische Methode toBinaryString(int i) in der Klasse Integer / Long auf.
        // return Integer.toBinaryString(number);
        return Long.toBinaryString(number);
    }
}
