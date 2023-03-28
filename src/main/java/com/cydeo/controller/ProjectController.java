package com.cydeo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/project")
public class ProjectController {


    @GetMapping("/create")
    public String projectCreate(){
        return "project/create";
    }
}
