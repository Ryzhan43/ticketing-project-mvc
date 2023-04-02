package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TaskDTO {

    private Long id;
    private ProjectDTO projectDTO;
    private UserDTO userDTO;
    private String taskSubject;
    private String taskDetail;
    private Status status;
    private LocalDate assignmentDate;


    public TaskDTO(ProjectDTO projectDTO, UserDTO userDTO, String taskSubject, String taskDetail, Status status, LocalDate assignmentDate) {
        this.projectDTO = projectDTO;
        this.userDTO = userDTO;
        this.taskSubject = taskSubject;
        this.taskDetail = taskDetail;
        this.status = status;
        this.assignmentDate = assignmentDate;
        this.id = UUID.randomUUID().getLeastSignificantBits();
    }
}
