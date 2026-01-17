package de.uni_passau.fim.prog1.tutorium.aufgabe10.d;

/**
 * (d) Modify the program so that it populates the array such that both diagonals (from
 * top-left to bottom-right and from top-right to bottom-left) have the value true,
 * and all other elements have the value false.
 * Example output:
 * <code>
 * X 0 0 0 X
 * 0 X 0 X 0
 * 0 0 X 0 0
 * 0 X 0 X 0
 * X 0 0 0 X
 * </code>
 * <p>
 * (e) Introduce a variable size and modify the program so that arrays of arbitrary size
 * (depending on size) can be populated and printed. The program should both
 * create and print the array.
 */
public class CrossArray {
    public static void main(String[] args) {
        // Solution from subtask (e). Guarantees a square array.
        int size = 5;
        boolean[][] array = new boolean[size][size];

        /*
         * Idee:
         * Idea: The falling diagonal occurs precisely when the row index is equal to the column index.
         *
         * [0][0],
         * [1][1],
         * .
         * .
         * .
         * [array.length -1][array.length -1]
         *
         * The ascending diagonal is exactly when [index of the row][(length of the array - 1) - index of the row].
         *
         *
         * [0][(array.length-1)-0],
         * [1][(array.length-1)-1],
         * .
         * .
         * .
         * [array.length-1][(array.length-1)-(array.length-1)],
         *
         * Runtime: O(n^2).
         */
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                // arraz.length -1, da das Array bei 0 indexiert, die Länge jedoch bei 1
                if (row == column || column == (array.length - 1) - row) {
                    array[row][column] = true;
                }
            }
        }


        /*
         * Optimierungsidee:
         * Man braucht column nur dann, wenn es den selben Wert wie row hat.
         * Dadurch kann man sich die Schleife einsparen, die die Spalten durchgegangen ist.
         *
         * Die steigende Diagonale ist gleich der fallenden Diagonale, außer
         * dass die Spalte "von hinten" herunter gezählt wird.
         * Statt
         * 0, 1, 2, ...
         * wird
         * (array.length - 1) - 0, (array.length - 1) - 1, (array.length - 1) - 2, ...
         * gezählt
         *
         * Dadurch erreicht man statt quadratischer Laufzeit O(n^2) eine lineare Laufzeit O(n).
         */
        for (int i = 0; i < array.length; i++) {
            array[i][i] = true;
            array[i][(array.length - 1) - i] = true;
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
