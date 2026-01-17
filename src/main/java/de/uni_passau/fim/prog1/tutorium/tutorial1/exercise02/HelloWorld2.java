package de.uni_passau.fim.prog1.tutorium.tutorial1.exercise02;

/**
 * Create a program that outputs the text "Hello World" 100 times to the console. Each
 * "Hello World" should be on its own line. Each line should begin with the corresponding
 * line number.
 */
public class HelloWorld2 {
    public static void main(String[] args) {

        System.out.println("Iterative: ");
        iterative();

        System.out.println("Recursive: ");
        recursive(1);
    }

    /**
     * Iterative method
     */
    private static void iterative() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " - Hello World!");
        }
    }

    /**
     * Recursive method
     */
    private static void recursive(int i) {
        System.out.println(i + " - Hello World!");

        // termination
        if (i < 100) {
            recursive(i + 1);
        }
    }
}
