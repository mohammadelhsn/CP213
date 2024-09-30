package cp213;

/**
 * Numbers class including several methods
 *
 * @author Mohammad El-Hassan, 169067950, elha7950@mylaurier.ca, @mohammadelhsn
 * @version 2024-09-29
 */
public class Numbers {
    /**
     * Default Constructor for the Numbers class.
     */
    public Numbers() {

    }

    /**
     * Determines closest value of two values to a target value.
     *
     * @param target the target value
     * @param v1     first comparison value
     * @param v2     second comparison value
     * @return one of v1 or v2 that is closest to target, v1 is the value chosen if
     *         v1 and v2 are an equal distance from target
     */
    public static double closest(final double target, final double v1, final double v2) {
	// Initialize a variable to store the result (the closest value)
	double result = 0.0;
	// Calculate the absolute difference (distance) between target and v1.
	double distance1 = Math.abs(target - v1);
	// Calculate the absolute difference (distance) between target and v2.
	double distance2 = Math.abs(target - v2);
	// Compare the two distances
	// If v2 is closer to the target, assign v2 to the result
	// If v1 is closer (or equal distance), assign v1 to the result
	if (distance1 > distance2) {
	    result = v2;
	} else {
	    result = v1;
	}
	// Return
	return result;
    }

    /**
     * Determines if n is a prime number. Prime numbers are whole numbers greater
     * than 1, that have only two factors - 1 and the number itself. Prime numbers
     * are divisible only by the number 1 or itself.
     *
     * @param n an integer
     * @return true if n is prime, false otherwise
     */
    public static boolean isPrime(final int n) {
	// Assume n is prime initially
	boolean isPrime = true;
	// If n is 0 or a negative number, it is not a prime number
	if (n <= 1) {
	    isPrime = false;
	} else {
	    // Start checking divisibility from 1 to n
	    int i = 1;
	    // Loop to check for divisors of n
	    while (i <= n && isPrime) {
		// Check if i divides n with no remainder (i is a factor of n)
		if ((n % i == 0)) {
		    // If i is neither 1 or n, then n is not prime.
		    if (i != n && i != 1) {
			isPrime = false;
		    }
		}
		// Move to the next number to check.
		i++;
	    }
	}
	// Return
	return isPrime;
    }

    /**
     * Sums and returns the total of a partial harmonic series. This series is the
     * sum of all terms 1/i, where i ranges from 1 to n (inclusive). Ex:
     *
     * n = 3: sum = 1/1 + 1/2 + 1/3 = 1.8333333333333333
     *
     * @param n an integer
     * @return sum of partial harmonic series from 1 to n
     */
    public static double sumPartialHarmonic(final int n) {
	// Initialize a variable to store the sum of a partial harmonic series
	double sumPartialH = 0.0;
	// Loop from 1 to n (inclusive)
	for (int i = 1; i <= n; i++) {
	    // Add the reciprocal of i (1/i) to the sum
	    sumPartialH += (1.0 / i);
	}
	// Return the sum of the harmonic series up to n
	return sumPartialH;
    }
}
