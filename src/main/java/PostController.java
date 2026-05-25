package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    private final ArticleService service;

    public PostController(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/posts")
    public String posts(Model model) {

        model.addAttribute("boardName", "자유게시판");
        model.addAttribute("articles", service.getAll());

        return "posts";
    }
}
