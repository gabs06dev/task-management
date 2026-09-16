package com.gabs.taskManagement.Service;

import com.gabs.taskManagement.Entity.Priority;
import com.gabs.taskManagement.Facade.PriorityFacade;
import org.springframework.stereotype.Service;

/**
 * Service responsible for managing priority.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Service
public class PriorityService {

    private final PriorityFacade priorityFacade;

    public PriorityService(PriorityFacade priorityFacade) {
        this.priorityFacade = priorityFacade;
    }

    public Priority save(Priority priority){
        return  priorityFacade.save(priority);
    }
}
