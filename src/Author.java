import java.util.ArrayList;

public class Author extends Human {

    ArrayList<Book> books;

    public Author(String name, int age) {
        super(name, age);
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBooks(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return "[ Name: " + getName() + " | Age: " + getAge() + " ]";
    }
}
