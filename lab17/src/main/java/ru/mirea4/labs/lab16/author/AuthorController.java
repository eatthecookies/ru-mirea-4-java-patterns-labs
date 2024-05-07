package ru.mirea4.labs.lab16.author;

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

}
