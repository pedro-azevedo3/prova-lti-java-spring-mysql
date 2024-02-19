package com.prova.lti.repositories;

import com.prova.lti.models.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskItemRepository extends JpaRepository<TaskItem, Long> {
    List<TaskItem> findByTaskId(Long taskId);
}