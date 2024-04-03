package lab8.Iterator;

import java.util.List;

public class ConcreteIterator implements Iterator{
    private List<Book> books;
    private int position;

    public ConcreteIterator(List<Book> books) {
        this.books = books;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("Выход за пределы коллекции");
        }
        return books.get(position++);
    }
}
