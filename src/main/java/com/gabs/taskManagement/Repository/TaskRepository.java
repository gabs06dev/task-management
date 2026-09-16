package com.gabs.taskManagement.Repository;

import com.gabs.taskManagement.Entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository for managing Task persistence operations.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Page<Task> findAll(Pageable pageable);

    @Query("SELECT t FROM Task t JOIN t.status s WHERE t.dueDate < :currentDate AND s.name = 'PENDING'")
    List<Task> findOverdueTask(LocalDate currentDate);
}
