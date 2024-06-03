package ru.mirea4.labs.lab19.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.mirea4.labs.lab19.author.Author;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        log.info("Find all books");
        return bookRepository.findAll();
    }
    public List<Book> getBooks(String sortingCriteria) {
        log.info("Find all books with sorting");
        Sort sort = Sort.by(Sort.Direction.ASC,  sortingCriteria);
        return bookRepository.findAll(sort);
    }

    public Author getAuthorByBook(Long bookId) {
        log.info("Getting author by book");
        return  bookRepository.findBookById(bookId).getAuthor();
    }
    public void addBook(Book book){
        log.info("Adding book");
        bookRepository.save(book);
    }
    public void deleteBook(Long id) {
        log.info("Deleting book");
        bookRepository.delete(bookRepository.findBookById(id));
    }

}
