package ru.mirea4.labs.lab19.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.mirea4.labs.lab19.author.Author;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @SequenceGenerator(name  =  "book_seq",  sequenceName  = "books_sequence", allocationSize = 1)
    @GeneratedValue(generator  =  "book_seq",  strategy  = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "creationdate")
    private String creationDate;
    @JsonIgnore
    @ManyToOne
    private Author author;

    public Book(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
