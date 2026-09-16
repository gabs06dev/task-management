package com.gabs.taskManagement.Service;

import com.gabs.taskManagement.Entity.Task;
import com.gabs.taskManagement.Facade.TaskFacade;
import com.gabs.taskManagement.dto.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service responsible for managing tasks.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Service
public class TaskService {
    private final TaskFacade facade;

    @Autowired
    public TaskService(TaskFacade facade) {
        this.facade = facade;
    }

    public Iterable<Task> get (Pageable pageable){
        return facade.findAll(PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by(Sort.Direction.ASC, "title")
        ));
    }

    public Optional<Task> findById (long id){
        return facade.findById(id);
    }

    public Task save (TaskRequest request){
        return facade.save(new Task(request));
    }

    public void delete (long id){
        facade.delete(new Task(id));
    }
}
