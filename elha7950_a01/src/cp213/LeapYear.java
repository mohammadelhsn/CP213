package cp213;

/**
 * LeapYear class
 *
 * @author Mohammad El-Hassan, 169067950, elha7950@mylaurier.ca, @mohammadelhsn
 * @version 2024-09-29
 */
public class LeapYear {
    /**
     * Default Constructor for the LeapYear class
     */
    public LeapYear() {

    }

    /**
     * Determines whether or not a year is a leap year.
     *
     * A leap year is defined as:
     *
     * "Every year that is exactly divisible by four is a leap year, except for
     * years that are exactly divisible by 100, but these centurial years are leap
     * years if they are exactly divisible by 400. For example, the years 1700,
     * 1800, and 1900 are not leap years, but the years 1600 and 2000 are." (United
     * States Naval Observatory)
     *
     * Thus 1996, 2000, and 2004 are leap years, but 1899, 1900, and 1901 are not
     * leap years."
     *
     * @param year The year to test (int greater than 0)
     * @return true if year is a leap year, false otherwise.
     */
    public static boolean isLeapYear(final int year) {
        // Initialize the result as `false`. We assume the year is not a leap year
        // initially.
        boolean result = false;
        /*
         * If the year is divisible by 100 (century year) ad also divisible by 400, it
         * is a leap year If the year is not a century year, check if it is divisible by
         * 4 Else is not needed because it is assumed false unless it satisfies the
         * conditions.
         */
        if ((year % 100) == 0) {
            result = (year % 400) == 0;
        } else if ((year % 4) == 0) {
            result = true;
        }
        // Return
        return result;
    }

}
