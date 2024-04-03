package lab8.Iterator;

public class TestClass {
    public static void main(String[] args) {
        ConcreteLibrary library = new ConcreteLibrary();
        library.addBook(new Book("Война и мир"));
        library.addBook(new Book("Гарри Поттер"));
        library.addBook(new Book("Идиот"));

        Iterator<Book> iterator = library.createIterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            System.out.println("Название книги: " + book.getTitle());
        }
    }
}
