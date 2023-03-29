import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /*
        Book book = new Book(new Author("Maria Andersson",33), "Din mamma",2,new Date());
        book.addGenre(Genre.CHILDREN);
        book.addGenre(Genre.HORROR);
        System.out.println(book);
        Customer customer = new Customer("Jonis", 5,"","Jonis1");
        customer.addBook(new Book(new Author("Maria Andersson",5), "Jonis äventyr", 5, new Date()));
        customer.addBook(book);
        System.out.println(customer);

         */
        Library library = new Library();
        library.start();
    }
}