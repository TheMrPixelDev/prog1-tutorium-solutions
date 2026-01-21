package de.uni_passau.fim.prog1.tutorium.tutorial3.exercise16.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.uni_passau.fim.prog1.tutorium.tutorial3.exercise16.a.Student;

/**
 * Erweitere das Programm, sodass im Konstruktor der Klasse University die Daten von (beliebig vielen) Studierenden
 * von der Konsole eingelesen werden. Verwende die Eingabe fertig bzw. weiter um nach einer vollständigen Eingabe das
 * Einlesen zu beenden bzw. weitere Studierende hinzuzufügen.
 * Nach dem Einlesen sollen alle Studierende auf der Konsole ausgegeben werden.
 * <p>
 * Hier benutzen wir der Einfachheit halber die {@link Student}-Klasse von auf Aufgabe 15a.
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
                int matrNr = readInteger(reader);

                System.out.print("field of study: ");
                String studyCourse = reader.readLine();

                System.out.print("semester: ");
                int semester = readInteger(reader);

                arrayOfStudents[numberOfStudents] = new Student(name, firstName, matrNr,
                        studyCourse, semester);
                numberOfStudents++;

                quit = validateContinue(reader, numberOfStudents);
            } catch (IOException error) {
                System.out.println("Error reading student.");
            }
        }

    }

    /**
     * Ready a string and converts it into an integer (also called "parsing").
     *
     * @return A number which was read.
     * @throws IOException Throws an IOException if input failed.
     */
    private int readInteger(BufferedReader reader) throws IOException {
        int number = 0;
        boolean success = false;
        while (!success) {
            try {
                number = Integer.parseInt(reader.readLine());
                if (0 >= number) {
                    throw new IllegalArgumentException();
                }
                success = true;
            } catch (NumberFormatException error) {
                System.out.println("Please type a number!");
            } catch (IllegalArgumentException error) {
                System.out.println("The number must be positiv!");
            }
        }
        return number;
    }

    /**
     * Validates whether the programm should continue running.
     *
     * @return whether the programm should continue
     * @throws IOException Trows an IOException if input failed.
     */
    private boolean validateContinue(BufferedReader reader, int counter) throws IOException {
        boolean quit = false;
        boolean success = false;
        if (counter < arrayOfStudents.length) {
            // Do not display this line the very last time.
            System.out.print("Continue? (continue/finished): ");
            while (!success) {
                String input = reader.readLine();
                if (input.equals("continue")) {
                    success = true;
                } else if (input.equals("finished")) {
                    success = true;
                    quit = true;
                } else {
                    System.out.println("Please either type 'continue' or 'finished'.");
                }
            }
        }
        return quit;
    }

    /**
     * Method for printing the students to the console.
     */
    private void printStudents() {
        System.out.println("Liste an Studierenden:");
        // Durchgehen und Ausgeben aller Studierenden
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println(arrayOfStudents[i]);
        }
    }
}
