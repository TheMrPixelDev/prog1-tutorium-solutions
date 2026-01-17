package de.uni_passau.fim.prog1.tutorium.tutorial3.exercise14.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Write a program that first reads a number (integer), then a mathematical operation (+,−,∗,/)
 * and then another number.
 * Each input should be read on a separate line.
 * The program should then output the result of the mathematical operation.
 * <p>
 * <p>
 * In this solution, the implementation uses a {@link BufferedReader} in the {@link #main(String[])} method
 * and a {@link Scanner} in the {@link #calcWithScanner()} method.
 */
public class Calculator {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Calculator using the BufferedReader:");
        calc.calcWithBufferedReader();
    }

    private void calcWithBufferedReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /*
         * Reading and storing the input in three strings. The reading process could result in an IOException,
         * which is handled in a try/catch block this time.
         */
        try {
            String input1 = reader.readLine();
            String operator = reader.readLine();
            String input2 = reader.readLine();

            /*
             * The BufferedReader reads a string that you first have to convert (“parse”) into a number in order to
             * be able to calculate with it. To do this, you can use Integer.parseInt(String input), for example.
             */
            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);

            /*
             * Important: Strings must be compared using the {@link String#equals(Object)} method. The
             * ‘==’ operator compares the object reference values, not the actual content of the objects.
             */
            String output = "";
            if (operator.equals("+")) {
                output = num1 + " " + operator + " " + num2 + " = " + (num1 + num2);

            } else if (operator.equals("-")) {
                output = num1 + " " + operator + " " + num2 + " = " + (num1 - num2);

            } else if (operator.equals("*")) {
                output = num1 + " " + operator + " " + num2 + " = " + (num1 * num2);
            } else if (operator.equals("/")) {//Division by 0.
                if (num2 != 0) {
                    output = num1 + " " + operator + " " + num2 + " = " + (num1 / num2);
                }
            }
            System.out.println(output);

        } catch (IOException e) {
            System.err.println("Error while reading input.");
        } finally {
            /*
             *  After reading, you should close the BufferedReader to avoid unwanted side effects.
             *  To ensure that the BufferedReader is closed in any case, we close the reader in
             *  a finally block. This is executed even if an exception was thrown in the try block.
             */
            try {
                reader.close();
            } catch (IOException ex) {
                System.err.println("Error closing reader.");
            }
        }
    }

    /**
     * Alternative solution with Scanner.
     * Instead of manually converting a scanned number from a string to a number, you can
     * use the {@link Scanner#nextInt()} method, which does this for you and returns an int value directly.
     * <p>
     * In addition, this solution uses a switch statement to check the operator.
     */
    private void calcWithScanner() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        int num1 = 0;
        String operator = "";
        int num2 = 0;

        /*
         * Scanner.hasNext() returns whether the scanner has received any input at all.
         * If this is not the case, the scanner ‘waits’ for the next input.
         */
        if (scanner.hasNext()) {
            num1 = scanner.nextInt();
        }
        if (scanner.hasNext()) {
            operator = scanner.next();
        }
        if (scanner.hasNext()) {
            num2 = scanner.nextInt();
        }

        /*
         * Switch statements check the ‘content’ of strings, not the object reference.
         *
         * From the Java documentation (https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html):
         * The String in the switch expression is compared with the expressions associated with each case
         * label as if the String.equals method were being used.
         */
        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                // Division by 0
                if (num2 != 0) {
                    result = num1 / num2;
                }
                break;
        }
        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

        scanner.close();
    }
}


