package com.gabs.taskManagement.dto;

import com.gabs.taskManagement.Entity.Priority;
import com.gabs.taskManagement.Entity.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Represents a request for a Task
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Getter
@Setter
@NoArgsConstructor
public class TaskRequest {

    @Schema(description = "Title of the task", example = "Implement login")
    private String title;

    @Schema(description = "Description of the task", example = "Add authemtication to the API")
    private String description;

    @Schema(description = "Description of the task", example = "PENDING")
    private Status status;

    @Schema(description = "Urgency of the task", example = "HIGH")
    private Priority priority;

    @Schema(description = "Date when task need to be finished", example = "")
    private LocalDate dueDate;

    @Schema(description = "Creation Date of the task", example = "HIGH")
    private LocalDateTime createdAt;
}
