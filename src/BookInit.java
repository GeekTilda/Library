import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
*   Initializes the books in Server.txt file
*/

public class BookInit {
    private File server;
    private Library library;

    public BookInit(File server, Library library) throws FileNotFoundException {
        this.server = server;
        this.library = library;
        start();
    }

    public void start() throws FileNotFoundException {
        bookStartup(server,library);
    }

    /*
     *  Checks the lines of our Server.txt file. (If it is empty or not)
     *  If it isnt empty: Splits the lines and creates books.
     */
    public static void bookStartup(File server, Library library) throws FileNotFoundException {
        Scanner scanner = new Scanner(server);
        if (server.length() == 0) {
            System.out.println("File is empty!");
        } else {
            while (scanner.hasNextLine()) {
                String book = scanner.nextLine();
                String[] seperator = book.trim().split("[\\s+]"); //Splits at each space
                Author author = new Author(findSomething("Name:", seperator),Integer.parseInt(findSomething("Age:", seperator)));
                String[] seperator2 = book.trim().split(";"); //Splits at ;
                String genres = seperator2[5]; //We know that genres always is at 6th splitted line
                genres = "" + genres.substring(1,genres.length() - 1) + ""; //Takes away first and last char of the string and replaces them to nothing.
                String[] seperator3 = genres.trim().split(", ");
                Book book1 = new Book(author,findSomething("Name",seperator2),Integer.parseInt(findSomething("Pages",seperator2)), findSomething("date", seperator2));
                for (String s: seperator3) { //Goes through all genres in a string, and makes them into ENUM.
                    try {
                        Genre genre = Genre.valueOf(s); //Compares to our already existing enum and makes a new.
                        book1.addGenre(genre);
                    } catch (IllegalArgumentException e) {
                    }
                }
                Boolean borrowed = Boolean.valueOf(findSomething("Borrowed",seperator2)); //Finds a boolean for if it is borrowed or not
                book1.setBorrowed(borrowed);
                library.addBook(book1);
            }
            //library.browseBooks();
        }
    }

    /*
     *  something = what we are looking for
     *  seperator = where something is located
     */
    public static String findSomething(String something, String[] seperator) {
        for (int i = 0; i < seperator.length; i++) {
            if (something.equalsIgnoreCase(seperator[i])) {
                return seperator[i+1];
            }
        }
        return "Doesnt exist";
    }
}
