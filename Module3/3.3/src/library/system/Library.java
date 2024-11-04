package library.system;

import library.model.Book;
import library.model.LibraryMember;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<LibraryMember> members = new ArrayList<>();

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

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<LibraryMember> getMembers() {
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
}
