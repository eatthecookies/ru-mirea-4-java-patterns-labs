package ru.mirea4.labs.lab19.author;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@NoArgsConstructor
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public @ResponseBody List<Author> giveAuthors(@RequestParam(value = "sortedBy", required = false) String sortingItem) {
        if (sortingItem != null) {
            return authorService.getAuthors(sortingItem);
        } else {
            return authorService.getAuthors();
        }
    }

    @PostMapping(value = "/addAuthor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addAuthor(@RequestBody Author newAuthor){
        authorService.addAuthor(newAuthor);
        return "Successfully added!";
    }

    @PostMapping(value = "/deleteAuthor")
    public @ResponseBody String deleteAuthor(@RequestParam Long i){
        authorService.removeAuthor(i);
        return "Author with ID " + i + " has been deleted.";
    }
}
