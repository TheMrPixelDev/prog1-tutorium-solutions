package de.uni_passau.fim.prog1.tutorium.aufgabe11;

import de.uni_passau.fim.prog1.tutorium.aufgabe10.c.FallingDiagonalArray;
import de.uni_passau.fim.prog1.tutorium.aufgabe10.d.CrossArray;

/**
 * Write a method printArray(boolean[][] array) that prints a two-dimensional
 * boolean array. Then, write the methods addDiagFalling(boolean[][] array) and
 * addDiagRising(boolean[][] array), which populate the given array on the falling
 * diagonal (from top-left to bottom-right) and the rising diagonal (from bottom-left to
 * top-right) with true (see Exercise 10).
 * Hint : You will hardly need to write any new code, just restructure your existing code
 * from above.
 */
public class ArrayOutput {

    public static void main(String[] args) {
        int size = 5;
        boolean[][] array = new boolean[size][size];

        System.out.println("Diagonal Array:");
        addDiagFalling(array);
        printArray(array);

        System.out.println("Cross Array:");
        addDiagRising(array);
        printArray(array);
    }

    /**
     * Modifies the given two-dimensional Boolean array so that
     * a descending diagonal line is added.
     *
     * @param array a two-dimensional array
     * @see FallingDiagonalArray
     */
    private static void addDiagFalling(boolean[][] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i][i] = true;
        }
    }

    /**
     * Modifies the given two-dimensional Boolean array so that
     * an ascending diagonal line is added.
     *
     * @param array a two-dimensional array
     * @see CrossArray
     */
    private static void addDiagRising(boolean[][] array) {
        for (int i = 0; i < array.length; ++i) {
            array[array.length - 1 - i][i] = true;
        }
    }

    /**
     * Outputs a given two-dimensional Boolean array.
     * <code>true</code> outputs an ‘X’,
     * <code>false</code> outputs an ‘O’.
     */
    private static void printArray(boolean[][] array) {

        //Gives back the array row by row, column by column
        for (int row = 0; row < array.length; ++row) {
            // array[row].length gives back the number of columns in the row of index row.
            for (int column = 0; column < array[row].length; ++column) {
                if (array[row][column]) {
                    System.out.print('X');
                } else {
                    System.out.print('O');
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
