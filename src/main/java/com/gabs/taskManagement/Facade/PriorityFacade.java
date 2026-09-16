package com.gabs.taskManagement.Facade;


import com.gabs.taskManagement.Entity.Priority;
import com.gabs.taskManagement.Repository.PriorityRepository;
import org.springframework.stereotype.Component;

/**
 * Facade that coordinates priority-related operations between the controller
 * and the application services.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Component
public class PriorityFacade {
    private final PriorityRepository priorityRepository;

    public PriorityFacade(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public Priority save (Priority priority){
        return priorityRepository.save(priority);
    }
}
