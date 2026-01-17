package de.uni_passau.fim.prog1.tutorium.tutorial3.exercise14.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Validation: Extend the calculator to handle invalid inputs (e.g., a letter instead
 * of a number). Hint : It might help to split your program into multiple methods.
 */
public class Validation {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /* To enable the reader to continue accepting further input after an incorrect entry rather than terminating the program,
         * the reading operations must be placed in a while loop, which is only
         * exited once correct input has been read.
         */
        try {
            int num1 = 0;
            String operator = "";
            int num2 = 0;

            // artificial loop condition
            boolean success = false;

            while (!success) { // same as while(success == false)
                try {
                    String input = reader.readLine();
                    num1 = Integer.parseInt(input);
                    success = true;
                } catch (NumberFormatException error) {
                    System.out.println("Please insert a number");
                }
            }

            success = false;
            while (!success) {
                operator = reader.readLine();

                /*
                 * Alternative with Regular Expressions.
                 * if (operator.matches("\\+|-|\\*|/")) {...}
                 */
                if (operator.equals("+")
                        || operator.equals("-")
                        || operator.equals("*")
                        || operator.equals("/")) {
                    success = true;
                } else {
                    System.out.println("Please insert a valid operand!");
                }
            }

            success = false;
            while (!success) {
                try {
                    String input = reader.readLine();
                    num2 = Integer.parseInt(input);
                    if (operator.equals("/") && num2 == 0) {
                        System.out.println("Division by 0 is not allowed. Please enter another number.");
                        continue;
                    }
                    success = true;
                } catch (NumberFormatException error) {
                    System.out.println("Please insert a number!");
                }
            }

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
                    // Division by zero has already been covered.
                    result = num1 / num2;
                    break;
            }
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        } catch (IOException e) {
            System.out.println("Error while reading input.");
        }
    }
}
