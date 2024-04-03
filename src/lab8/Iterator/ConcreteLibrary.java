package lab8.Iterator;
import java.util.ArrayList;
import java.util.List;

public class ConcreteLibrary implements Library{
    private List<Book> books;

    public ConcreteLibrary() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }
    @Override
    public Iterator<Book> createIterator() {
        return new ConcreteIterator(books);
    }
}
