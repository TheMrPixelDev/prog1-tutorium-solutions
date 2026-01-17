package de.uni_passau.fim.prog1.tutorium.tutorial2.exercise10.c;

/**
 * (c) Modify the program so that it populates the array such that the falling diagonal
 * (from top-left to bottom-right) has the value true, and all other elements have
 * the value false. Operate on the existing array and print it using the code written
 * above.
 * Example output:
 * <code>
 * X 0 0 0 0
 * 0 X 0 0 0
 * 0 0 X 0 0
 * 0 0 0 X 0
 * 0 0 0 0 X
 * </code>
 * <p>
 * (e) Introduce a variable size and modify the program so that arrays of arbitrary size
 * (depending on size) can be populated and printed. The program should both
 * create and print the array.
 */
public class FallingDiagonalArray {
    public static void main(String[] args) {
        // Solution from subtask (e). Guarantees a square array.
        int size = 5;
        /*
         * The value of a Boolean without an explicit declaration is false.
         * This means that the two-dimensional array created below initially consists ONLY of false values.
         */
        boolean[][] array = new boolean[size][size];

        /*
         * Idea: The falling diagonal occurs precisely when the row index is equal to the column index.
         *
         * [0][0],
         * [1][1],
         * .
         * .
         * .
         * [array.length -1][array.length -1]
         * Here, array.length - 1 is selected because the index for the length of the array starts at 1, whereas
         * the index for the elements of the array starts at 0.
         *
         * Runtime: O(n^2).
         */
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                if (row == column) {
                    array[row][column] = true;
                }
            }
        }

        /*
         * Optimization idea: You only need column if it has the same value as row.
         * This allows you to skip the loop that went through the columns.
         *
         * This achieves a linear runtime O(n) instead of a quadratic runtime O(n^2)..
         */
        for (int i = 0; i < array.length; i++) {
            array[i][i] = true;
        }

        /*
         * Gives back the array row by row, column by column
         */
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
