package ru.mirea4.java.labs.lab14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private Books books;

    @Autowired
    public BookController(Books books){
        this.books = books;
    }

    @GetMapping("/books")
    public @ResponseBody String giveBooks(){
        return books.getBookList().toString();
    }

    @PostMapping(value = "/addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addAuthor(@RequestBody Book newBook){
        books.addBook(newBook);
        return "Successfully added!";
    }

    @PostMapping(value = "/deleteBook")
    public @ResponseBody String addAuthor(@RequestParam int i){
        books.removeBook(i);
        return "Author with ID " + i + " has been deleted.";
    }

}
