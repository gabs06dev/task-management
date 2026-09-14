package com.gabs.taskManagement.Repository;

import com.gabs.taskManagement.Entity.Priority;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing priority persistence operations.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Repository
public interface PriorityRepository extends CrudRepository<Priority, Long> {
}
