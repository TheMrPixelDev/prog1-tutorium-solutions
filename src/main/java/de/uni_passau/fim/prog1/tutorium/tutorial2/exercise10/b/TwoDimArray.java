package de.uni_passau.fim.prog1.tutorium.tutorial2.exercise10.b;

/**
 * Modify the program to print a two-dimensional boolean array of size 5 × 5 instead
 * of a one-dimensional array. The array can also be hardcoded here.
 */
public class TwoDimArray {

    public static void main(String[] args) {
        /*
        * Creating an array, which contains arrays which contain boolean values.
        */
        boolean[][] array = {
                new boolean[]{true, false, true, false, true},
                new boolean[]{true, true, false, true, false},
                new boolean[]{false, true, true, false, true},
                new boolean[]{true, false, true, true, false},
                new boolean[]{false, true, false, true, true}
        };
        /*
        alternative
        boolean[][] array = {
                {true, false, true, false, true},
                {true, true, false, true, false},
                {false, true, true, false, true},
                {true, false, true, true, false},
                {false, true, false, true, true}
        };
         */


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
