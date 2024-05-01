package ru.mirea4.java.labs.lab14;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Authors {
    List<Author> authorList;

    public Authors(List<Author> authorList) {
        this.authorList = new ArrayList<>();
    }

    public void addAuthor(Author author){
        authorList.add(author);
    }

    public void removeAuthor(int i){
        authorList.remove(i);
    }

    public List<Author> getAuthorList() {
        return authorList;
    }
}
