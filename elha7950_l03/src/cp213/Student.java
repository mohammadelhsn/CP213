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
	// Assign the passed 'id' value to the current object's id field
	this.id = id;
	// Assign the passed 'surname' value to the current object's surname field
	this.surname = surname;
	// Assign the passed 'forename' value to the current object's forename field
	this.forename = forename;
	// Assign the passed 'birthDate' value to the current object's birthDate field
	this.birthDate = birthDate;
	// Return
	return;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString() Creates a formatted string of student data.
     */
    @Override
    public String toString() {
	// Initialize an empty string to accumulate the object's information
	String string = "";
	// Format and append the object's surname, forename, id and birthDate to the
	// string
	// Using String.format() for clean alignment and presentation
	string += String.format("Name:      %s, %s\nID:        %d\nBirthdate: %s", surname, forename, id, birthDate);
	// Return
	return string;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Student target) {
	// Initialize result to store the comparison outcome
	int result = 0;
	// First, compare the surnames lexicographically
	result = surname.compareTo(target.getSurname());
	// If the first names are the same, compare the forenames
	if (result == 0) {
	    result = forename.compareTo(target.getForename());
	    // If both the surname and forenames are the same, compare the IDs numerically
	    if (result == 0) {
		result = Integer.compare(id, target.getId());
	    }
	}
	// Return the result (-1, 0, or 1)
	return result;
    }

    /*
     * GETTERS AND SETTERS DEFINED HERE
     *
     * Ideally, for Setters you would want to return `this` to allow for chaining It
     * doesn't make much sense to do the same for getters because you are returning
     * data.
     *
     * Usage example: Student theGoat = new Student(123456, "Brown", "David",
     * LocalDate.parse("1962-10-25"));
     * System.out.println(theGoat.setId(434343).getId()); // should output 434343
     */
    /**
     * Setter for the ID of a student.
     *
     * @param id The ID of the student
     * @return Student for chaining
     */
    public Student setId(int id) {
	this.id = id;
	return this;
    }

    /**
     * Setter for the birth date of a student.
     *
     * @param birthDate The birthDate of the student
     * @return Student for chaining
     */
    public Student setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
	return this;
    }

    /**
     * Setter for the forename of a student.
     *
     * @param forename The forename of a student
     * @return Student for chaining
     */
    public Student setForename(String forename) {
	this.forename = forename;
	return this;
    }

    /**
     * Setter for the Surname of a student.
     *
     * @param surname The surname of a student
     * @return Student for chaining
     */
    public Student setSurname(String surname) {
	this.surname = surname;
	return this;
    }

    /**
     * Getter for the ID
     *
     * @return int The ID of the student
     */
    public int getId() {
	return this.id;
    }

    /**
     * Getter for the Birth Date
     *
     * @return LocalDate The student's birth date
     */
    public LocalDate getBirthDate() {
	return this.birthDate;
    }

    /**
     * Getter for the Surname
     *
     * @return String The student's surname
     */
    public String getSurname() {
	return this.surname;
    }

    /**
     * Getter for the Forename
     *
     * @return String The student's forename
     */
    public String getForename() {
	return this.forename;
    }
}
