package de.uni_passau.fim.prog1.tutorium.tutorial4.exercise21;

/**
 * Create a method diagonalProductSum which will be passed a two dimensional quadratic array.
 * The methods should compute the product between the numbers on both diagonals and sum those up afterwards.
 * In case the content of a cell is zero it will be skipped.
 *
 * <p>
 * <blockquote><pre>
 * 3, 8, 3, 4, 1
 * 5, 0, 7, 4, 9
 * 9, 8, 2, 6, 2 -> (3 * 2 * 1 * 3) + (1 * 4 * 2 * 3) = 18 + 24 = 42
 * 2, 0, 4, 1, 6
 * 3, 2, 3, 5, 3
 * </pre></blockquote>
 *
 * @author <a href="http://github.com/werli">Phil Werli</a>
 */
public class DiagonalProductSum {

    public static void main(String[] args) {
        int[][] array = {
                {3, 8, 3, 4, 1},
                {5, 0, 7, 4, 9},
                {9, 8, 2, 6, 2},
                {2, 0, 4, 1, 6},
                {3, 2, 3, 5, 3}};

        System.out.println(diagSum(array));
    }

    /**
     * Computes the sum of the products of the elements on the diagonals of the array.
     * <p>
     * In case the content of cell is null it will be skipped since the product would then result in zero.
     *
     * @param array the two-dimensional array
     * @return the sum of the two products of the diagonals.
     */
    private static int diagSum(int[][] array) {
        // neutrales Element bei der Multiplikation ist 1
        int fallingDiagonalProduct = 1;
        int risingDiagonalProduct = 1;

        for (int i = 0; i < array.length; i++) {
            // Durchgang der fallenden Diagonale
            if (array[i][i] != 0) { //
                // (a = a * b) == (a *= b) = true
                fallingDiagonalProduct *= array[i][i];
            }

            // Durchgang der steigenden Diagonale
            int lastColumn = array.length - 1;
            if (array[i][lastColumn - i] != 0) {
                risingDiagonalProduct *= array[i][lastColumn - i];
            }
        }
        return fallingDiagonalProduct + risingDiagonalProduct;
    }

}
