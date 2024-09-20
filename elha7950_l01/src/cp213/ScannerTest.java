package cp213;

import java.util.Scanner;

/**
 * Default Constructor Scanner Test
 *
 * @author Mohammad El-Hassan
 * @version 2024-09-16
 */
public class ScannerTest {
    /**
     * Default constructor for ScannerTest.
     */
    public ScannerTest() {
    }

    /**
     * Count the lines in the file
     *
     * @param source Scanner for the file
     * @return number of lines in scanned file
     */
    public static int countLines(final Scanner source) {

	// Define the variable
	int count = 0;

	// While there is a next line
	while (source.hasNextLine()) {

	    // Add one to the count
	    count += 1;

	    // Move to the next line
	    source.nextLine();
	}

	// Return
	return count;
    }

    /**
     * Count tokens in the scanned object.
     *
     * @param source Scanner
     * @return number of tokens in scanned object
     */
    public static int countTokens(final Scanner source) {

	// Define the variable
	int tokens = 0;

	// While there is a next token
	while (source.hasNext()) {

	    // Add one to the count
	    tokens += 1;

	    // Move to the next token
	    source.next();
	}

	// Return
	return tokens;
    }

    /**
     * Ask for and total integers from the keyboard.
     *
     * @param keyboard Scanner
     * @return total of positive integers entered from keyboard
     */
    public static int readNumbers(final Scanner keyboard) {

	// Define the variable
	int total = 0;

	// While the input is not 'q'
	while (!keyboard.hasNext("q")) {

	    // If the input is a number
	    if (keyboard.hasNextInt()) {

		// Add to the total
		total = total + keyboard.nextInt();

	    } else {

		// Define the line to get correct output
		String line = keyboard.nextLine();

		// If the line is not blank
		if (!line.isBlank()) {

		    // Format the string
		    String sf1 = String.format("'%s' is not an integer or 'q'.", line);

		    // Output the string
		    System.out.println(sf1);
		}
	    }
	}

	// Return
	return total;
    }

}
