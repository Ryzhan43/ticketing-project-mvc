package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImp extends AbstractMapService<ProjectDTO,String> implements ProjectService {

    TaskService taskService;

    public ProjectServiceImp(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO save(ProjectDTO projectDTO) {
        if(projectDTO.getProjectStatus()==null)
        {
            projectDTO.setProjectStatus(Status.OPEN);
        }

        return super.save(projectDTO.getProjectCode(),projectDTO);
    }

    @Override
    public List<ProjectDTO> FindAll() {
        return super.findAll();
    }

    @Override
    public void update(String id, ProjectDTO projectDTO) {

        if(projectDTO.getProjectStatus()==null)
        {
            projectDTO.setProjectStatus(Status.OPEN);
        }


        super.update(id,projectDTO);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void complete(ProjectDTO projectDTO) {
        projectDTO.setProjectStatus(Status.COMPLETE);
        super.save(projectDTO.getProjectCode(),projectDTO);
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {

        List<ProjectDTO> projectDTOList = super.findAll()
                .stream()
                    .filter(a->a.getAssignedManager().equals(manager))
                    .map(project -> {

                        List<TaskDTO> taskDTOList = taskService.findTasksByManager(manager);

                        int completeTaskCounts = (int)taskDTOList.stream()
                                                        .filter(a->a.getStatus().equals(Status.COMPLETE)
                                                                && a.getProjectDTO().equals(project))
                                                        .count();
                        int unfinishedTaskCounts = (int)taskDTOList.stream()
                                                        .filter(a->(a.getStatus() != Status.COMPLETE)
                                                                && a.getProjectDTO().equals(project))
                                                        .count();;

                        project.setCompleteTaskCounts(completeTaskCounts);
                        project.setUnfinishedTaskCounts(unfinishedTaskCounts);

                        return project;
                    }).collect(Collectors.toList());






        return projectDTOList;
    }


}
