package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImp extends AbstractMapService<ProjectDTO,String> implements ProjectService {
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
}
