package com.gabs.taskManagement.Controller;

import com.gabs.taskManagement.Entity.Status;
import com.gabs.taskManagement.Service.StatusService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  REST controller for Status
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@RestController
@RequestMapping("/api/v1/status")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    public Status save(@RequestBody Status status) {
        return statusService.save(status);
    }
}
