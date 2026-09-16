package com.gabs.taskManagement.Service;

import com.gabs.taskManagement.Entity.Status;
import com.gabs.taskManagement.Entity.Task;
import com.gabs.taskManagement.Entity.TaskStatusHistory;
import com.gabs.taskManagement.Facade.StatusFacade;
import com.gabs.taskManagement.Facade.TaskFacade;
import com.gabs.taskManagement.Facade.TaskStatusHistoryFacade;
import com.gabs.taskManagement.Repository.TaskStatusHistoryRepository;
import com.gabs.taskManagement.dto.TaskRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.gabs.taskManagement.Utils.Constants.*;

/**
 * Service responsible for managing tasks.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Log4j2
@Service
public class TaskService {
    private final TaskFacade facade;
    private final StatusFacade statusFacade;
    private final TaskStatusHistoryFacade taskStatusHistoryFacade;

    @Autowired
    public TaskService(TaskFacade facade, StatusFacade statusFacade, TaskStatusHistoryFacade taskStatusHistoryFacade) {
        this.facade = facade;
        this.statusFacade = statusFacade;
        this.taskStatusHistoryFacade = taskStatusHistoryFacade;
    }

    public Iterable<Task> get (Pageable pageable){
        return facade.findAll(PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by(Sort.Direction.ASC, "title")
        ));
    }

    public Optional<Task> findById (long id){
        return facade.findById(id);
    }

    public Task save (TaskRequest request){
        return facade.save(new Task(request));
    }

    public Task update(Task task) {

        Task currentTask = findById(task.getId())
                .orElseThrow(() -> new RuntimeException(
                        "Task not found with id: " + task.getId()
                ));

        Status previousStatus = currentTask.getStatus();

        currentTask.setTitle(task.getTitle());
        currentTask.setDescription(task.getDescription());
        currentTask.setPriority(task.getPriority());
        currentTask.setStatus(task.getStatus());
        currentTask.setDueDate(task.getDueDate());

        Task updatedTask = facade.save(currentTask);

        if (!previousStatus.equals(task.getStatus())) {
            saveStatusHistory(
                    updatedTask,
                    previousStatus,
                    task.getStatus()
            );
        }
        return updatedTask;
    }

    private void saveStatusHistory(Task task,
                                   Status previousStatus,
                                   Status newStatus) {

        TaskStatusHistory history = new TaskStatusHistory();

        history.setTask(task);
        history.setPreviousStatus(previousStatus);
        history.setNewStatus(newStatus);
        history.setChangedAt(LocalDateTime.now());

        taskStatusHistoryFacade.save(history);
    }

    public void delete (long id){
        facade.delete(new Task(id));
    }

    @Scheduled(cron = "0 * * * * *")
    public void updatePendingTasks(){
        log.info(LOG_OVERDUE_TASK);
        List<Task> overDueTask= facade.findOverdueTask(LocalDate.now());
        Status statusOverdue=  statusFacade.findByName(OVERDUE_STATUS);

        for (Task task:overDueTask){
            task.setStatus(statusOverdue);
            update(task);
        }
        log.info(LOG_SIZE_OVERDUE_TASK, overDueTask.size());
    }
}
