/**
 * Represents a book with attributes commonly used to define and categorize
 * books in a library or a collection. Instances of this class are immutable.
 *
 * @author Anna Scribner
 * @version 22 May 2025
 *
 * @param isbn            The International Standard Book Number (ISBN) that uniquely
 *                        identifies the book.
 * @param authors         A string containing the names of the author(s) of the book. It
 *                        may represent a single author or a list of authors separated
 *                        by a delimiter.
 * @param publicationYear The year the book was published. Represented as an integer.
 * @param origTitle       The original title of the book, which can be used in cases
 *                        where the book's title has been localized or translated.
 * @param title           The title of the book.
 * @param averageRating   The average rating of the book, typically based on user
 *                        reviews or ratings. Represented as a double value.
 */
public record Book(String isbn, String authors, int publicationYear, String origTitle, String title,
                   double averageRating) {

    /**
     * Returns a string representation of the book object, containing its attributes
     * formatted readably. The representation includes the ISBN, authors,
     * publication year, original title, title, and average rating of the book.
     *
     * @return A string representation of the book object, including its ISBN, authors,
     * publication year, original title, title, and average rating
     */
    public String toString() {
        return String.format("ISBN: %s - " +
                "AUTHORS: %s - " +
                "PUBLICATION YEAR: %d - " +
                "ORIGINAL TITLE: %s - " +
                "TITLE: %s - " +
                "AVERAGE RATING: %.2f.", isbn, authors, publicationYear, origTitle, title, averageRating);
    }

}
