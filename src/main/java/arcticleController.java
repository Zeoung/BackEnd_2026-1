package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
public class articleController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello";
    }

    @ResponseBody
    @GetMapping("/introduce")
    public String introduce(@RequestParam String name) {
        return "안녕하세요 제 이름은 " + name + "입니다!";
    }

    @ResponseBody
    @GetMapping("/json")
    public Map<String, Object> json() {
        Map<String, Object> result = new HashMap<>();

        result.put("age", 19);
        result.put("name", "김형민");

        return result;
    }
    Map<Long, article> store = new HashMap<>();
    long seq = 1;

    @PostMapping("/article")
    public article create(@RequestBody article article) {
        article.id = seq++;
        store.put(article.id, article);
        return article;
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<article> get(@PathVariable Long id) {

        article article = store.get(id);

        if (article == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(article);
    }

    @PutMapping("/article/{id}")
    public article update(@PathVariable Long id, @RequestBody article req) {
        article article = store.get(id);
        if (article == null) {
            return null;
        }
        article.description = req.description;
        return article;
