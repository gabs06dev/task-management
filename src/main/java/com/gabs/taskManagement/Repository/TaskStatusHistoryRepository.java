package com.gabs.taskManagement.Repository;

import com.gabs.taskManagement.Entity.TaskStatusHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing Task Status History persistence operations.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Repository
public interface TaskStatusHistoryRepository extends CrudRepository<TaskStatusHistory, Long> {
}
