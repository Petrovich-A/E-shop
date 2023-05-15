package by.petrovich.eshop.controllers;

import by.petrovich.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public Model showStudents(Model model) {
        model.addAttribute("listUsers", userService.findAll());
        return model;
    }

//    @GetMapping()
//    public
}