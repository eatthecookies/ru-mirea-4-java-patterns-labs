package ru.mirea4.labs.lab16.author;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.mirea4.labs.lab16.book.Book;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="authors")
public class Author {
    @Id
    @SequenceGenerator(name  =  "author_seq",  sequenceName  = "authors_sequence", allocationSize = 1)
    @GeneratedValue(generator  =  "author_seq",  strategy  = GenerationType.SEQUENCE)
    private int id;

    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;

    @OneToMany(mappedBy = "author")
    private List<Book> Books;

    public Author() {
    }

    public Author(String firstName, String lastName, String middleName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
    }

}
