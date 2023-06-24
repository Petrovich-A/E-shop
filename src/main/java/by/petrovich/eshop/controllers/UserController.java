package by.petrovich.eshop.controllers;

import by.petrovich.eshop.dto.CartDto;
import by.petrovich.eshop.dto.LogInFormDto;
import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.entity.Cart;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.service.UserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.PageName.ERROR_PAGE;
import static by.petrovich.eshop.PageName.PROFILE_PAGE;
import static by.petrovich.eshop.PageName.SIGN_IN_PAGE;
import static by.petrovich.eshop.PageName.SIGN_UP_PAGE;

@Controller
@SessionAttributes({"user", "cartDto"})
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

    @ModelAttribute("cartDto")
    public CartDto initializeCartSessionObject() {
        return new CartDto();
    }

    @GetMapping("/users")
    public Model showUsers(@NonNull Model model) {
        model.addAttribute("users", userService.findAll());
        return model;
    }

    @GetMapping("/redirectToSignUpPage")
    public ModelAndView showSignUpPage(Model model) {
        model.addAttribute("registration_form_dto", new RegistrationFormDto());
        return new ModelAndView(SIGN_UP_PAGE);
    }

    @GetMapping("/redirectToSignInPage")
    public ModelAndView showSignInPage(Model model) {
        return new ModelAndView(SIGN_IN_PAGE);
    }

    @GetMapping("/redirectToProfilePage")
    public ModelAndView showProfilePage() {
        return new ModelAndView(PROFILE_PAGE);
    }

    @PostMapping("/signup")
    public ModelAndView signUp(@ModelAttribute("registration_form_dto") @Valid RegistrationFormDto registrationFormDto,
                               ModelAndView model) {
        model.addObject("registration_form_dto", registrationFormDto);
        userService.register(registrationFormDto);
        return new ModelAndView(SIGN_IN_PAGE);
    }

    @PostMapping("/signin")
    public ModelAndView signIn(
            @ModelAttribute("login_form_dto") @Valid LogInFormDto logInFormDto) {
        ModelMap modelParams = new ModelMap();
        User user = userService.authorize(logInFormDto);
        if (user != null) {
            modelParams.addAttribute("user", user);
        } else {
            modelParams.addAttribute("error_message", "Pass or login are incorrect");
            return new ModelAndView(ERROR_PAGE, modelParams);
        }
        return new ModelAndView(PROFILE_PAGE, modelParams);
    }

    @GetMapping("/logout")
    public ModelAndView deleteFromSession(@ModelAttribute User user, WebRequest webRequest, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        webRequest.removeAttribute("user", WebRequest.SCOPE_SESSION);
        return new ModelAndView("redirect:/home");
    }

}