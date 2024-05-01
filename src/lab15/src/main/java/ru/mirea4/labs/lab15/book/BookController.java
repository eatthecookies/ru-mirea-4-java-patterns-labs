package ru.mirea4.labs.lab15.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public @ResponseBody List<Book> giveBooks(){
        return bookService.getBooks();
    }

    @PostMapping(value = "/addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addAuthor(@RequestBody Book newBook){
        bookService.addBook(newBook);
        return "Successfully added!";
    }

    @PostMapping(value = "/deleteBook")
    public @ResponseBody String addAuthor(@RequestParam Long i){
        bookService.deleteBook(i);
        return "Book with ID " + i + " has been deleted.";
    }
}
