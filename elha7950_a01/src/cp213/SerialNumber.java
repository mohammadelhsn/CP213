package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Your name and id here
 * @version 2024-09-01
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {

        char[] characters = str.toCharArray();
        boolean isAllDigits = true;

        for (char c : characters) {
            if (!Character.isDigit(c)) {
                isAllDigits = false;
                break;
            }
        }

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
        boolean isValid = false;
        String part1_expected = "SN/";
        String part3_expected = "-";
        boolean part1_valid = false;
        boolean part2_valid = false;
        boolean part3_valid = false;
        boolean part4_valid = false;

        if (sn.length() != 11) {
            isValid = false;
        } else {
            String part1 = sn.substring(0, 3);
            String part2 = sn.substring(3, 7);
            String part3 = sn.substring(7, 8);
            String part4 = sn.substring(8);
            if (part1.equalsIgnoreCase(part1_expected)) {
                part1_valid = true;
            }
            if (SerialNumber.allDigits(part2)) {
                part2_valid = true;
            }
            if (part3.equals(part3_expected)) {
                part3_valid = true;
            }
            if (SerialNumber.allDigits(part4)) {
                part4_valid = true;
            }

            isValid = part1_valid && part2_valid && part3_valid && part4_valid;
        }

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

        // your code here

        while (fileIn.hasNextLine()) {
            String currentLine = fileIn.nextLine();
            if (SerialNumber.validSn(currentLine)) {
                goodSns.append(currentLine + "\n");
            } else {
                badSns.append(currentLine + "\n");
            }
        }

        goodSns.flush();
        badSns.flush();

        return;
    }

}
