package by.petrovich.eshop.controllers;

import by.petrovich.eshop.model.User;
import by.petrovich.eshop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/redirectToRegistrationPage")
    public ModelAndView showRegistrationPage(ModelAndView modelAndView) {
        modelAndView.setViewName("/registr");
        return modelAndView;
    }

    @GetMapping("/redirectToHomePage")
    public ModelAndView showHomePage(ModelAndView modelAndView) {
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @GetMapping("/redirectToLogInPage")
    public ModelAndView showLogInPage(ModelAndView modelAndView) {
        modelAndView.setViewName("/login");
        return modelAndView;
    }

    @GetMapping("/redirectToProfilePage")
    public ModelAndView showProfilePage(ModelAndView modelAndView) {
        modelAndView.setViewName("/registr");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView registration(@Valid User user, ModelAndView modelAndView) {
        userService.save(user);
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @GetMapping (value = "/login")
    public ModelAndView loginUser(@Valid User user, ModelAndView modelAndView) {
        userService.save(user);
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @GetMapping("/authorization")
    public Model authorizationUser(Model model) {
        return model;
    }

}