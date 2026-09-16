package com.gabs.taskManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Represents a Task Status History managed by the application.
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "previous_status_id")
    private Status previousStatus;

    @ManyToOne
    @JoinColumn(name = "new_status_id", nullable = false)
    private Status newStatus;

    @Column(name = "changedAt")
    private LocalDateTime changedAt;
}
