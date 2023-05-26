package by.petrovich.eshop.controllers;

import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.model.User;
import by.petrovich.eshop.service.UserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.PathToPage.HOME_PAGE;
import static by.petrovich.eshop.PathToPage.SIGN_IN_PAGE;
import static by.petrovich.eshop.PathToPage.SIGN_UP_PAGE;

@RestController
@RequestMapping("/user")
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
    public ModelAndView showSignUpPage(Model model) {
        model.addAttribute("registration_form_dto", new RegistrationFormDto());
        return new ModelAndView(SIGN_UP_PAGE.getPath());
    }

    @GetMapping("/redirectToSignInPage")
    public ModelAndView showSignInPage(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView(SIGN_IN_PAGE.getPath());
    }

    @GetMapping("/redirectToProfilePage")
    public ModelAndView showProfilePage() {
        return new ModelAndView(HOME_PAGE.getPath());
    }

    @PostMapping("/signup")
    public ModelAndView signUp(@RequestBody @Valid RegistrationFormDto registrationFormDto, Model model) {
        model.addAttribute("registration_form_dto", registrationFormDto);
        userService.save(registrationFormDto);
        return new ModelAndView(SIGN_IN_PAGE.getPath());
    }

    @PostMapping(value = "/signin")
    public ModelAndView signIn(@RequestBody @Valid User user) {
        return new ModelAndView(HOME_PAGE.getPath());
    }

}