package com.esisba2019.finalproject2019.extractContent;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/classification")
    public String userIndex() {
        return "classification";
    }

    @GetMapping("/supprimerFiliale2")
    public String userIndex7() {
        return "supprimerFiliale2";
    }

    @GetMapping("/about")
    public String userIndex2() {
        return "about";
    }

    @GetMapping("/contact")
    public String userIndex3() {
        return "contact";
    }
//    @GetMapping("/evaluation")
}