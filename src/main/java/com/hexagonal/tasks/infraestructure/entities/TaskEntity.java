package com.hexagonal.tasks.infraestructure.entities;

import com.hexagonal.tasks.domain.models.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime ceationDate;
    private boolean completed;

    public TaskEntity() {
    }
    public TaskEntity(Long id, String title, String description, LocalDateTime ceationDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ceationDate = ceationDate;
        this.completed = completed;
    }

    public static TaskEntity fromDomainModel(Task task){
        return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getCeationDate(), task.isCompleted());
    }

    public Task toDomainModel(){
        return new Task(this.id, this.title, this.description, this.ceationDate, this.completed);
    }

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
