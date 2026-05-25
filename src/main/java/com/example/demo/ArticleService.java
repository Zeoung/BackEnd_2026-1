package com.example.demo;

import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.Collection;

@Service
public class ArticleService {

    private final ArticleRepository repository;

    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public Article create(Article article) {
        article.date = OffsetDateTime.now();
        article.update = OffsetDateTime.now();
        return repository.save(article);
    }

    public Collection<Article> getAll() {
        return repository.findAll();
    }

    public Article getById(Long id) {
        return repository.findById(id);
    }

    public Article update(Long id, Article req) {
        Article article = repository.findById(id);
        if (article == null) return null;
        article.title = req.title;
        article.content = req.content;
        article.content = req.content;
        return article;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}