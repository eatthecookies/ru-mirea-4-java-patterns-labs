package ru.mirea4.java.labs.lab14;

public class Book {
    private String name, creationDate;

    public Book(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
