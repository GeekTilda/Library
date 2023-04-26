import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File server = null;
        try {
            server = new File("Server.txt");
        } catch (Exception e) {
            System.out.println("Didnt work");
        }
        Library library = new Library(server);
        library.start();

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