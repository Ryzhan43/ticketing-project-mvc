package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String insertUser(@ModelAttribute("") UserDTO userDTO, Model model){
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.FindAll());

        model.addAttribute(userDTO);

        model.addAttribute("employees", userService.FindAll());

        return "redirect:user/create";
    }

}
