package de.uni_passau.fim.prog1.tutorium.aufgabe02;

/**
 * Erstelle ein Programm, welches den Text “Hello World!” 100-mal auf der Konsole ausgibt.
 * Jedes “Hello World!” soll dabei in einer eigenen Zeile stehen. Jede Zeile soll mit
 * der entsprechenden Zeilennummer beginnen.
 *
 * @author <a href="http://github.com/werli">Phil Werli</a>
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

        // Abbruchbedingung
        if (i < 100) {
            recursive(i + 1);
        }
    }
}
