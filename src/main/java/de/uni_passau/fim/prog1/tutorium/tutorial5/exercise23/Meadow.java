package de.uni_passau.fim.prog1.tutorium.tutorial5.exercise23;

import java.util.Random;

/**
 * Please mind: This is just a solution recommend by the tutors.
 *
 * <p>Task from a previous exam: Goat Life.
 */
public class Meadow {
    /**
     * Size of the meadow.
     */
    private static final int MEADOW_SIZE = 5;

    /**
     * Random Number Generator, which generates random numbers as the name implies.
     */
    private final Random rng;

    /**
     * The goat on the meadow which is pretty hungry.
     */
    private final Goat goat;

    /**
     * Stellt eine Wiese dar. Jede Zelle repräsentiert die Höhe des Grases.
     */
    private final int[][] meadow;

    /**
     * Constructs the meadow.
     */
    public Meadow() {
        rng = new Random();
        this.goat = new Goat(rng.nextInt(MEADOW_SIZE), rng.nextInt(MEADOW_SIZE));
        this.meadow = rMeadow(MEADOW_SIZE, MEADOW_SIZE);
    }

    /**
     * Initializes the meadow and its cells. Each cell contains a random number between 1 and 10 which represents the
     * height of the grass.
     *
     * @param width width of the meadow
     * @param height height of the meadow
     * @return a randomly generated meadow
     */
    private int[][] rMeadow(int width, int height) {
        int[][] meadow = new int[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                meadow[row][col] = 1 + rng.nextInt(10);
            }
        }
        return meadow;
    }

    /**
     * Simulates a single day in the life of the goat on the meadow. The goat can starve if the height of the grass
     * is not sufficient anymore. The precise rules are described in the exercise.
     */
    public void nextDay() {
        int goatRow = goat.getCurrentRow();
        int goatCol = goat.getCurrentCol();

        int maxValue = meadow[goatRow][goatCol];
        int maxRow = goatRow;
        int maxCol = goatCol;
        for (int row = -1; row <= 1; row++) {
            for (int col = -1; col <= 1; col++) {
                // Positionen abhängig der ursprünlichen Position der Ziege
                int curRow = goatRow + row;
                int curCol = goatCol + col;

                if (curRow >= 0 && curCol >= 0 && curRow < meadow.length &&
                        curCol < meadow[row].length) {
                    int currentValue = meadow[curRow][curCol];
                    if (currentValue > maxValue) {
                        maxValue = currentValue;
                        maxRow = curRow;
                        maxCol = curCol;
                    }
                }
            }
        }
        if (maxValue <= 0) {
            goat.setDead(true);
            return;
        }

        goat.setCurrentRow(maxRow);
        goat.setCurrentCol(maxCol);
        meadow[maxRow][maxCol] -= 30;

        for (int row = 0; row < meadow.length; row++) {
            for (int col = 0; col < meadow[row].length; col++) {
                if (row != maxRow && col != maxCol) {
                    meadow[row][col] += rng.nextInt(3);
                }
            }
        }
    }
}
