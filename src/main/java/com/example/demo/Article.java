package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;

@JsonIgnoreProperties({"id", "memberId", "boardId", "update"})
public class Article {
    public Long id;
    public Long memberId;
    public Long boardId;
    public String title;
    public String author;
    public String content;
    public OffsetDateTime date;
    public OffsetDateTime update;
    private Long id;
    private Long memberId;
    private Long boardId;
    private String title;
    private String author;
    private String content;
    private OffsetDateTime date;
    private OffsetDateTime update;


    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUpdate(OffsetDateTime update) {
        this.update = update;
    }

}