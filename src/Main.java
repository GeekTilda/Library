import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Library library = new Library();
        //library.start();
        File server = null;
        try {
            server = new File("Server.txt");
        } catch (Exception e) {
            System.out.println("Didnt work");
        }
        FileWriter writer = new FileWriter(server, true);

        bookStartup(server, library);
        //writer.write("Hej");
        //writer.write("då");

        /*
        Book book = new Book(new Author("Anna",47),"52 Fjärilar",52,new Date());
        book.addGenre(Genre.HORROR);
        book.addGenre(Genre.COMEDY);
        //writer.write("\n" + "Name;" + book.getName() + ";Pages;" + book.getPages() + ";Genres;" + book.getGenres() + ";Author;" + book.getAuthor() + ";Date;" + book.getDate() + ";Borrowed;" + book.getBorrowed());
        writer.close();
        Scanner scanner = new Scanner(server);
        String vadsomhelst = scanner.nextLine();
        while (scanner.hasNextLine()) {
            String hej = scanner.next();
            //System.out.println(hej);
        }
        String[] seperator = vadsomhelst.trim().split(";");
        for (String i : seperator) {
            System.out.println(i);
        }
        //System.out.println(findSomething("dat",seperator));
        //bookStartup(server);

         */
    }
    public Boolean fileExist(File customers, File books) {
        if (customers.exists() && books.exists()) {
            return true;
        }
        else if (customers.exists() && !books.exists()){
            File file = new File("Books.txt");
            return false;
        } else if (!customers.exists() && books.exists()) {
            File file = new File("Customers.txt");
            return false;
        } else {
            File file = new File("Books.txt");
            File file2 = new File("Customers.txt");
            return false;
        }
    }
    public static String findSomething(String something, String[] seperator) {
        for (int i = 0; i < seperator.length; i++) {
            if (something.equalsIgnoreCase(seperator[i])) {
                return seperator[i+1];
            }
            if(something.equalsIgnoreCase("author") && something.equalsIgnoreCase(seperator[i])) {
                String author = seperator[i+1];
                //String[] splitter = author.split([])
                //return new Author()
            }
        }
        return "Doesnt exist";
    }
    public static void bookStartup(File server, Library library) throws FileNotFoundException {
        Scanner scanner = new Scanner(server);
        if (server.length() == 0) {
            System.out.println("File is empty!");
        } else {
            while (scanner.hasNextLine()) {
                String book = scanner.nextLine();
                String[] seperator = book.trim().split("[\\s+]");
                //for(String s : seperator) {
                //    System.out.println(s);
                //}
                System.out.println(findSomething("pages",seperator));
                //Author author = new Author(findSomething("Name:", seperator),Integer.parseInt(findSomething("Age:", seperator)));
                //library.addBook(new Book(author,findSomething("Name",seperator),Integer.parseInt(findSomething("Pages",seperator)), findSomething("date", seperator)));

                //library.browseBooks();
            }
        }
    }
}