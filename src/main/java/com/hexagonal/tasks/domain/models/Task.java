package com.hexagonal.tasks.domain.models;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime ceationDate;
    private boolean completed;

    public Task(Long id, String title, String description, LocalDateTime ceationDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ceationDate = ceationDate;
        this.completed = completed;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCeationDate() {
        return ceationDate;
    }

    public void setCeationDate(LocalDateTime ceationDate) {
        this.ceationDate = ceationDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
