package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.Collection;


@RestController
public class ArticleController {

    private final ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @PostMapping("/articles")
    public ResponseEntity<Article> create(@RequestBody Article article) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(article));
    }

    @GetMapping("/articles")
    public Collection<Article> getAll() {
        return service.getAll();
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> get(@PathVariable Long id) {

        Article article = service.getById(id);
        if (article == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(article);

    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody Article req) {
        Article article = service.update(id, req);
        if (article == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(article);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}