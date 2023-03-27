package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.FindAll());
        model.addAttribute("employees", userService.FindAll());

        return "user/create";

    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO userDTO, Model model){

        userService.save(userDTO);

        return "redirect:user/create";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){


        model.addAttribute("roles", roleService.FindAll());
        model.addAttribute("employees", userService.FindAll());
        model.addAttribute("user", userService.findById(username));

        return "/user/update";
    }
//
//    @PostMapping()
//    public String saveUpdatedUser(){
//        return "";
//    }
}
