package de.uni_passau.fim.prog1.tutorium.aufgabe10.a;

/**
 * (a) Write a program that prints a boolean array of size 5 on the console. The value
 * true should be represented as X, and the value false as 0. The array can be
 * initialized with hardcoded values.
 * <p>
 * Example Output:
 * <code>0 X 0 X 0</code>
 */
public class OneDimArray {
    public static void main(String[] args) {
        boolean[] array = {true, false, true, false, true};

        for (int i = 0; i < array.length; i++) {
            if (array[i]) { // identical with (array[i] == true)
                System.out.print('X');
            } else {
                System.out.print('O');
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
