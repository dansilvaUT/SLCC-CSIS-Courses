package books;

import java.util.List;

public class BookApp {
    public static void main(String[] args) {
        List<Book> book = Book.getList("books.csv");
        for(Book b: book){
            System.out.println(b);
        }
    }
}
