package com.cydeo.service;

import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO,Long>{
    void update(TaskDTO taskDTO);

    List<TaskDTO> findTasksByManager(UserDTO userDTO);
}
