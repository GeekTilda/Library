import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //Library library = new Library();
        //library.start();
        File server = null;
        try {
            server = new File("Server.txt");
        } catch (Exception e) {
            System.out.println("Didnt work");
        }
        FileWriter writer = new FileWriter(server, true);
        //writer.write("Hej");
        //writer.write("då");


        Book book = new Book(new Author("Anna",47),"52 Fjärilar",52,new Date());
        book.addGenre(Genre.HORROR);
        book.addGenre(Genre.COMEDY);
        //writer.write("\n" + "Name:" + book.getName() + " Pages:" + book.getPages() + " Genres:" + book.getGenres() + " Author:" + book.getAuthor() + " Date:" + book.getDate() + " Borrowed:" + book.getBorrowed());
        writer.close();
        Scanner scanner = new Scanner(server);
        ArrayList<String> text = new ArrayList<String>();
        String vadsomhelst = scanner.nextLine();
        while (scanner.hasNextLine()) {
            String hej = scanner.next();
            text.add(hej);
            //System.out.println(hej);
        }
        String[] seperator = vadsomhelst.trim().split("[.]");
        for (String i : seperator) {
            System.out.println(i);
        }
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


}