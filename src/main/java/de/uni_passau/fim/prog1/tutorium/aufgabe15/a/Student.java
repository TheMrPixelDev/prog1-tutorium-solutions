package de.uni_passau.fim.prog1.tutorium.aufgabe15.a;

/**
 * Diese Klasse repräsentiert einen Studierenden und enthält alle notwenidigen Attribute.
 *
 * @author <a href="http://github.com/werli">Phil Werli</a>
 */
public class Student {

    // Attribute eines Studierenden
    private String name;
    private String firstName;
    private int studentID;
    private String courseOfStudy;
    private int semester;

    /**
     * Konstruktor für ein Student-Object.
     */
    public Student(String name, String firstName, int studentID, String courseOfStudy, int semester) {
        this.name = name;
        this.firstName = firstName;
        this.studentID = studentID;
        this.courseOfStudy = courseOfStudy;
        this.semester = semester;
    }

    /**
     * toString-Methode der Student-Klasse
     *
     * @return String-Repräsentation des Student-Objekts.
     */
    @Override
    public String toString() {
        return name + ", " + firstName + " studiert " + courseOfStudy + " im " + semester + ". Semester.";
    }

    // Getter und Setter-Methoden, da die Variablen private sind.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCourseOfStudy() {
        return courseOfStudy;
    }

    public void setCourseOfStudy(String courseOfStudy) {
        this.courseOfStudy = courseOfStudy;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}

