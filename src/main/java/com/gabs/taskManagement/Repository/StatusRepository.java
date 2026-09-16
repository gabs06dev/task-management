package com.gabs.taskManagement.Repository;

import com.gabs.taskManagement.Entity.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing status persistence operations.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
}
