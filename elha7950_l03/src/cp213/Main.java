package cp213;

import java.time.LocalDate;

/**
 * Tests the Student class.
 *
 * @author Mohammad El-Hassan, 169067950, elha7950@mylaurier.ca, @mohammadelhsn
 * @version 2024-09-30
 */
public class Main {
	/**
	 * Default constructor for the Main class
	 */
	public Main() {

	}

	/**
	 * The main function for the program
	 *
	 * @param args Unused
	 */
	public static void main(String[] args) {
		final String line = "-".repeat(40);
		int id = 123456;
		String surname = "Brown";
		String forename = "David";
		LocalDate birthDate = LocalDate.parse("1962-10-25");
		Student student = new Student(id, surname, forename, birthDate);
		System.out.println("New Student:");
		System.out.println(student);
		System.out.println(line);
		// nah, call setters and then call getters to test both at the same time
		System.out.println("Test Getters/Test Setters");
		System.out.println(line);
		System.out.println(String.format("Old ID: %d\nNew ID: %d", student.getId(), student.setId(434343).getId()));
		System.out.println(line);
		System.out.println(String.format("Old Surname: %s\nNew Surname: %s", student.getSurname(),
				student.setSurname("Goat").getSurname()));
		System.out.println(line);
		System.out.println(String.format("Old Forename: %s\nNew Forename: %s", student.getForename(),
				student.setForename("The").getForename()));
		System.out.println(line);
		System.out.println(String.format("Old BirthDate: %s\nNew BirthDate: %s", student.getBirthDate(),
				student.setBirthDate(LocalDate.parse("1963-11-26")).getBirthDate()));
		System.out.println(line);
		System.out.println("Updated Student:");
		System.out.println(student);
		System.out.println(line);
		System.out.println("Test compareTo");
		// create new Students - call comparisons here
		String firstName = "Mohammad";
		String lastName = "El-Hassan";
		int id_new = 696969;
		LocalDate birthDate_new = LocalDate.parse("2005-06-20");
		Student studentMe = new Student(id_new, lastName, firstName, birthDate_new);
	}
}
