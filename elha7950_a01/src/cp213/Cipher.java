package cp213;

/**
 * Cipher class including methods
 *
 * @author Mohammad El-Hassan, 169067950, elha7950@mylaurier.ca, @mohammadelhsn
 * @version 2024-09-29
 */
public class Cipher {
    /**
     * Default constructor for the Cipher class.
     */
    public Cipher() {

    }

    // Constants
    /**
     * A string containing all the letters in the alphabet
     */
    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * Length of the string containing all the letters
     */
    public static final int ALPHA_LENGTH = ALPHA.length();

    /**
     * Encipher a string using a shift cipher. Each letter is replaced by a letter
     * 'n' letters to the right of the original. Thus for example, all shift values
     * evenly divisible by 26 (the length of the English alphabet) replace a letter
     * with itself. Non-letters are left unchanged.
     *
     * @param s string to encipher
     * @param n the number of letters to shift
     * @return the enciphered string in all upper-case
     */
    public static String shift(final String s, final int n) {

	// Initialize an empty string to store the result of the enciphered text
	String enciphered = "";
	// Split the input string `s` into individual characters (each stored as a
	// string)
	String[] toEncipher = s.split("");
	// Loop through each character in to `toEncipher` array
	for (int i = 0; i < toEncipher.length; i++) {
	    // Get the current letter.
	    String letter = toEncipher[i];
	    // Find the index of the current letter in the alphabet string (ALPHA) and add
	    // `n` to shift it
	    int newLetterIndex = ALPHA.indexOf(letter) + n;
	    // If the new index goes beyond 26 (end of the alphabet), wrap it back to the
	    // beginning
	    if (newLetterIndex > 26) {
		// The modulo operator (%) ensures the index stays within the range of 1-26
		newLetterIndex = (newLetterIndex) % 26;
	    }
	    // Add the shifted letter to the `enciphered` string
	    enciphered += ALPHA.charAt(newLetterIndex);
	}
	// Return
	return enciphered;
    }

    /**
     * Encipher a string using the letter positions in ciphertext. Each letter is
     * replaced by the letter in the same ordinal position in the ciphertext.
     * Non-letters are left unchanged. Ex:
     *
     * <pre>
    Alphabet:   ABCDEFGHIJKLMNOPQRSTUVWXYZ
    Ciphertext: AVIBROWNZCEFGHJKLMPQSTUXYD
     * </pre>
     *
     * A is replaced by A, B by V, C by I, D by B, E by R, and so on. Non-letters
     * are ignored.
     *
     * @param s          string to encipher
     * @param ciphertext ciphertext alphabet
     * @return the enciphered string in all upper-case
     */
    public static String substitute(final String s, final String ciphertext) {
	// Initialize an empty string to store the result of the enciphered text
	String enciphered = "";
	// Split the input string `s` into individual characters (each stored as a
	// string)
	String[] letters = s.split("");
	// Loop through each character in the `letters` array
	for (int i = 0; i < letters.length; i++) {
	    // Convert the current letter to uppercase to ensure consistency
	    String letter = letters[i].toUpperCase();
	    // Find the index of the current letter in the alphabet string (ALPHA)
	    int index = ALPHA.indexOf(letter);
	    // Use the index to find the corresponding letter in the ciphertext string
	    enciphered += ciphertext.charAt(index);
	}
	// Return
	return enciphered;
    }

}
