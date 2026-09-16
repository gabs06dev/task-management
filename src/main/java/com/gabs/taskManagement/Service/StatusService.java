package com.gabs.taskManagement.Service;

import com.gabs.taskManagement.Entity.Status;
import com.gabs.taskManagement.Facade.StatusFacade;
import org.springframework.stereotype.Service;

/**
 * Service responsible for managing status.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Service
public class StatusService {
    private final StatusFacade statusFacade;

    public StatusService (StatusFacade statusFacade) {
        this.statusFacade = statusFacade;
    }

    public Status save (Status status){
        return  statusFacade.save(status);
    }
}
