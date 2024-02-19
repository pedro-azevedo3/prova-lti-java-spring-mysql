package com.prova.lti.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name="taskItem")
public class TaskItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public TaskItem() {
    }

    public TaskItem(String title, Task task) {
        this.title = title;
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskItem taskItem = (TaskItem) o;
        return Objects.equals(id, taskItem.id) && Objects.equals(title, taskItem.title) && Objects.equals(task, taskItem.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, task);
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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
