package com.prova.lti.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="task")
public class Task implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;

    @Column(name = "completed", nullable = false)
    private Boolean completed;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<TaskItem> items;

    public Task() {}

    public long getId() {
        return id;
    }

    public Task(Long id, String title, String description, LocalDate deadline, Boolean completed, List<TaskItem> items) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.completed = completed;
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(deadline, task.deadline) && Objects.equals(completed, task.completed) && Objects.equals(items, task.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, deadline, completed, items);
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

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public List<TaskItem> getItems() {
        return items;
    }

    public void setItems(List<TaskItem> items) {
        this.items = items;
    }
}
