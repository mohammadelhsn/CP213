package cp213;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utilities for working with Movie objects.
 *
 * @author Mohammad El-Hassan, 169067950, elha7950@mylaurier.ca, @mohammadelhsn
 * @version 2024-10-10
 */
public class MovieUtilities {

    /**
     * Default Constructor for the Movie utilities class.
     * 
     */
    public MovieUtilities() {

    }

    /**
     * Counts the number of movies in each genre given in Movie.GENRES. An empty
     * movies list should produce a count array of: [0,0,0,0,0,0,0,0,0,0,0]
     *
     * @param movies List of movies.
     * @return Number of genres across all Movies. One entry for each genre in the
     *         Movie.GENRES array.
     */
    public static int[] genreCounts(final ArrayList<Movie> movies) {
        // Initialize an array to count the number of movies in each genre.
        // Assuming there is 11 genres (0 through 10), all counts starts at 0.
        int[] genreCount = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        // Iterate through each movie in the 'movies' collection
        for (Movie movie : movies) {
            // Increment the count for the genre of the current movie.
            // The genre is accessed via movie.getGenre(), which returns an integer
            // representing the index
            genreCount[movie.getGenre()] = genreCount[movie.getGenre()] + 1;
        }
        // Return
        return genreCount;
    }

    /**
     * Creates a Movie object by requesting data from a user. Uses the format:
     *
     * <pre>
    Title:
    Year:
    Director:
    Rating:
    Genres:
    0: science fiction
    1: fantasy
    ...
    10: mystery
    
    Enter a genre number:
     * </pre>
     *
     * @param keyboard A keyboard (System.in) Scanner.
     * @return A Movie object.
     */
    public static Movie getMovie(final Scanner keyboard) {
        // Prompt the user to enter the movie's title and read the input as a string.
        System.out.print("Title: ");
        String title = keyboard.nextLine();
        // Prompt the user to enter the movie's year and convert the input into an
        // integer.
        System.out.print("Year: ");
        int year = Integer.parseInt(keyboard.nextLine());
        // Prompt the user to enter the movie's director and read the input as a string.
        System.out.print("Director ");
        String director = keyboard.nextLine();
        // Prompt the user to enter the movie's rating and convert the input to a
        // double.
        System.out.print("Rating: ");
        double rating = Double.parseDouble(keyboard.nextLine());
        // Call the readGenre method to prompt the user for a genre and return the
        // selected genre number.
        int genre = readGenre(keyboard);
        // Create a new Movie object with the provided title, year, director, rating,
        // and genre.
        Movie movie = new Movie(title, year, director, rating, genre);
        // Return the created Movie object.
        return movie;
    }

    /**
     * Creates a list of Movies whose genre is equal to the genre parameter.
     *
     * @param movies List of movies.
     * @param genre  Genre to compare against.
     * @return List of movies of genre.
     */
    public static ArrayList<Movie> getByGenre(final ArrayList<Movie> movies, final int genre) {
        // Initialize an empty list to hold movies that match the specified genre.
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        // Iterate through each movie in the provided list of movies.
        for (Movie movie : movies) {
            // If the genre of the current movie matches the specified genre, add it to the
            // movieList.
            if (movie.getGenre() == genre) {
                movieList.add(movie);
            }
        }
        // Return the list of movies that match the specified genre.
        return movieList;
    }

    /**
     * Creates a list of Movies whose ratings are equal to or higher than rating.
     *
     * @param movies List of movies.
     * @param rating Rating to compare against.
     * @return List of movies of rating or higher.
     */
    public static ArrayList<Movie> getByRating(final ArrayList<Movie> movies, final double rating) {
        // Initialize an empty list to hold movies that match or exceed the specified
        // rating.
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        // Iterate through each movie in the provided list of movies.
        for (Movie movie : movies) {
            // If the rating of the current movie is equal to or higher than the specified
            // rating, add it to movieList.
            if (movie.getRating() >= rating) {
                movieList.add(movie);
            }
        }
        // Return the list of movies that match or exceed the specified rating.
        return movieList;
    }

