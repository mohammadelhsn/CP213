package cp213;

/**
 * Sample string methods.
 *
 * @author Mohammad El-Hassan, 169067950, and elha7950@mylaurier.ca
 * @version 2024-09-21
 */
public class StringMethods {

    /**
     * Default Constructor for the StringMethods class.
     */
    public StringMethods() {
    }

    // Constants
    /**
     * String of vowels.
     */
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Counts the number of vowels in a string. Does not include 'y'.
     *
     * @param string A string.
     * @return Number of vowels in string.
     */
    public static int vowelCount(final String string) {

        // Initialize a counter to keep track of the number of vowels.
        int count = 0;

        // If the string input is empty, set count to 0.
        // Else: Iterate through each word and letter in the array.

        if (string.length() == 0) {
            count = 0;
        } else {

            // Split the sentence string into words using space as a delimiter.
            String[] words = string.split(" ");

            // Iterate through each word in the array
            for (int i = 0; i < words.length; i++) {

                // Split each word into individual characters.
                String[] word = words[i].split("");

                // Iterate through each character in the word.
                for (int j = 0; j < word.length; j++) {

                    // Get the current character.
                    String letter = word[j];

                    // Check if the character is a vowel, if it is add one to the counter.
                    if (VOWELS.indexOf(letter) != -1) {
                        count += 1;
                    }
                }
            }
        }

        // Return.
        return count;
    }

    /**
     * Counts the number of digits in a string.
     *
     * @param string A string.
     * @return Number of digits in string.
     */
    public static int digitCount(final String string) {
        int count = 0;

        if (string.length() == 0) {
            count = 0;
        } else {
            String[] words = string.split(" ");

            for (int i = 0; i < words.length; i++) {
                String[] word = words[i].split("");
                for (int j = 0; j < word.length; j++) {
                    String letter = word[j];
                    char ch = letter.charAt(0);

                    if (Character.isDigit(ch)) {
                        count += 1;
                    }
                }

            }
        }
        return count;
    }

    /**
     * Totals the individual digits in a string.
     *
     * @param string A string.
     * @return The integer total of all individuals digits in string.
     */
    public static int totalDigits(final String string) {
        int total = 0;

        if (string.length() == 0) {
            total = 0;
        } else {
            String[] words = string.split(" ");

            for (int i = 0; i < words.length; i++) {
                String[] word = words[i].split("");
                for (int j = 0; j < word.length; j++) {
                    String letter = word[j];
                    char ch = letter.charAt(0);

                    if (Character.isDigit(ch)) {
                        total += Character.getNumericValue(ch);
                    }
                }

            }
        }

        return total;
    }

    /**
     * Compares string1 and string2 and returns a comma-delimited concatenated
     * string consisting of the string that is first lexically followed by the
     * string that is second lexically. If the strings are equal, then only string1
     * is returned.
     *
     * @param string1 String to compare against string2.
     * @param string2 String to compare against string1.
     * @return A concatenation of string1 and string2 in order.
     */
    public static String pairs(String string1, String string2) {
        String line = null;

        int result = string1.compareTo(string2);

        if (result == 0) {
            line = string1;
        } else if (result > 0) {
            line = String.format("%s,%s", string2, string1);
        } else {
            line = String.format("%s,%s", string1, string2);
        }

        return line;
    }

    /**
     * Finds the distance between the s1 and s2. The distance between two strings of
     * the same length is the number of positions in the strings at which their
     * characters are different. If two strings are not the same length, the
     * distance is unknown (-1). If the distance is zero, then two strings are
     * equal.
     *
     * @param string1 String to compare against string2.
     * @param string2 String to compare against string1.
     * @return The distance between string1 and string2.
     */
    public static int stringDistance(String string1, String string2) {
        int distance = 0;

        if (string1.length() != string2.length()) {
            distance = -1;
        } else if (string1.length() == 0) {
            distance = 0;
        } else if (string1.length() == 1) {
            if (string1.charAt(0) != string2.charAt(0)) {
                distance += 1;
            }
        } else {
            String[] words1 = string1.split(" ");
            String[] words2 = string2.split(" ");
            for (int i = 0; i < words1.length; i++) {
                String[] word1 = words1[i].split("");
                String[] word2 = words2[i].split("");
                for (int j = 0; j < word1.length; j++) {
                    String letter1 = word1[j];
                    String letter2 = word2[j];

                    if (letter1.charAt(0) != letter2.charAt(0)) {
                        distance += 1;
                    }
                }
            }
        }

        return distance;
    }
}
