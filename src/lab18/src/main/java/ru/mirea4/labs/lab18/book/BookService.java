package ru.mirea4.labs.lab18.book;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.mirea4.labs.lab18.author.Author;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    public List<Book> getBooks(String sortingCriteria) {
        Sort sort = Sort.by(Sort.Direction.ASC,  sortingCriteria);
        return bookRepository.findAll(sort);
    }

    public Author getAuthorByBook(Long bookId) {
        return  bookRepository.findBookById(bookId).getAuthor();
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public void deleteBook(Long id) {
        bookRepository.delete(bookRepository.findBookById(id));
    }

}
