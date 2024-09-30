package cp213;

/**
 * Strings class including several methods
 *
 * @author Mohammad El-Hassan, 169067950, elha7950@mylaurier.ca, @mohammadelhsn
 * @version 2024-09-29
 */
public class Strings {
	/**
	 * Default Constructor for the Strings class
	 */
	public Strings() {

	}

	// Constants
	/**
	 * A string containing all the vowels in both forms
	 */
	public static final String VOWELS = "aeiouAEIOU";

	/**
	 * Determines if string is a "palindrome": a word, verse, or sentence (such as
	 * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
	 * case, spaces, digits, and punctuation in the string parameter s.
	 *
	 * @param string a string
	 * @return true if string is a palindrome, false otherwise
	 */
	public static boolean isPalindrome(final String string) {
		// Create a StringBuilder to build a normalized version of the string
		StringBuilder sb = new StringBuilder();
		// Loop through each character in the input string
		for (char ch : string.toCharArray()) {
			// Check if the character is a letter (ignores digits and symbols)
			if (Character.isLetter(ch)) {
				// Append the lowercase version of the letter to the StringBuilder
				sb.append(Character.toLowerCase(ch));
			}
		}
		// Convert the StringBuilder to a string for the normalized version
		String normalized = sb.toString();
		// Reverse the normalized string
		String normalizedReverse = sb.reverse().toString();
		// Check if the normalized string is equal to its reverse
		return normalized.equals(normalizedReverse);
	}

	/**
	 * Determines if name is a valid Java variable name. Variables names must start
	 * with a letter or an underscore, but cannot be an underscore alone. The rest
	 * of the variable name may consist of letters, numbers and underscores.
	 *
	 * @param name a string to test as a Java variable name
	 * @return true if name is a valid Java variable name, false otherwise
	 */
	public static boolean isValid(final String name) {
		// Initialize isValid to false. This will be updated based on checks.
		boolean isValid = false;
		// Get the first character of the variable name
		char firstCharacter = name.charAt(0);
		/*
		 * If the name is just an underscore, isValid is false If the name is blank,
		 * isValid is false If the character is not a letter or an underscore it is
		 * invalid Else we can assume it's valid
		 */
		if (name == "_") {
			isValid = false;
		} else if (name.isBlank()) {
			isValid = false;
		} else if (!Character.isLetter(firstCharacter) && firstCharacter != '_') {
			isValid = false;
		} else {
			isValid = true;
		}
		// Return
		return isValid;
	}

	/**
	 * Converts a word to Pig Latin. The conversion is:
	 * <ul>
	 * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
	 * <li>if the word begins with consonants, move the leading consonants to the
	 * end of the word and add "ay" to the end of that. "y" is treated as a
	 * consonant if it is the first character in the word, and as a vowel for
	 * anywhere else in the word.</li>
	 * </ul>
	 * Preserve the case of the word - i.e. if the first character of word is
	 * upper-case, then the new first character should also be upper case.
	 *
	 * @param word The string to convert to Pig Latin
	 * @return the Pig Latin version of word
	 */
	public static String pigLatin(String word) {
		// Create a StringBuilder to construct the resulting string
		StringBuilder sb = new StringBuilder();
		// Get the first character of the word
		char firstLetter = word.charAt(0);
		// Initialize a boolean flag to check if the first letter is uppercase
		boolean capitalize = Character.isUpperCase(firstLetter);
		// Check if the first letter is a vowel (defined in VOWELS)
		// If it is, append the original word followed by "way"
		if (VOWELS.indexOf(firstLetter) != -1) {
			sb.append(word);
			sb.append("way");
		} else {
			// If the first letter in the original was a capital, keep the case
			if (capitalize) {
				// Append the first letter
				sb.append(firstLetter);
				// Capitalize what's going to be the new first letter
				sb.append(word.substring(1, 2).toUpperCase());
				// Append the rest of the word
				sb.append(word.substring(2));
				// Handle the case at the end of the list
				sb.append(Character.toLowerCase(firstLetter));
				// Append "ay" to the end
				sb.append("ay");
				// Remove the original first letter
				sb.deleteCharAt(0);
			} else {
				// Append the original word
				sb.append(word);
				// Append the first letter to the end (move the consonant to the end)
				sb.append(firstLetter);
				// Append "ay" suffix to the end
				sb.append("ay");
				// Delete the original first letter
				sb.deleteCharAt(0);
			}
		}
		// Return
		return sb.toString();
	}

}
