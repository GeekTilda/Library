import java.util.ArrayList;

public class Customer extends Human {

    private String password;
    private String username;
    ArrayList<Book> borrowedBooks;

    public Customer(String name, int age, String password, String username) {
        super(name, age);
        this.password = password;
        this.username = username;
        borrowedBooks = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBook(Book book) { borrowedBooks.add(book); }

    /*
     *  Goes through all of our borrowed books,
     *  If the name of a book we have borrowed matches:
     *  Returns the book (false) and removes from our list of borrowed books
     */
    public void removeBook(String name) {
        for (Book b : borrowedBooks) {
            if (name.equalsIgnoreCase(b.getName())) {
                b.setBorrowed(false);
                borrowedBooks.remove(b);
                System.out.println("Successfully returned! ");
                return;
            }
        }
        System.out.println("You have not borrowed this book! ");
    }

    /*
     *  Writes all of our borrowed books in a list
     */
    public String writeBorrowedBooks() {
        int num = 0;
        String borrowedBook = "";
        for (Book b : borrowedBooks) {
            num++;
            borrowedBook += "\n" + num + ": \n" + b + ", ";
        }
        return borrowedBook;
    }

    @Override
    public String toString() {
        return "Username: " + username + " | Name: " + getName() + " | Age: " + getAge() + "\nBorrowed book(s): " + writeBorrowedBooks();
    }
}
