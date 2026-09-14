package com.gabs.taskManagement.Repository;

import com.gabs.taskManagement.Entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing Task persistence operations.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Page<Task> findAll(Pageable pageable);

}
