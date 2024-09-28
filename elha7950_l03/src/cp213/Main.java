package cp213;

import java.time.LocalDate;

/**
 * Tests the Student class.
 *
 * @author your name here
 * @version 2022-01-17
 */
public class Main {

    public static void main(String[] args) {
	final String line = "-".repeat(40);
	int id = 123456;
	String surname = "Brown";
	String forename = "David";
	LocalDate birthDate =  LocalDate.parse("1962-10-25");
	Student student = new Student( /* parameters here */);
	System.out.println("New Student:");
	System.out.println(student);
	System.out.println(line);
	System.out.println("Test Getters");

	// call getters here

	System.out.println(line);
	System.out.println("Test Setters");

	// call setters here

	System.out.println("Updated Student:");
	System.out.println(student);
	System.out.println(line);
	System.out.println("Test compareTo");

	// create new Students - call comparisons here
    }

}
