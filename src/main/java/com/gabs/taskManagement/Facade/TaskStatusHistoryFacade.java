package com.gabs.taskManagement.Facade;

import com.gabs.taskManagement.Entity.TaskStatusHistory;
import com.gabs.taskManagement.Repository.TaskStatusHistoryRepository;
import org.springframework.stereotype.Component;

/**
 * Facade that coordinates task-status-history--related operations between the controller
 * and the application services.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Component
public class TaskStatusHistoryFacade {
    private final TaskStatusHistoryRepository repository;

    public TaskStatusHistoryFacade(TaskStatusHistoryRepository repository) {
        this.repository = repository;
    }

    public TaskStatusHistory save(TaskStatusHistory entity){
        return this.repository.save(entity);
    }
}
