package de.uni_passau.fim.prog1.tutorium.tutorial2.exercise09;

/**
 * In the year 1202, Leonardo Fibonacci developed the Fibonacci sequence to describe the
 * growth of a rabbit population. The sequence is as follows:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, . . .
 * Each number is the sum of the two preceding numbers. The formal definition is:
 * <code>
 * fib(0) = 0
 * fib(1) = 1
 * fib(n) = fib(n−1) + fib(n−2)
 * </code>
 * <p>
 * (a) Write a program that recursively calculates the Fibonacci sequence up to fib(30) and
 * outputs each Fibonacci number on a separate line.
 * (b) Write another method that finds and outputs the first Fibonacci number ≥ 1000.
 * (c) For Experts : The program in its current form is quite inefficient. Improve your
 * program using dynamic programming to enhance runtime performance. Use an
 * array to store intermediate results. You can solve this iteratively or recursively.
 */
public class Fibonacci {
    public static void main(String[] args) {
        // (a)
        System.out.println("Exercise (a):");
        for (int i = 0; i <= 30; i++) {
            System.out.println("The Fibonacci number of " + i + " is " + fib(i) + ".");
        }

        // (b)
        System.out.println("Exercise (b):");
        int i = 0;
        int maximum = 1000;
        while (fib(i) < maximum) {
            i++;
        }
        System.out.println("The first Fibonacci number greater than" + maximum +
                " is the Fibonacci number of " + i + " and is " + fib(i) + ".");

        // alternative solution for (b)
        System.out.println("Recursive solution for (b):");

        int n = findFirstFibOver(0, maximum);
        System.out.println("The first Fibonacci number greater than" + maximum +
                " is the Fibonacci number of " + n + " and is " + fib(n) + ".");

        // (c)
        System.out.println("Exercise (c):");
        for (int j = 0; j <= 30; j++) {
            System.out.println("The Fibonacci number of " + j + " is " + fastFib(j) + ".");
        }
    }

    /**
     * Recursively calculates the Fibonacci number for the given number n.
     *
     * @param n Integer number whose Fibonacci number is returned.
     * @return Fibonacci number of the given number n.
     */
    private static int fib(int n) {
        // Covers fib(0) = 1 and fib(1) = 1.
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            // double recursive call covers fib(n) = fib(n-1) + fib(n-2).
            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
     * Recursively calculates the first Fibonacci number above a
     * given limit and returns it.
     * <p>
     * This recursive solution was solved by a
     * participant in the tutorial and was added as an alternative
     * solution suggestion.
     *
     * @param n Index, which is incremented by 1 and returned
     *              when the first number above the upper limit is found.
     * @param limit The upper limit of the Fibonacci number.
     * @return The first Fibonacci number above a given limit.
     */
    private static int findFirstFibOver(int n, int limit) {
        if (fib(n) < limit) {
            return findFirstFibOver(n + 1, limit);
        } else {
            return n;
        }
    }

    /**
     * Computes the Fibonacci number with dynamic programming.
     * This method is only there for initializing the array and
     * then forwards the call to the fibDynamic method.
     *
     * @param n Integer number whose Fibonacci number is returned.
     * @return The Fibonacci number of the given number.
     */
    private static int fastFib(int n) {
        int[] cache = new int[n+1];
        return fibDynamic(n, cache);
    }

    /**
     * Computes the Fibonacci number with dynamic programming.
     * The computed calls are stored in an array, such that they don't have to be
     * recalculated when they are needed again.
     *
     * @param cache The array which stores already computed results.
     * @param n Integer number whose Fibonacci number is returned.
     * @return The Fibonacci number of the given number.
     */
    private static int fibDynamic(int n, int[] cache) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if (cache[n] != 0) {
                return cache[n];
            }
            int newFib = fibDynamic(n - 1, cache) + fibDynamic(n - 2, cache);
            cache[n] = newFib;
            return newFib;
        }
    }
}
