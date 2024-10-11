package cp213;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Arrays Lab task methods.
 *
 * @author Mohammad El-Hassan, 169067950, elha7950@mylaurier.ca, @mohammadelhsn
 * @version 2022-01-25
 */
public class ArraysTest {
    /**
     * Default constructor for the Arraystest class
     *
     *
     */
    public ArraysTest() {

    }

    /**
     * Tests arrays.
     *
     * @param args unused default parameter
     */
    public static void main(final String[] args) {
	System.out.println("Task 1");
	System.out.println(ArraysTest.task1());
	System.out.println("Task 2");
	System.out.println(ArraysTest.task2());
	System.out.println("Task 3");
	System.out.println(ArraysTest.task3());
	System.out.println("Task 4");
	System.out.println(ArraysTest.task4());
	System.out.println("Task 5");
	System.out.println(Arrays.toString(ArraysTest.task5()));
    }

    /**
     * Print the contents of the arrays first and second using a standard for loop.
     *
     * @return true if second contains the same values as first, false otherwise
     */
    public static boolean task1() {
	final int[] first = { 1, 3, 5, 7, 9 };
	final int[] second = first;

	System.out.println("Values in first:");

	for (int i = 0; i < first.length; i++) {
	    System.out.println(first[i]);
	}
	System.out.println("Values in second:");

	for (int i = 0; i < second.length; i++) {
	    System.out.println(second[i]);
	}

	return true;
    }

    /**
     * Double the contents of the array first with a standard for loop.
     *
     * @return true if second contains the same values as first, false otherwise
     */
    public static boolean task2() {
	final int[] first = { 1, 3, 5, 7, 9 };
	final int[] second = first;

	for (int i = 0; i < first.length; i++) {
	    first[i] = first[i] * 2;
	}

	for (int i = 0; i < second.length; i++) {
	    System.out.println(second[i]);
	}

	return true;
    }

    /**
     * Double the contents of the array first with an enhanced for loop.
     *
     * @return true if the values in first are permanently changed, false otherwise
     */
    public static boolean task3() {
	final int[] first = { 1, 3, 5, 7, 9 };

	// Use a enhanced for loop to double the values.
	for (int i : first) {
	    i = i * 2; // Double the value at index i
	}

	// Now check if the values have changed
	boolean valueChanged = true; // Assume values have changed
	for (int i = 0; i < first.length; i++) {
	    // Expected value is (original value * 2)
	    if (first[i] != (i + 1) * 2) {
		valueChanged = false; // If any value doesn't match, set to false
		break; // Exit the loop early if a mismatch is found
	    }
	}

	return valueChanged; // Return the result of the comparison
    }

    /**
     * Attempt to assign the array first to a row of the 2D array third.
     *
     * @return true if this is allowed, false otherwise
     */
    public static boolean task4() {
	final int[] first = { 1, 3, 5, 7, 9 };
	final int[][] third = { { 1 }, { 0, 0, 0, 0, 0 } }; // Adjust the size of the second row to fit 'first'

	// Check if we can assign 'first' to the second row of 'third'
	if (third.length > 1 && third[1].length >= first.length) {
	    // Assign 'first' to the second row of 'third'
	    for (int i = 0; i < first.length; i++) {
		third[1][i] = first[i]; // Assign values from 'first' to the second row of 'third'
	    }
	    return true; // Assignment was successful
	} else {
	    return false; // Not allowed, row does not exist or is too small
	}
    }

    /**
     * Assign the values 0 through 9 to an Integer ArrayList.
     *
     * @return the contents of the ArrayList as an Integer[] array.
     */
    public static Integer[] task5() {
	final ArrayList<Integer> values = new ArrayList<>();

	// Add values 0 through 9 to the ArrayList
	for (int i = 0; i < 10; i++) {
	    values.add(i); // Add integers 0 to 9
	}

	// Convert the ArrayList to an Integer[] array
	return values.toArray(new Integer[0]); // Converts ArrayList to Integer array

    }
}
