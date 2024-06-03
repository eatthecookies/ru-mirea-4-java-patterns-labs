package ru.mirea4.labs.lab20.author;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAuthors() {
//        log.info("Find all authors");
        return authorRepository.findAll();
    }
    public List<Author> getAuthors(String sortItem) {
//        log.info("Find all authors with sorting");
        Sort sort = Sort.by(Sort.Direction.ASC, sortItem);
        return authorRepository.findAll(sort);
    }

    public void addAuthor(Author author){
//        log.info("Adding author");
        authorRepository.save(author);
    }
    public void removeAuthor(Long id) {
//        log.info("Deleting author");
        authorRepository.delete(authorRepository.getAuthorById(id));
    }
}
