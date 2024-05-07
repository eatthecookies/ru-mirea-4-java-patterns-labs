package ru.mirea4.labs.lab16.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea4.labs.lab16.author.Author;

import java.util.List;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public @ResponseBody List<Book> giveBooks(@RequestParam(value = "sortedBy", required = false) String sortingCriteria){
        if (sortingCriteria != null){
            return bookService.getBooks(sortingCriteria);
        }
        return bookService.getBooks();
    }

}
