package de.uni_passau.fim.prog1.tutorium.tutorial1.exercise03;

/**
 * Create a program that stores you and your neighbors in an array and then greets each
 * with "Hello, <name>" If you are alone, just invent as many names as you like.
 * Tip : You can still "hard code" the names here. That is, you define the names directly
 * in your code.
 */
public class GreetArray {
    public static void main(String[] args) {

        //declare and initialize names Array
        String[] names = {"Fabian", "Christoph", "Phil"};

        for (int i = 0; i < names.length; i++) {
            System.out.println("Hello " + names[i] + "!");
        }
    }
}