    /**
     * Creates a list of Movies from a particular year.
     *
     * @param movies List of movies.
     * @param year   Year to compare against.
     * @return List of movies of year.
     */
    public static ArrayList<Movie> getByYear(final ArrayList<Movie> movies, final int year) {
        // Initialize an empty list to hold movies released in the specified year.
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        // Iterate through each movie in the provided list of movies.
        for (Movie movie : movies) {
            // If the release year of the current movie matches the specified year, add it
            // to movieList.
            if (movie.getYear() == year) {
                movieList.add(movie);
            }
        }
        // Return the list of movies released in the specified year.
        return movieList;
    }

    /**
     * Asks a user to select a genre from a list of genres displayed by calling
     * Movie.genresMenu() and returns an integer genre code. The genre must be a
     * valid index to an item in Movie.GENRES.
     *
     * @param keyboard A keyboard (System.in) Scanner.
     * @return An integer genre code.
     */
    public static int readGenre(final Scanner keyboard) {
        // Display the list of genres by calling Movie.genresMenu().
        System.out.println("Genres ");
        System.out.println(Movie.genresMenu());
        // Prompt the user to enter a genre number.
        System.out.print("Enter a genre number: ");
        int genre = Integer.parseInt(keyboard.nextLine());
        // Check if the entered genre number is a valid index in the Movie.GENRES array.
        // If the number is out of range, print an error message and terminate the
        // program.
        if (genre < 0 || genre > Movie.GENRES.length) {
            System.out.println("Genre must be a valid index in the GENRES array");
            System.exit(-1);
        }
        // Return the valid genre code entered by the user.
        return genre;
    }

    /**
     * Creates and returns a Movie object from a line of formatted string data.
     *
     * @param line A vertical bar-delimited line of movie data in the format
     *             title|year|director|rating|genre
     * @return The data from line as a Movie object.
     */
    public static Movie readMovie(final String line) {
        // Split the input string by the "|" character to extract each piece of movie
        // information.
        String[] lineData = line.split("\\|");
        // Extract and assign the movie's title (first element in the array).
        String title = lineData[0];
        // Extract and convert the year (second element) to an integer.
        int year = Integer.parseInt(lineData[1]);
        // Extract and assign the director's name (third element).
        String director = lineData[2];
        // Extract and convert the rating (fourth element) to a double.
        double rating = Double.parseDouble(lineData[3]);
        // Extract and convert the genre code (fifth element) to an integer.
        int genre = Integer.parseInt(lineData[4]);
        // Create a new Movie object using the extracted details.
        Movie newMovie = new Movie(title, year, director, rating, genre);
        // Return the newly created Movie object.
        return newMovie;
    }

    /**
     * Reads a list of Movies from a file.
     *
     * @param fileIn A Scanner of a Movie data file in the format
     *               title|year|director|rating|genre
     * @return A list of Movie objects.
     */
    public static ArrayList<Movie> readMovies(final Scanner fileIn) {
        // Initialize an empty ArrayList to hold the Movie objects.
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        // Loop through each line in the file while there are still lines to read.
        while (fileIn.hasNextLine()) {
            // Read the next line from the file and pass it to the readMovie method
            // to create a Movie object, then add it to the movieList.
            movieList.add(readMovie(fileIn.nextLine()));
        }
        // Return the list of Movie objects created from the file.
        return movieList;
    }

    /**
     * Writes the contents of a list of Movie to a PrintStream.
     *
     * @param movies A list of Movie objects.
     * @param ps     Output PrintStream.
     */
    public static void writeMovies(final ArrayList<Movie> movies, PrintStream ps) {
        // Iterate through each Movie object in the 'movies' collection.
        for (Movie movie : movies) {
            // Call the write method of the Movie object, passing the PrintStream (ps) to
            // it.
            // This likely writes the details of each movie to the PrintStream, which could
            // be a file or console output.
            movie.write(ps);
        }
        // Return from the method (optional, as 'return' is not necessary in a void
        // method).
        return;
    }

}
