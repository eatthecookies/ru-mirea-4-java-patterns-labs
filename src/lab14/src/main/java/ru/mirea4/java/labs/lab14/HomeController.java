package ru.mirea4.java.labs.lab14;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String homeController(){
        return "home.html";
    }
}
