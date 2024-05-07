package ru.mirea4.labs.lab16.author;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<Author> getAuthors() {
        return session.createQuery("select a from Author a", Author.class).getResultList();
    }

    public void addAuthor(Author author){
        var transaction = session.beginTransaction();
        session.saveOrUpdate(author);
        transaction.commit();
    }
    public void removeAuthor(Long id) {
        var transaction = session.beginTransaction();
        Author authorToDelete = session.get(Author.class, id);
        if (authorToDelete != null) {
            session.delete(authorToDelete);
        }
        transaction.commit();
    }
}
