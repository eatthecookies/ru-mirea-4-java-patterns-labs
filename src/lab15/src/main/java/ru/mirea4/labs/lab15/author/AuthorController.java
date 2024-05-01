package ru.mirea4.labs.lab15.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea4.labs.lab15.book.Book;

import java.util.List;

@Controller
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public @ResponseBody List<Author>  giveAuthors(){
        return authorService.getAuthors();
    }

    @PostMapping(value = "/addAuthor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addAuthor(@RequestBody Author newAuthor){
        authorService.addAuthor(newAuthor);
        return "Successfully added!";
    }

    @PostMapping(value = "/deleteAuthor")
    public @ResponseBody String addAuthor(@RequestParam Long i){
        authorService.removeAuthor(i);
        return "Author with ID " + i + " has been deleted.";
    }
}
