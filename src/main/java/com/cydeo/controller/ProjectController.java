package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/project")
@Component
public class ProjectController {

    ProjectService projectService;

    UserService userService;
    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String projectCreate(Model model){

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.FindAll());
        model.addAttribute("managers", userService.findByPosition("manager"));

        return "project/create";
    }

    @PostMapping("/create")
    public String saveProject(@ModelAttribute("project") ProjectDTO projectDTO){

        projectService.save(projectDTO);

        return "redirect:/project/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") String id){
        projectService.deleteById(id);

        return "redirect:/project/create";
    }
    @GetMapping("/complete/{id}")
    public String completeProject(@PathVariable("id") String id){

        projectService.complete(projectService.findById(id));

        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String updateProject(@PathVariable("projectCode") String projectCode, Model model){

        model.addAttribute("project", projectService.findById(projectCode));
        model.addAttribute("projects", projectService.FindAll());
        model.addAttribute("managers", userService.findByPosition("manager"));

        return "/project/update";
    }

    @PostMapping("/update/{projectCode}")
    public String saveUpdatedProject(@PathVariable("projectCode") String projectCode, @ModelAttribute("project") ProjectDTO projectDTO){

        projectService.update(projectCode,projectDTO);
        return "redirect:/project/create";
    }

    @GetMapping("/project-status")
    public String projectsList(Model model){

        UserDTO manager = userService.findById("john@cydeo.com");
        List<ProjectDTO> projects = projectService.getCountedListOfProjectDTO(manager);

        model.addAttribute("projects", projects);
        return "manager/project-status";
    }

    @GetMapping("/complete-project/{id}")
    public String updateProject(@PathVariable("id")String projectCode){

        projectService.complete(projectService.findById(projectCode));

        return "redirect:/project/project-status";
    }

}
