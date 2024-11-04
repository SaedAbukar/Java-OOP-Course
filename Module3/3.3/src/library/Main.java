package library;

import library.model.Book;
import library.model.LibraryMember;
import library.system.Library;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book = new Book("ABC of Programming", "Saed Abukar", "0-451-52793-3");
        Book book1 = new Book("How To Code", "Mr. Coder", "1-4028-9462-9");
        Book book2 = new Book("Design Patterns", "Prof. Designer", "0-7432-7356-7");
        Book book3 = new Book("OOP Basics", "Mr. Object", "1-86197-876-6");
        LibraryMember member = new LibraryMember("Abukar Saed");
        LibraryMember member1 = new LibraryMember("Mr. Member");

        library.addBook(book);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addMember(member);
        library.addMember(member1);

        library.borrowBook(member, book);
        library.borrowBook(member, book1);
        library.borrowBook(member1, book2);
        library.borrowBook(member1, book3);

        ArrayList<LibraryMember> members = library.getMembers();

        for (LibraryMember m : members) {
            System.out.printf("%s borrowed the following books %s%n", m.getName(), m.getBorrowedBooks());
        }

        library.returnBook(member, book);
        library.returnBook(member1, book2);

        for (LibraryMember m : members) {
            System.out.printf("%s borrowed the following books %s%n", m.getName(), m.getBorrowedBooks());
        }


    }
}
