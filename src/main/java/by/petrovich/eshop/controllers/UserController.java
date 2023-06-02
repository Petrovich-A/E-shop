package by.petrovich.eshop.controllers;

import by.petrovich.eshop.dto.LogInFormDto;
import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.model.Cart;
import by.petrovich.eshop.service.UserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.PathToPage.HOME_PAGE;
import static by.petrovich.eshop.PathToPage.PROFILE_PAGE;
import static by.petrovich.eshop.PathToPage.SIGN_IN_PAGE;
import static by.petrovich.eshop.PathToPage.SIGN_UP_PAGE;

@RestController
@SessionAttributes({"user", "cart"})
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public User initializeUserSessionObject() {
        return new User();
    }

    @ModelAttribute("cart")
    public Cart initializeCartSessionObject() {
        return new Cart();
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
        return new ModelAndView(PROFILE_PAGE.getPath());
    }

    @PostMapping("/signup")
    public ModelAndView signUp(@ModelAttribute("registration_form_dto") @Valid RegistrationFormDto registrationFormDto,
                               ModelAndView model) {
        model.addObject("registration_form_dto", registrationFormDto);
        userService.register(registrationFormDto);
        model.setViewName(SIGN_IN_PAGE.getPath());
        return model;
    }

    @PostMapping("/signin")
    public ModelAndView signIn(
            @ModelAttribute("login_form_dto") @Valid LogInFormDto logInFormDto,
            @ModelAttribute("user") User user) {
        user = userService.authorize(logInFormDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName(PROFILE_PAGE.getPath());
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView deleteFromSession(@ModelAttribute User user, WebRequest webRequest, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        webRequest.removeAttribute("user", WebRequest.SCOPE_SESSION);
        return new ModelAndView(HOME_PAGE.getPath());
    }

}