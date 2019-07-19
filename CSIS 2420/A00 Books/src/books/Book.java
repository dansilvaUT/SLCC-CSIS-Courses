package books;

import javax.xml.stream.events.StartDocument;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Book implements Comparable<Book> {


    /**
     * {@title String}
     */
    private String title;

    /**
     * {@author String}
     */
    private String author;

    /**
     * {@year int}
     */
    private int year;

    /**
     * @param title Title of book
     * @param author Author of Book
     * @param year Year book was released
     */
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    /**
     * @return {String} title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return {String} author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * @return {int} year
     */
    public int getYear() {
        return this.year;
    }

    @Override
    public int compareTo(Book o) {

        return this.getTitle().compareTo(o.getTitle());
    }

    /**
     * @param file Csv file that will be read in.
     * @return List<Book>
     */
    public static List<Book> getList(String file) {
        Scanner input = new Scanner(Book.class.getResourceAsStream("books.csv"));
        List<Book> bookList = new LinkedList<>();
        while (input.hasNextLine()) {
            String[] entry = input.nextLine().split(",");
            if (entry.length == 3) {
                Book book = new Book(entry[0], entry[1], Integer.parseInt(entry[2]));
                bookList.add(book);
            } else {
                System.out.println("Problem reading in " +
                        Arrays.toString(entry).replace("[", "\"").replace("]", "\""));
            }
        }
        return bookList;
    }

    /**
     * @return {String}
     */
    @Override
    public String toString() {
        return String.format("%s by %s (%d)", getTitle(), getAuthor(), getYear());
    }
}
