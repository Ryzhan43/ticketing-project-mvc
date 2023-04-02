package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImp extends AbstractMapService<TaskDTO, Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO taskDTO) {

        if(taskDTO.getStatus() == null) {
            taskDTO.setStatus(Status.OPEN);
        }

        if(taskDTO.getAssignmentDate() == null) {
            taskDTO.setAssignmentDate(LocalDate.now());
        }

        if(taskDTO.getId() == null){
            taskDTO.setId(UUID.randomUUID().getLeastSignificantBits());
        }

        return super.save(taskDTO.getId(), taskDTO);
    }

    @Override
    public List<TaskDTO> FindAll() {
        return super.findAll();
    }

    @Override
    public void update(Long aLong, TaskDTO taskDTO) {
        super.update(aLong,taskDTO);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void update(TaskDTO taskDTO) {
        super.update(taskDTO.getId(),taskDTO);
    }

    @Override
    public List<TaskDTO> findTasksByManager(UserDTO userDTO) {
        return super.findAll()
                            .stream()
                            .filter(a->a.getProjectDTO().getAssignedManager().equals(userDTO))
                            .collect(Collectors.toList());
    }


}
