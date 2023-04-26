import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

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

    public static void bookStartup(File server, Library library) throws FileNotFoundException {
        Scanner scanner = new Scanner(server);
        if (server.length() == 0) {
            System.out.println("File is empty!");
        } else {
            while (scanner.hasNextLine()) {
                String book = scanner.nextLine();
                String[] seperator = book.trim().split("[\\s+]");
                Author author = new Author(findSomething("Name:", seperator),Integer.parseInt(findSomething("Age:", seperator)));
                String[] seperator2 = book.trim().split(";");
                String genres = seperator2[5];
                genres = "" + genres.substring(1,genres.length() - 1) + "";
                String[] seperator3 = genres.trim().split(", ");
                Book book1 = new Book(author,findSomething("Name",seperator2),Integer.parseInt(findSomething("Pages",seperator2)), findSomething("date", seperator2));
                for (String s: seperator3) {
                    try {
                        Genre genre = Genre.valueOf(s);
                        book1.addGenre(genre);
                    } catch (IllegalArgumentException e) {
                    }
                }
                Boolean borrowed = Boolean.valueOf(findSomething("Borrowed",seperator2));
                book1.setBorrowed(borrowed);
                library.addBook(book1);
            }
            library.browseBooks();
        }
    }

    public static String findSomething(String something, String[] seperator) {
        for (int i = 0; i < seperator.length; i++) {
            if (something.equalsIgnoreCase(seperator[i])) {
                return seperator[i+1];
            }
        }
        return "Doesnt exist";
    }
}
