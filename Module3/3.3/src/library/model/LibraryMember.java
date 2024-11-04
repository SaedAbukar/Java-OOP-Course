package library.model;

import java.util.ArrayList;

public class LibraryMember {
    private String name;
    private static int instance;
    private int memberID;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public LibraryMember(String name) {
        this.name = name;
        instance++;
        this.memberID = instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

}
