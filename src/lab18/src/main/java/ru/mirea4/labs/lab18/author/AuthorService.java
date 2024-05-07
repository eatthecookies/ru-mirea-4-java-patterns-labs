package ru.mirea4.labs.lab18.author;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
    public List<Author> getAuthors(String sortItem) {
        Sort sort = Sort.by(Sort.Direction.ASC, sortItem);
        return authorRepository.findAll(sort);
    }

    public void addAuthor(Author author){
        authorRepository.save(author);
    }
    public void removeAuthor(Long id) {
        authorRepository.delete(authorRepository.getAuthorById(id));
    }
}
