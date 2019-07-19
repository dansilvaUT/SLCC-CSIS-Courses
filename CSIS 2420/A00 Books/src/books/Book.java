package books;

import javax.xml.stream.events.StartDocument;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Book implements Comparable<Book> {


    /**
     * @var title
     */
    private String title;

    /**
     * @var author
     */
    private String author;

    /**
     * @var int
     */
    private int year;

    /**
     * @param title
     * @param author
     * @param year
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
        //TODO
        return 0;
    }

    public static List<Book> getList(String file) {
        Scanner input = new Scanner(Book.class.getResourceAsStream("books.csv"));
        List<Book> bookList = new LinkedList<>();
        while(input.hasNextLine()){
            String[] entry = input.nextLine().split(",");
            if(entry.length == 3){
                Book book = new Book(entry[0], entry[1], Integer.parseInt(entry[2]));
                bookList.add(book);
            } else {
                System.out.println("Problem reading in " + Arrays.toString(entry));
            }
        }
        return bookList;
    }

    /**
     * @return {String}
     */
    @Override
    public String toString() {
        return String.format("%s by %s (%d)", title, author, year);
    }
}
