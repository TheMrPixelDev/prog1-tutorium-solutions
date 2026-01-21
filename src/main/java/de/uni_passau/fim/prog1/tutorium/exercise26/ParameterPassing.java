package de.uni_passau.fim.prog1.tutorium.exercise26;

import java.util.Arrays;

/**
 * What output does the following program have on the console?
 * Hint: Think about the different possibilities for passing parameters.
 */
public class ParameterPassing {
    private static int a = 10;
    private static int b = 3;

    public static void foo(int[] arr, boolean condition) {
        if (condition) {
            arr[2] = 10;
        } else {
            int a = b - 5;
            System.out.println("3: " + a);
            arr = new int[] { 5, 2, -3 };
        }
    }

    public static void increment() {
        a = 2 * a;
    }

    public static void increment2(int b) {
        b = 2 * b;
        System.out.println("7: " + b);
    }

    public static void main(String[] args) {
        int[] arr0 = { 4, 2, 1 };
        foo(arr0, true);
        System.out.println("1: " + Arrays.toString(arr0));
        increment();
        System.out.println("2: " + a);
        foo(arr0, false);
        System.out.println("4: " + Arrays.toString(arr0));
        System.out.println("5: " + a);
        increment();
        System.out.println("6: " + a);
        increment2(b);
        System.out.println("8: " + b);
    }
}
