package de.uni_passau.fim.prog1.tutorium.aufgabe08;

/**
 * Write a program that includes a method countdown(int n). This method should
 * recursively count down from n to 1 and print each number.
 * Note : A <i>recursive</i> function calls itself. Without a termination condition, it will run
 * indefinitely
 */
public class Countdown {

    public static void main(String[] args) {
        // method call with n = 10
        countdown(10);
    }

    /**
     * Outputs a given number n to the console and calls itself again
     * with parameter (n-1) if n is a natural number.
     *
     * @param n a natural number.
     */
    private static void countdown(int n) {

        // only executed if n > 0 -> termination if n <= 0
        if (n > 0) {
            System.out.println(n);
            // recursive call with new param
            countdown(n - 1);
        }
    }
}
