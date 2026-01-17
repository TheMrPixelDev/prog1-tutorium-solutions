package de.uni_passau.fim.prog1.tutorium.tutorial3.exercise15.a;

/**
 * Create a class Student with the attributes name, first name, student ID, course of
 * study, and semester. Then create an object of the class Student with properties
 * that apply to yourself.
 */
public class Student {

    // Attributes of a student
    private String name;
    private String firstName;
    private int studentID;
    private String courseOfStudy;
    private int semester;

    /**
     * Constructor of student-object.
     */
    public Student(String name, String firstName, int studentID, String courseOfStudy, int semester) {
        this.name = name;
        this.firstName = firstName;
        this.studentID = studentID;
        this.courseOfStudy = courseOfStudy;
        this.semester = semester;
    }

    public static void main(String[] args) {
        // Creation of a Student object by calling its constructor with the specified parameters.
        Student manuelNeuer = new Student("Neuer", "Manuel", 11111, "Goalkeeping Master", 3);
    }

    // Getter and Setter-methods, because the variables are private

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

