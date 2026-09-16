package com.gabs.taskManagement.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a status
 *
 * @author Gustavo Barrera
 * @since 2026-09-14
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Status of a task")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "name")
    private String name;

    public Status (String name){
        this.name=name;
    }

}
