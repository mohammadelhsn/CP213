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

        // Initialize a counter to keep track of the number of digits
        int count = 0;
        /*
         * Check if the input string is empty.
         * If the string is empty, set count to 0
         * Else Split the words, and then the word, then check if each letter is a digit
         */
        if (string.length() == 0) {
            count = 0;
        } else {
            // Split the input string into words using a space as a delimiter.
            String[] words = string.split(" ");
            // Iterate through each word in the array.
            for (int i = 0; i < words.length; i++) {
                // Split each word into individual characters.
                String[] word = words[i].split("");
                for (int j = 0; j < word.length; j++) {
                    // Get the current letter as a string
                    String letter = word[j];
                    // Convert the string to a character.
                    char ch = letter.charAt(0);
                    // Check if the character is a digit, if it is add to the counter.
                    if (Character.isDigit(ch)) {
                        count += 1;
                    }
                }
            }
        }
        // Return.
        return count;
    }

    /**
     * Totals the individual digits in a string.
     *
     * @param string A string.
     * @return The integer total of all individuals digits in string.
     */
    public static int totalDigits(final String string) {
        // Initialize a variable to hold the sum of all digit values
        int total = 0;
        /*
         * Check if the input string is empty.
         * If it is, set the total to 0
         * Else iterate through each word, and each letter in said word,
         * looking for a digit and adding it to the total.
         */
        if (string.length() == 0) {
            total = 0;
        } else {
            // Split the input string into words using a space as a delimiter.
            String[] words = string.split(" ");
            // Iterate through each word in the array.
            for (int i = 0; i < words.length; i++) {
                // Split the input string into individual characters.
                String[] word = words[i].split("");
                // Iterate through each character in the word
                for (int j = 0; j < word.length; j++) {
                    // Get the current character as a string.
                    String letter = word[j];
                    // Convert the string to a character.
                    char ch = letter.charAt(0);
                    // If the character is a digit, get the numeric value and add it to the total
                    if (Character.isDigit(ch)) {
                        total += Character.getNumericValue(ch);
                    }
                }
            }
        }
        // Return.
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
        // Initialize a variable to store the result string
        String line = null;
        // Compare string1 with string2 lexically.
        int result = string1.compareTo(string2);
        /*
         * If the strings are equal, set the line to string1 only.
         * If string1 is lexically greater than string2, concatenate them as:
         * (string2,string1)
         * Else string2 is lexically less than string2, concatenate them as:
         * (string1,string2)
         */
        if (result == 0) {
            line = string1;
        } else if (result > 0) {
            line = String.format("%s,%s", string2, string1);
        } else {
            line = String.format("%s,%s", string1, string2);
        }
        // Return.
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
        // Initialize the distance counter to 0
        int distance = 0;

        /*
         * If the length of the two strings are not equal, return -1 as the distance
         * If both the strings are empty, the distance is 0 (they are equal)
         * If both strings have only one character, compare the characters directly.
         * Else loop through each word in the sentence and each letter in that word and
         * compare them. If they're not the same, add 1 to the difference.
         */
        if (string1.length() != string2.length()) {
            distance = -1;
        } else if (string1.length() == 0) {
            distance = 0;
        } else if (string1.length() == 1) {
            if (string1.charAt(0) != string2.charAt(0)) {
                distance += 1;
            }
        } else {
            // Split each string into words based on spaces
            String[] words1 = string1.split(" ");
            String[] words2 = string2.split(" ");
            // Iterate over each word in both arrays
            for (int i = 0; i < words1.length; i++) {
                // Split each word in both arrays
                String[] word1 = words1[i].split("");
                String[] word2 = words2[i].split("");
                // Iterate through each character in the current words.
                for (int j = 0; j < word1.length; j++) {
                    String letter1 = word1[j];
                    String letter2 = word2[j];
                    // If the characters are different, increment the distance counter.
                    if (letter1.charAt(0) != letter2.charAt(0)) {
                        distance += 1;
                    }
                }
            }
        }
        // Return.
        return distance;
    }
}
