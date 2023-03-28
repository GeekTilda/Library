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

    public void addBook(Book book) {
        borrowedBooks.add(book);
    }

    public String writeBorrowedBooks() {
        String borrowedBook = "";
        for (Book b : borrowedBooks) {
            borrowedBook += b + ", ";
        }
        return borrowedBook;
    }

    @Override
    public String toString() {
        return " Username: " + username + " | Name: " + getName() + " | Age: " + getAge() + " | Borrowed books: " + writeBorrowedBooks();
    }
}
