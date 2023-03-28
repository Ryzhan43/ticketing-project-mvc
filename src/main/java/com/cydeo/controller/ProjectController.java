package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("managers", userService.FindAll().stream().filter(a->a.getRoleDTO().getDescription().equalsIgnoreCase("Manager")).collect(Collectors.toUnmodifiableList()));

        return "project/create";
    }
}
