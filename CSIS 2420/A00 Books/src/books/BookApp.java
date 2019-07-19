package books;

import java.util.Collections;
import java.util.List;

public class BookApp {
    public static void main(String[] args) {
        List<Book> book = Book.getList("books.csv");
        System.out.printf("Total number of books read %d%n%n", book.size());
        System.out.println("Sorted book list:");
        Collections.sort(book);
        printBooks(book);
        Collections.reverse(book);
        System.out.println();
        System.out.println("Reverse Order:");
        printBooks(book);
    }

    /**
     *
     * @param book Book list that will be printed out
     */
    private static void printBooks(List<Book> book) {
        for (Book b : book) {
            System.out.println(b);
        }
    }
}
