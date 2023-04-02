package com.cydeo.controller;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/task")
@Controller
@Service
public class TaskController {

    ProjectService projectService;
    UserService userService;
    TaskService taskService;

    public TaskController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createTask(Model model){
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("tasks", taskService.FindAll());
        model.addAttribute("projects", projectService.FindAll());
        model.addAttribute("employees", userService.FindAll());
        return "task/create";
    }

    @PostMapping("/create")
    public String saveTask(@ModelAttribute("task") TaskDTO taskDTO){
        taskService.save(taskDTO);

        return "redirect:/task/create";
    }

    @GetMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable("taskId") Long id){
        taskService.deleteById(id);
        return "redirect:/task/create";
    }


    @GetMapping("/update/{id}")
    public String editTask(@PathVariable("id")Long id, Model model){
        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("tasks", taskService.FindAll());
        model.addAttribute("projects", projectService.FindAll());
        model.addAttribute("employees", userService.FindAll());
        return "task/update";
    }

    @PostMapping("/update/{taskId}")
    public String updateTask(@PathVariable("taskId")Long id, @ModelAttribute("task")TaskDTO taskDTO){
        taskService.update(id,taskDTO);
        return "redirect:/task/create";
    }
}
