package com.gabs.taskManagement.Entity;

import com.gabs.taskManagement.dto.TaskRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Represents a task managed by the application.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "title")
    private String title;

    @NotBlank
    @Size(max = 100)
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @Column(name = "dueDate")
    private LocalDate dueDate;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    public Task(TaskRequest request) {
        this.title = request.getTitle();
        this.description = request.getDescription();
        this.status = request.getStatus();
        this.priority = request.getPriority();
        this.dueDate = request.getDueDate();
        this.createdAt = request.getCreatedAt();
    }

    public Task(long id) {
        this.id = id;
    }
}
