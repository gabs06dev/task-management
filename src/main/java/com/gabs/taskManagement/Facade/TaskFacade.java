package com.gabs.taskManagement.Facade;

import com.gabs.taskManagement.Entity.Task;
import com.gabs.taskManagement.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import java.util.Optional;

/**
 * Facade that coordinates task-related operations between the controller
 * and the application services.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Component
public class TaskFacade {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskFacade(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> findAll(Pageable page) {
        return taskRepository.findAll(page);
    }

    public Optional<Task> findById(long id) {
        return taskRepository.findById(id);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }
}
