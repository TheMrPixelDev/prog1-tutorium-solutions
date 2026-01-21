package de.uni_passau.fim.prog1.tutorium.tutorial4.exercise19;

/**
 * Create a method crossSum which computes the cross sum of a given number and prints it to the console.
 * <blockquote><pre>
 * Example: cross sum of 232 : 2 + 3 + 2 = 7
 * </pre></blockquote>
 *
 * @author <a href="http://github.com/werli">Phil Werli</a>
 */

public class CrossSum {

    public static void main(String[] args) {
        System.out.println("Ziffernsumme von 232: " + crossSum(232));

        System.out.println("Ziffernsumme von 777777: " + crossSumWithChars(777777));
    }

    /**
     * Computes the cross sum for the passed number and returns it.
     *
     * @param number the number whose cross sum will be computes
     * @return the cross sum itself
     */
    private static int crossSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum = sum + (number % 10); // hole letzte Stelle mit der modulo-Operation: 232 % 10 = 2
            number = number / 10;      // verwirf letzte Stelle: 232 / 10 = 23
        }
        return sum;
    }

    /**
     * Computes the cross sum by splitting up the number into an array of characters the number consists of in order
     * to sum those up step-by-step.
     *
     * @param number the number whose cross sum will be computed
     * @return the cross sum itself
     */
    private static int crossSumWithChars(int number) {
        int sum = 0;
        char[] chars = String.valueOf(number).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sum += Character.getNumericValue(chars[i]);

            // Stattdessen funkioniert auch Folgendes
            // sum += Integer.valueOf(String.valueOf(chars[i]));
        }
        return sum;
    }
}
