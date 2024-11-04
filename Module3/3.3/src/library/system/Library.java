package library.system;

import library.model.Book;
import library.model.LibraryMember;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<LibraryMember> members = new ArrayList<>();

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void addMember(LibraryMember member) {
        this.members.add(member);
    }

    public void removeMember(LibraryMember member) {
        this.members.remove(member);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<LibraryMember> getMembers() {
        return members;
    }

    public void borrowBook(LibraryMember member, Book book) {
        member.addBorrowedBook(book);
        removeBook(book);
    }

    public void returnBook(LibraryMember member, Book book) {
        member.removeBorrowedBook(book);
        addBook(book);
    }

    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved()) {
            member.addReservedBook(book);
            book.reserveBook();
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public void unreserveBook(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            member.removeReservedBook(book);
            book.unreserveBook();
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("Book was not reserved by this member.");
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        for (Book book : member.getReservedBooks()) {
            System.out.println(book.getTitle());
        }
    }
}
