import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Book book = new Book(new Author("Maria Andersson",33), "Din mamma",2,new Date());
        book.addGenre(Genre.CHILDREN);
        book.addGenre(Genre.HORROR);
        System.out.println(book);
        Customer customer = new Customer("hej", 5,"","");
        customer.addBook(new Book(new Author("",5), "", 5, new Date()));
        System.out.println(customer);
    }
}