package cp213;

// Imports
import java.io.PrintStream;
import java.util.Scanner;

/**
 * SerialNumber class including multiple methods
 *
 * @author Mohammad El-Hassan, 169067950, elha7950@mylaurier.ca, @mohammadelhsn
 * @version 2024-09-29
 */
public class SerialNumber {
	/**
	 * Default Constructor for the SerialNumber class
	 */
	public SerialNumber() {

	}

	/**
	 * Determines if a string contains all digits.
	 *
	 * @param str The string to test.
	 * @return true if str is all digits, false otherwise.
	 */
	public static boolean allDigits(final String str) {
		// Convert the string into an array of characters.
		char[] characters = str.toCharArray();
		// Assume the string is all digits at first
		boolean isAllDigits = true;
		// Loop through each character in the array
		for (char c : characters) {
			// Check if the current character is not a digit.
			// If it is set to false and break out of the loop
			if (!Character.isDigit(c)) {
				isAllDigits = false;
				break;
			}
		}
		// Return
		return isAllDigits;
	}

	/**
	 * Determines if a string is a good serial number. Good serial numbers are of
	 * the form 'SN/nnnn-nnn', where 'n' is a digit.
	 *
	 * @param sn The serial number to test.
	 * @return true if the serial number is valid in form, false otherwise.
	 */
	public static boolean validSn(final String sn) {
		// Start by assuming the serial number is not valid
		boolean isValid = false;
		// Expected parts of of the serial number format
		String part1_expected = "SN/";
		String part3_expected = "-";
		// Check if the length of the serial is exactly 11 characters.
		if (sn.length() == 11) {
			// Split the serial number into its 4 parts based on positions
			String part1 = sn.substring(0, 3);
			String part2 = sn.substring(3, 7);
			String part3 = sn.substring(7, 8);
			String part4 = sn.substring(8);
			// Check if the first part is "SN/"
			boolean part1_valid = part1.equalsIgnoreCase(part1_expected);
			// Check if the second part contains only digits
			boolean part2_valid = SerialNumber.allDigits(part2);
			// Check if the third part is a '-'
			boolean part3_valid = part3.equals(part3_expected);
			// Check if the 4th part contains only digits
			boolean part4_valid = SerialNumber.allDigits(part4);
			// The serial number is valid only if all four parts are valid
			isValid = part1_valid && part2_valid && part3_valid && part4_valid;
		}
		// Return
		return isValid;
	}

	/**
	 * Evaluates serial numbers from a file. Writes valid serial numbers to
	 * good_sns, and invalid serial numbers to bad_sns. Each line of fileIn contains
	 * a (possibly valid) serial number.
	 *
	 * @param fileIn  a file already open for reading
	 * @param goodSns a file already open for writing
	 * @param badSns  a file already open for writing
	 */
	public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {
		// Process each line of the input file
		while (fileIn.hasNextLine()) {
			// Read the current line from the input file
			String currentLine = fileIn.nextLine();
			// If it's valid append to the goodSns file
			// Else append to the badSns file
			if (SerialNumber.validSn(currentLine)) {
				goodSns.append(currentLine + "\n");
			} else {
				badSns.append(currentLine + "\n");
			}
		}
		// Flush the StringBuilder or Writer objects to ensure all data is written out
		goodSns.flush();
		badSns.flush();
		// Return
		return;
	}

}
