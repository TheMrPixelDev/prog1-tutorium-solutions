package de.uni_passau.fim.prog1.tutorium.tutorial3.exercise15.b;

/**
 * Extend the class Student from (a) with a method public String toString(),
 * which returns the attributes of the object as a string. Then print the object using
 * the toString() method.
 * <p>
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

    /*
     * Every class in Java inherits from the Object class. This also means that all attributes and methods are inherited.
     *
     * If you implement your own class, you can override these methods. This is specified by
     * adopting the method header (here ‘public String toString()’). In addition, you can signal the override to the compiler
     * with the annotation ‘@Override’.
     */
    public static void main(String[] args) {
        // Creation of a Student object by calling its constructor with the specified parameters.
        Student manuelneuer = new Student("Neuer", "Manuel", 11111, "Goalkeeping Master", 3);

        // Calls the toString method. Note that System.out.println(manuelneuer); would result in the same result,
        // since internally, the toString method is called.
        System.out.println(manuelneuer.toString());
    }

    /**
     * toString() method of the Student class.
     * Overrides the toString() method of the Object class.
     *
     * @return String representation of the Student object.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return name + ", " + firstName + " studies " + courseOfStudy + " in the " + semester + ". semester.";

        /* Alternative solution with String.format(). Same structure as the printf() method from C/C++.
         * Suggested by tutorial participants:
         * return String.format(“%s, %s is studying %s in the %dth semester.”, name, firstName, courseOfStudy, semester);
         */
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

