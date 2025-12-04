import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Anna Scribner
 * @version May 22, 2025
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        TreeMap<String, String> phoneNumbers = new TreeMap<>();
        phoneNumbers.put("Gustavo", "345-543-764");
        phoneNumbers.put("Anna", "345-765-876");
        phoneNumbers.put("Kelvin", "987-546-987");
        phoneNumbers.put("Marco", "456-654-987");
        phoneNumbers.put("Marco", "234-456-678");

        System.out.printf("You have %d people in your Phone Number list.\n", phoneNumbers.size());
        System.out.printf("Anna's phone number is: %s\n", phoneNumbers.get("Anna"));
        phoneNumbers.clear();
        System.out.printf("Now your list is cleaned. Size = %d\n\n", phoneNumbers.size());

        TreeMap<String, Book> libraryOfAlexandria = new TreeMap<>();

        File file = new File("BooksDataFile.txt");
        Scanner readFile = new Scanner(file);
        readFile.nextLine(); // skip header

        while (readFile.hasNext()) {
            String line = readFile.nextLine();
            String[] parts = line.split("~");

            Book bookInfo = new Book(
                    parts[2],
                    parts[3],
                    Integer.parseInt(parts[4]),
                    parts[5], parts[6],
                    Double.parseDouble(parts[7])
            );
            libraryOfAlexandria.put(bookInfo.isbn(), bookInfo);
        }

        System.out.printf("The Library Of Alexandria has %,d books.\n", libraryOfAlexandria.size());
        boolean doesContainBook = libraryOfAlexandria.containsKey("0316160199");
        System.out.printf("Library contains the ISBN '0316160199': %b\n", doesContainBook);
        Book book = libraryOfAlexandria.get("0316160199");
        System.out.printf("The ISBN '0316160199' holds the book: %s\n", book);

        System.out.println();
        doesContainBook = libraryOfAlexandria.containsKey("0316");
        System.out.printf("Library contains the ISBN '0316': %b\n", doesContainBook);
        book = libraryOfAlexandria.get("0316");
        System.out.printf("The ISBN '0316' holds the book: %s\n", book);

        System.out.println();
        System.out.println("Oh no! Enemies are coming to set the library on fire!!!!!!!!!!");
        libraryOfAlexandria.clear();

        System.out.printf("Now the library is gone :(\nSize: %d", libraryOfAlexandria.size());
    }
}