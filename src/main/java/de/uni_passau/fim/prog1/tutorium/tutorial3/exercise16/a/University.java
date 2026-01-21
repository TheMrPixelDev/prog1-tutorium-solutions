package de.uni_passau.fim.prog1.tutorium.tutorial3.exercise16.a;

/**
 * Create a class University and a class Student (equivalent to exercise 14(b))
 * The class University should contain a variable numberOfStudents and an Array of student object.
 * Add at least 3 Student-Objekte to the array and create a method printStudents
 * which prints all student object of the array to console.
 * <p>
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
        University uniPassau = new University(3);
        uniPassau.arrayOfStudents[0] = new Student("Hans", "Peter", 54321, "BA Informatik", 1);
        uniPassau.arrayOfStudents[1] = new Student("Bieber", "Justin", 12345, "Musicology", 3);
        uniPassau.arrayOfStudents[2] = new Student("Manuel", "Neuer", 11111, "Goalkeeping Master", 10);

        uniPassau.setNumberOfStudents(3);

        uniPassau.printStudents();
    }

    /**
     * Method ot print the students on the console.
     */
    private void printStudents() {
        System.out.println("List of students:");
        for (int i = 0; i < numberOfStudents; i++) {
            // Ausgabe des Ergebnisses der toString() Methode von Studierenden
            System.out.println(arrayOfStudents[i]);
        }

    }

    // Getter und Setter-methods, since attributes are private.
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Student[] getArrayOfStudents() {
        return arrayOfStudents;
    }

    public void setArrayOfStudents(Student[] arrayOfStudents) {
        this.arrayOfStudents = arrayOfStudents;
    }
}
