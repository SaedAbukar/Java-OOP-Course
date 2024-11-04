package library;

import library.model.Book;
import library.model.LibraryMember;
import library.system.Library;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book = new Book("ABC of Programming", "Saed Abukar", "0-451-52793-3");
        Book book1 = new Book("How To Code", "Mr. Coder", "1-4028-9462-9");
        Book book2 = new Book("Design Patterns", "Prof. Designer", "0-7432-7356-7");
        Book book3 = new Book("OOP Basics", "Mr. Object", "1-86197-876-6");
        Book book4 = new Book("Data Structures Explained", "Dr. Algorithm", "0-452-28683-0");
        Book book5 = new Book("Advanced Java Programming", "Jane Java", "978-0-262-03488-3");
        Book book6 = new Book("Introduction to Databases", "DB Master", "978-1-56619-909-4");
        Book book7 = new Book("Machine Learning Basics", "AI Expert", "978-0-307-27996-9");

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

        library.reserveBook(member, book4);
        library.reserveBook(member, book5);
        library.reserveBook(member1, book6);
        library.reserveBook(member1, book7);

        List<LibraryMember> members = library.getMembers();

        for (LibraryMember m : members) {
            System.out.printf("%s borrowed the following books %s%n", m.getName(), m.getBorrowedBooks());
            library.displayReservedBooks(m);
        }

        library.returnBook(member, book);
        library.returnBook(member1, book2);

        library.unreserveBook(member, book4);
        library.unreserveBook(member1, book6);

        for (LibraryMember m : members) {
            System.out.printf("%s borrowed the following books %s%n", m.getName(), m.getBorrowedBooks());
            library.displayReservedBooks(m);
        }
    }
}
