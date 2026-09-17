package com.gabs.taskManagement.Controller;

import com.gabs.taskManagement.Entity.Task;
import com.gabs.taskManagement.Service.TaskService;
import com.gabs.taskManagement.dto.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing tasks.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Task> findAll(Pageable pageable) {
        return service.get(pageable);
    }

    @GetMapping("/{id}")
    public Optional<Task> getById(long id) {
        return service.findById(id);
    }

    @PostMapping
    public Task save(@RequestBody TaskRequest task) {
        return this.service.save(task);
    }

    @PutMapping
    public Task update(@RequestBody Task task) {
        return this.service.update(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        this.service.delete(id);
    }
}
