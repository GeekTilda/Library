import java.io.*;
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
        writer.write("Hej");
        writer.write("då");
        writer.close();
        Scanner scanner = new Scanner(server);
        while (scanner.hasNextLine()) {
            String hej = scanner.next();
            System.out.println(hej);
        }
    }
    public Boolean fileExist(File server) {
        if (server.exists()) {
            return true;
        }
        else {
            File file = new File("Server.txt");
            return false;
        }
    }
}