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

        int[] genreCount = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        for (Movie movie : movies) {
            genreCount[movie.getGenre()] = genreCount[movie.getGenre()] + 1;
        }

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

        System.out.print("Title: ");
        String title = keyboard.nextLine();
        System.out.print("Year: ");
        int year = Integer.parseInt(keyboard.nextLine());
        System.out.print("Director ");
        String director = keyboard.nextLine();
        System.out.print("Rating: ");
        double rating = Double.parseDouble(keyboard.nextLine());
        int genre = readGenre(keyboard);

        Movie movie = new Movie(title, year, director, rating, genre);

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

        ArrayList<Movie> movieList = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.getGenre() == genre) {
                movieList.add(movie);
            }
        }

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

        ArrayList<Movie> movieList = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.getRating() >= rating) {
                movieList.add(movie);
            }
        }

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
        ArrayList<Movie> movieList = new ArrayList<Movie>();

        for (Movie movie : movies) {
            if (movie.getYear() == year) {
                movieList.add(movie);
            }
        }

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
        System.out.println("Genres ");
        System.out.println(Movie.genresMenu());
        System.out.print("Enter a genre number: ");
        int genre = Integer.parseInt(keyboard.nextLine());
        if (genre < 0 || genre > Movie.GENRES.length) {
            System.out.println("Genre must be a valid index in the GENRES array");
            System.exit(-1);
        }
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
        String[] lineData = line.split("\\|");
        String title = lineData[0];
        int year = Integer.parseInt(lineData[1]);
        String director = lineData[2];
        double rating = Double.parseDouble(lineData[3]);
        int genre = Integer.parseInt(lineData[4]);
        Movie newMovie = new Movie(title, year, director, rating, genre);
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

        ArrayList<Movie> movieList = new ArrayList<Movie>();

        while (fileIn.hasNextLine()) {
            movieList.add(readMovie(fileIn.nextLine()));
        }

        return movieList;
    }

    /**
     * Writes the contents of a list of Movie to a PrintStream.
     *
     * @param movies A list of Movie objects.
     * @param ps     Output PrintStream.
     */
    public static void writeMovies(final ArrayList<Movie> movies, PrintStream ps) {

        for (Movie movie : movies) {
            movie.write(ps);
        }

        return;
    }

}
