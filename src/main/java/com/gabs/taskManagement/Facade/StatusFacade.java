package com.gabs.taskManagement.Facade;

import com.gabs.taskManagement.Entity.Status;
import com.gabs.taskManagement.Repository.StatusRepository;
import org.springframework.stereotype.Component;

/**
 * Facade that coordinates status-related operations between the controller
 * and the application services.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Component
public class StatusFacade {
    private final StatusRepository statusRepository;

    public StatusFacade(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status save(Status status) {
        return statusRepository.save(status);
    }

    public Status findByName(String name){
        return statusRepository.findByName(name);
    }
}
