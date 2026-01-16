package de.uni_passau.fim.prog1.tutorium.aufgabe05;

/**
 * Create a program that outputs the numbers 1 to 100 line by line to the console. If the
 * number is divisible by 3, instead of the number itself, the string foo should be output.
 * If the number is divisible by 5, instead of the number itself, the string bar should be
 * output. If the number is divisible by both 3 and 5, foobar should be output
 */
public class Foobar {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            // Check if i is divisible by 3 AND 5
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("foobar");
            }
            // Check if i is divisible by 3
            else if (i % 3 == 0) {
                System.out.println("foo");
            }
            // Check if i is divisible by 5
            else if (i % 5 == 0) {
                System.out.println("bar");
            }
            // No condition matches
            else {
                System.out.println(i);
            }
        }
    }
}
