package de.uni_passau.fim.prog1.tutorium.tutorial4.exercise22;

/**
 * Write a method mirrorArray which mirrors a two-dimensional array at its vertical axes.
 * The rows of the matrix might be of different length. In this case every individual row should be mirrored
 * along its center.
 * Example:
 * <blockquote><pre>
 * 3            3
 * 0 5          5 0
 * 9 8 2     →  2 8 9
 * 1 4 0 2      2 0 4 1
 * 3 2 3 5 3    3 5 3 2 3
 * </pre></blockquote>
 *
 * @author <a href="http://github.com/werli">Phil Werli</a>
 */
public class MirrorArray {

    public static void main(String[] args) {
        int[][] array = {
                {3},
                {5, 0},
                {9, 8, 2},
                {2, 0, 4, 1},
                {3, 2, 3, 5, 3}};
        mirrorArray(array);
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Mirrors the content of the given array at its vertical axes.
     * <p>
     * The array must not be returned, since the array will be referentially modified (Call-by-Reference).
     *
     * @param array the array which will be mirrored
     */
    private static void mirrorArray(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < (array[row].length / 2); col++) {
                int temp = array[row][col];
                array[row][col] = array[row][array[row].length - 1 - col];
                array[row][array[row].length - 1 - col] = temp;
            }
        }
    }
}
