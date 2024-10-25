import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> books2 = new ArrayList<>();
    private HashMap<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books2.add(book);
    }

    public void addBook(String category, Book book) {
        if (!books.containsKey(category)) {
            books.put(category, book);
        }
    }

    public Book getBook(String author) {
        for (Book book : books2) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public Book findBook(String author) {
        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> displayBooks() {
        return books2;
    }

    public HashMap<String, Book> getBooks() {
        return books;
    }
}