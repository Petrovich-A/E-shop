package by.petrovich.eshop.controllers;

import by.petrovich.eshop.model.User;
import by.petrovich.eshop.service.UserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public Model showUsers(@NonNull Model model) {
        model.addAttribute("users", userService.findAll());
        return model;
    }

    @GetMapping("/redirectToSignUpPage")
    public ModelAndView showSignUpPage(@NonNull ModelAndView modelAndView) {
        modelAndView.setViewName("/signup");
        return modelAndView;
    }

    @GetMapping("/redirectToSignInPage")
    public ModelAndView showSignInPage(@NonNull ModelAndView modelAndView) {
        modelAndView.setViewName("/login");
        return modelAndView;
    }

    @GetMapping("/redirectToProfilePage")
    public ModelAndView showProfilePage(@NonNull ModelAndView modelAndView) {
        modelAndView.setViewName("/registr");
        return modelAndView;
    }

    @PostMapping(value = "/signup")
    public ModelAndView signup(@Valid User user, @NonNull ModelAndView modelAndView) {
        userService.save(user);
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @GetMapping (value = "/signin")
    public ModelAndView signin(@Valid User user, @NonNull ModelAndView modelAndView) {
        userService.save(user);
        modelAndView.setViewName("/index");
        return modelAndView;
    }

 }