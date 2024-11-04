package library.model;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean reserved;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void reserveBook() {
        reserved = true;
    }

    public void unreserveBook() {
        reserved = false;
    }

    public boolean isReserved() {
        return reserved;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + "\n";
    }
}
