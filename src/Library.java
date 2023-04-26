import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Library {

    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<Author> authorList = new ArrayList<>();
    private ArrayList<Customer> customerList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Customer customer = new Customer("Tilda", 18, "12345", "GeekTilda");
    int login = 1;
    File server;
    public Library(File server) {
        this.server = server;
    }

    public void start() throws IOException {
        new BookInit(server,this);
        loginRegister();
    }

    public void loginRegister() throws IOException {
        while (login == 1) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Browse books");
            System.out.println("4. Exit");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
            }

            if (choice == 1) {
                login();
                //break;
            } else if (choice == 2) {
                register();
                //break;
            } else if (choice == 3) {
                browseBooks();
            } else if (choice == 4) {
                System.exit(0);
            } else {
                scanner.next();
                System.out.println("Write number! (1-4)");
            }
        }
    }

    public void mainMenu(Customer customer) throws IOException { // test
        while (login == 2) {
            System.out.println("1. Browse books");
            System.out.println("2. My borrowed books");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Log out");
            System.out.println("6. Exit");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
            }
            if (choice == 1) {
                browseBooks();
            } else if (choice == 2) {
                System.out.println(customer.writeBorrowedBooks());
            } else if (choice == 3) {
                borrowBook(customer);
            } else if (choice == 4) {
                customer.removeBook(bookName());
            } else if (choice == 5) {
                login = 1;
                loginRegister();
            } else if (choice == 6) {
                save();
                System.exit(0);
            } else {
                scanner.next();
                System.out.println("Write number! (1-6)");
            }
        }
    }

    public Boolean login() throws IOException {
        customerList.add(customer); //ONLY FOR TESTING. Tilda, 18, 12345, GeekTilda
        System.out.println("Whats your username? ");
        String username = scanner.next();
        if (!userExist(username)) {
            System.out.println("User doesnt exist!");
            return false;
        }
        Customer cus = getCustomer(username);
        System.out.println("Username found");
        System.out.println("Whats your password? ");
        String password = scanner.next();
        if (passExist(username,password)) {
            System.out.println("Correct password");
            login = 2;
            mainMenu(customer); //CHANGE
        }
        if (!passExist(username,password)) {
            System.out.println("Wrong password!");
            System.out.println("1. Forgot password? ");
            System.out.println("2. Try again");
            int i = 0;
            try {
                i = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Write number! (1-2)");
            }
            if (i == 1) {
                System.out.println("Write new password: ");
                String newPassword = scanner.next();
                customer.setPassword(newPassword); //CHANGE
                System.out.println(newPassword);
                mainMenu(customer); //CHANGE
            } else {
                return false;
            }
        }
        return true;
    }

    public Boolean register() throws IOException {
        System.out.println("Whats your real name? ");
        scanner.next();
        String name = scanner.next();
        System.out.println("Whats your age? ");
        int age = scanner.nextInt();
        System.out.println("Whats your username? ");
        String username = scanner.next();
        for (Customer c : customerList) {
            if (userExist(username)) {
                System.out.println("Username already exists!");
                login = 1;
                return false;
            }
        }
        System.out.println("Username available!");
        System.out.println("Whats your password? ");
        String password = scanner.next();
        Customer customer = new Customer(name,age,password,username);
        customerList.add(customer);
        System.out.println("Account created!");
        login = 2;
        mainMenu(customer);
        return true;
    }

    public void browseBooks() {
        int num = 1;
        for (Book b : bookList) {
            System.out.println(num + ": " + b);
            num++;
        }
    }

    public void borrowBook(Customer customer) {
        System.out.println("Whats the books name? ");
        scanner.nextLine();
        String name = scanner.nextLine().trim().toLowerCase();
        for (Book b : bookList) {
            if (name.equals(b.getName().trim().toLowerCase())) {
                if (!isBorrowed(b)) {
                    System.out.println("Borrowed book: " + b.getName());
                    customer.addBook(b);
                    b.setBorrowed(true);
                    return;
                } else {
                    System.out.println("Is already borrowed!");
                    return;
                }
            }
        }
        System.out.println("Book doesnt exist! ");
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public String bookName() {
        System.out.println("Whats the name of the book you want to return? ");
        scanner.nextLine();
        String name = scanner.nextLine().trim().toLowerCase();
        return name;
    }

    public Boolean userExist(String username) {
        for (Customer c : customerList) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public Customer getCustomer(String username) {
        Customer custom = null;
        for (Customer c : customerList) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                custom = c;
            }
        }
        return custom;
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

    public Boolean isBorrowed(Book book) {
        if (book.getBorrowed()) {
            return true;
        } else {
            return false;
        }
    }

    public void save() throws IOException {
        FileWriter writer = new FileWriter(server, true);
        for (Book book : bookList) {
            writer.write("\n" + "Name;" + book.getName() + ";Pages;" + book.getPages() + ";Genres;" + book.getGenres() + ";Author;" + book.getAuthor() + ";Date;" + book.getDate() + ";Borrowed;" + book.getBorrowed());
        }
    }
}
