package com.prova.lti.service;

import com.prova.lti.exceptions.ResourceNotFoundException;
import com.prova.lti.models.Task;
import com.prova.lti.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TaskService {

    private Logger logger = Logger.getLogger(TaskService.class.getName());

    @Autowired
    TaskRepository repository;

    public Page<Task> getAllTasks(Pageable pageable) {
        logger.info("Finding all tasks!");
        return repository.findAll(pageable);
    }

    public Task getTaskById(Long id) {
        logger.info("Finding one task!");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
    }

    public Task saveTask(Task task) {
        logger.info("Creating a task!");
        return repository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails) {
        logger.info("Updating one task!");
        Task entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));

        entity.setTitle(taskDetails.getTitle());
        entity.setDescription(taskDetails.getDescription());
        entity.setDeadline(taskDetails.getDeadline());
        entity.setCompleted(taskDetails.getCompleted());

        return repository.save(entity);
    }

    public void deleteTask(Long id) {
        logger.info("Deleting task!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.delete(entity);
    }
}