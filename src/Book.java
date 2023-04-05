import java.util.ArrayList;
import java.util.Date;

public class Book {

    private Author author;
    private String name;
    private int pages;
    private Date date;
    private ArrayList<Genre> genres;
    private Boolean borrowed = false;

    public Book(Author author, String name, int pages, Date date) {
        this.author = author;
        this.name = name;
        this.pages = pages;
        this.date = date;
        this.genres = new ArrayList<>();
    }



    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getPages() {
        return pages;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void removeGenre(Genre genre) {
        genres.remove(genre);
    }

    public String writeGenres() {
        String allGenres = "";
        for (Genre g : genres) {
            allGenres +=  g + ", ";
        }
        return allGenres;
    }

    public Boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Author: " + author + "\nPages: " + pages + " | Date: " + date + "\nGenre(s): " + writeGenres() + " | Borrowed: " + borrowed;
    }
}
