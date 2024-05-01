package ru.mirea4.java.labs.lab14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorController {
    private final Authors authors;

    @Autowired
    public AuthorController(Authors authors) {
        this.authors = authors;
    }

    @GetMapping("/authors")
    public @ResponseBody String giveAuthors(){
        return authors.getAuthorList().toString();
    }

    @PostMapping(value = "/addAuthor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addAuthor(@RequestBody Author newAuthor){
        authors.addAuthor(newAuthor);
        return "Successfully added!";
    }

    @PostMapping(value = "/deleteAuthor")
    public @ResponseBody String addAuthor(@RequestParam int i){
        authors.removeAuthor(i);
        return "Author with ID " + i + " has been deleted.";
    }
}
