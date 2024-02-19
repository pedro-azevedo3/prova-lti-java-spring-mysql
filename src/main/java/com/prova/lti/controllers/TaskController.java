package com.prova.lti.controllers;

import com.prova.lti.models.TaskItem;
import com.prova.lti.service.TaskItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.prova.lti.models.Task;
import com.prova.lti.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskItemService taskItemService;

    @GetMapping
    public ResponseEntity<Page<Task>> getAllTasks(Pageable pageable) {
        Page<Task> tasks = taskService.getAllTasks(pageable);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok().body(task);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTask(id, taskDetails);
        return ResponseEntity.ok().body(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{taskId}/items")
    public ResponseEntity<TaskItem> addItemToTask(@PathVariable Long taskId, @RequestBody TaskItem item) {
        TaskItem addedItem = taskItemService.addItemToTask(taskId, item);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedItem);
    }

    @GetMapping("/{taskId}/items")
    public ResponseEntity<List<TaskItem>> getItemsByTaskId(@PathVariable Long taskId) {
        List<TaskItem> items = taskItemService.getItemsByTaskId(taskId);
        return ResponseEntity.ok().body(items);
    }
}
