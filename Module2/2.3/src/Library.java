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

    public Book borrowBook(String title) {
        for (Book book : books2) {
            if (book.getTitle().equals(title)) {
                books2.remove(book);
                return book;
            }
        }
        return null;
    }

    public Book returnBook(Book book) {
        books2.add(book);
        return book;
    }

    public boolean isBookAvailable(String title) {
        for (Book book : books2) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public double getAverageRating() {
        double sum = 0;
        for (Book book : books2) {
            double rating = book.getRating();
            sum += rating;
        }
        return sum / books2.size();
    }

    public Book getMostReviewedBook() {
        int max = 0;
        Book mostReviewedBook = null;
        for (Book book : books2) {
            int count = book.getReviewCount();
            if (count > max) {
                max = count;
                mostReviewedBook = book;
            }
        }
        return mostReviewedBook;
    }
}