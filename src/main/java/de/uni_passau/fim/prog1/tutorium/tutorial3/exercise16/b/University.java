package de.uni_passau.fim.prog1.tutorium.tutorial3.exercise16.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.uni_passau.fim.prog1.tutorium.tutorial3.exercise16.a.Student;

/**
 * Extend you program so the constructor can read any amount of students from the console. Use the strings "finished" and
 * "continue" to indicate whether you are finished reading students.
 * All students should be printed to console after reading them.
 * <p>
 * In order to not repeat ourselfs we will reuse the {@link Student}-class from exercise 16a.
 *
 * @author <a href="http://github.com/werli">Phil Werli</a>
 */
public class University {

    // Attribute der University
    private int numberOfStudents;
    private Student[] arrayOfStudents;

    /**
     * Constuctor for creating a University-object. It would make sense to prefill the array with empty student object
     * whose attributes will be set later.
     *
     * @param maxNumberOfStudents Anzahl der Studierenden.
     */
    public University(int maxNumberOfStudents) {
        this.numberOfStudents = 0;
        this.arrayOfStudents = new Student[maxNumberOfStudents];
    }

    public static void main(String[] args) {
        University uniPassau = new University(5);
        uniPassau.addStudents();
        uniPassau.printStudents();
    }

    /**
     * Method for adding new students using the console.
     */
    private void addStudents() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean quit = false;
        /*
         * Schleifenbedingung: Solange der Benutzer Input eingeben möchte
         * und gleichzeitig die Uni noch Platz hat, läuft die Schleife weiter.
         */
        while (!quit && numberOfStudents < arrayOfStudents.length) {
            try {
                System.out.print("firstname: ");
                String firstName = reader.readLine();
                System.out.print("lastname: ");
                String name = reader.readLine();
                System.out.print("student id: ");
                int matrNr = Integer.parseInt(reader.readLine());
                System.out.print("field of study: ");
                String studyCourse = reader.readLine();
                System.out.print("semester: ");
                int semester = Integer.parseInt(reader.readLine());

                arrayOfStudents[numberOfStudents] = new Student(name, firstName, matrNr,
                        studyCourse, semester);
                numberOfStudents++;

                if (numberOfStudents < arrayOfStudents.length) {
                    // Do not display this line the very last time
                    System.out.print("Continue? (continue/finished): ");

                    if (!(reader.readLine().equals("continue"))) {
                        quit = true;
                    }
                }
            } catch (IOException error) {
                System.out.println("Error reading student.");
            }
        }
    }

    /**
     * Diese Methode gibt alle Studierende auf der Konsole aus.
     */
    private void printStudents() {
        System.out.println("List of students:");
        // Durchgehen und Ausgeben aller Studierenden
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println(arrayOfStudents[i].toString());
        }
    }
}
