package com.gabs.taskManagement.Controller;

import com.gabs.taskManagement.Entity.Priority;
import com.gabs.taskManagement.Service.PriorityService;
import org.springframework.web.bind.annotation.*;

/**
 *  REST controller for Priority
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@RestController
@RequestMapping("/api/v1/priority")
public class PriorityController {
    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @PostMapping
    public Priority save(@RequestBody Priority priority) {
        return priorityService.save(priority);
    }
}
