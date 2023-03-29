import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<Author> authorList = new ArrayList<>();
    private ArrayList<Customer> customerList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Customer customer = new Customer("Tilda", 18, "12345", "GeekTilda");

    public Library() {

    }

    public void start() {
        login();
    }

    public Boolean login() {
        customerList.add(customer);
        System.out.println("Whats your username? ");
        String username = scanner.nextLine();
        if (!userExist(username)) {
            System.out.println("User doesnt exist!");
            return false;
        }
        System.out.println("Username found");
        System.out.println("Whats your password? ");
        String password = scanner.nextLine();
        if (!passExist(username,password)) {
            System.out.println("Wrong password!");
            return false;
        }
        System.out.println("Correct password");
        return true;
    }

    public Boolean register() {
        System.out.println("Whats your real name? ");
        String name = scanner.nextLine();
        System.out.println("Whats your age? ");
        int age = scanner.nextInt();
        System.out.println("Whats your username? ");
        String username = scanner.nextLine();
        for (Customer c : customerList) {
            if (userExist(username)) {
                System.out.println("Username already exists!");
                return false;
            }
        }
        System.out.println("Username available!");
        System.out.println("Whats your password? ");
        String password = scanner.nextLine();
        Customer customer = new Customer(name,age,password,username);
        customerList.add(customer);
        return true;
    }

    public Boolean userExist(String username) {
        for (Customer c : customerList) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public Boolean passExist(String username, String password) {
        for (Customer c : customerList) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                if (c.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
