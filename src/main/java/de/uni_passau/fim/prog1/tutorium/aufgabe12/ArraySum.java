package de.uni_passau.fim.prog1.tutorium.aufgabe12;

/**
 * Write a program that calculates the sum of the largest value in all columns of a
 * two-dimensional array. The array can have multiple rows (≥ 1). The
 * array can be initialized with any hard-coded values. In addition, it can be
 * assumed that the array is rectangular.
 *
 * Example 1:
 * _________
 * |4|6|7|8|
 * |8|3|1|6|  results in 29, since 8 + 6 + 7 + 8 = 29.
 * ‾‾‾‾‾‾‾‾‾
 * Example 2:
 * _____________
 * |4|6|7|8|2|7|
 * |8|3|1|6|3|1|  equals 42, because 8 + 6 + 9 + 8 + 4 + 7 = 42.
 * |1|4|9|2|4|5|
 * ‾‾‾‾‾‾‾‾‾‾‾‾‾
 * Example output:
 * The sum of the largest value in all columns of the array is 29.
 */
public class ArraySum {

    public static void main(String[] args) {
        int[][] array = {
                {4, 6, 7, 8},
                {8, 3, 1, 6}};
        /*
         * Idea: Go through each column line by line and look for the maximum value.
         * Add the maximum values of the columns to a variable sum.
         */
        int sum = 0;

        /*
         * array[0].length returns the number of rows in the first column.
         * Since the array is rectangular, the first column has the same number of rows as the other columns.
         */
        for (int column = 0; column < array[0].length; ++column) { // iterate over columns ...
            // max value of a column
            int max = 0;

            for (int row = 0; row < array.length; ++row) { // ... and then over rows
                if (array[row][column] > max) {
                    max = array[row][column];
                }
            }

            sum = sum + max;
        }
        System.out.println("The sum of the largest value in all columns of the array is " + sum + ".");
    }
}
