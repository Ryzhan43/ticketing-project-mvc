package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp extends AbstractMapService<TaskDTO, Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO taskDTO) {
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
        return null;
    }
}
