public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("War", "Bob Woodward", 2024);
        Book book2 = new Book("Atomic Habits", "James Clear", 2018);
        Book book3 = new Book("The 48 Laws of Power", "Robert Greene", 1998);
        Book book4 = new Book("Good Book", "Saed Abukar", 2024);
        library.addBook(book3);
        library.addBook(book4);

        library.addBook("Biographies And Memories", book1);
        library.addBook("Health And Wellness", book2);

        System.out.println("Library Catalog");
        int i = 1;
        for (Book book : library.displayBooks()) {
            System.out.printf("%d Title: %s, Author %s, Year: %d%n", i, book.getTitle(), book.getAuthor(), book.getYear());
            i++;
        }
        i = 1;
        for (String category : library.getBooks().keySet()) {
            Book book = library.getBooks().get(category);
            System.out.printf("%d %s Title: %s, Author: %s, Year: %d%n", i, category, book.getTitle(), book.getAuthor(), book.getYear());
            i++;
        }

        System.out.println("Books by Author \"Saed Abukar\"");

        System.out.printf("Title: %s, Year: %d%n", library.getBook("Saed Abukar").getAuthor(), library.getBook("Saed Abukar").getYear());


        System.out.println("Books by Author \"James Clear\"");

        Book book = library.findBook("James Clear");
        System.out.printf("Title: %s, Author: %s, Year: %d%n", book.getTitle(), book.getAuthor(), book.getYear());
    }
}
