package ru.mirea4.labs.lab15.book;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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
    @Column(name = "creationDate")
    private int creationDate;


    public Book(String name, int creationDate) {
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
