package ru.mirea4.labs.lab15.book;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<Book> getBooks() {
        return session.createQuery("select b from Book b", Book.class).getResultList();
    }

    public void addBook(Book book){
        var transaction = session.beginTransaction();
        session.saveOrUpdate(book);
        transaction.commit();
    }
    public void deleteBook(Long id) {
        var transaction = session.beginTransaction();
        Book bookToDelete = session.get(Book.class, id);
        if (bookToDelete != null) {
            session.delete(bookToDelete);
        }
        transaction.commit();
    }

}
