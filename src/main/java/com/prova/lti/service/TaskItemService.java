package com.prova.lti.service;

import com.prova.lti.exceptions.ResourceNotFoundException;
import com.prova.lti.models.Task;
import com.prova.lti.models.TaskItem;
import com.prova.lti.repositories.TaskItemRepository;
import com.prova.lti.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TaskItemService {

    private Logger logger = Logger.getLogger(TaskItemService.class.getName());

    @Autowired
    private TaskItemRepository itemRepository;

    @Autowired
    private TaskRepository taskRepository;

    public TaskItem addItemToTask(Long taskId, TaskItem item) {
        logger.info("Adding item to task!");
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

        item.setTask(task);
        return itemRepository.save(item);
    }

    public List<TaskItem> getItemsByTaskId(Long taskId) {
        logger.info("Getting items by task id!");
        return itemRepository.findByTaskId(taskId);
    }
}