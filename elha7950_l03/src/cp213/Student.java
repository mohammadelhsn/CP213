package cp213;

import java.time.LocalDate;

/**
 * Student class definition.
 *
 * @author Mohammad El-Hassan, 169067950, elha7950@mylaurier.ca, @mohammadelhsn
 * @version 2024-09-30
 */
public class Student implements Comparable<Student> {

    // Attributes
    private LocalDate birthDate = null;
    private String forename = "";
    private int id = 0;
    private String surname = "";

    /**
     * Instantiates a Student object.
     *
     * @param id        student ID number
     * @param surname   student surname
     * @param forename  name of forename
     * @param birthDate birthDate in 'YYYY-MM-DD' format
     */
    public Student(int id, String surname, String forename, LocalDate birthDate) {
        this.id = id;
        this.surname = surname;
        this.forename = forename;
        this.birthDate = birthDate;
        return;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString() Creates a formatted string of student data.
     */
    @Override
    public String toString() {
        String string = "";

        // your code here

        return string;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Student target) {
        int result = 0;

        // your code here

        return result;
    }

    // getters and setters defined here
    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public Student setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Student setForename(String forename) {
        this.forename = forename;
        return this;
    }

    public Student setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getId() {
        return this.id;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getForename() {
        return this.forename;
    }
}
