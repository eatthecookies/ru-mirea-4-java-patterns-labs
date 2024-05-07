package ru.mirea4.labs.lab16.book;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ru.mirea4.labs.lab16.author.Author;

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
    public List<Book> getBooks(String sortingCriteria) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);

        criteriaQuery.select(root);
        criteriaQuery.orderBy(builder.asc(root.get(sortingCriteria)));

        return session.createQuery(criteriaQuery).getResultList();
    }

    public Author getAuthorByBook(Long bookId) {
        return  session.createQuery("from  Book  where  id  = :id", Book.class)
                .setParameter("id",bookId)
                .getSingleResult().getAuthor();
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
