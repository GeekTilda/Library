import java.io.*;

public class Main {
    /*
    *   Initiate server and library
    */
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
}