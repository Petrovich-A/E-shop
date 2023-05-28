package by.petrovich.eshop.controllers;

import by.petrovich.eshop.dto.LogInFormDto;
import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.PathToPage.HOME_PAGE;
import static by.petrovich.eshop.PathToPage.PROFILE_PAGE;
import static by.petrovich.eshop.PathToPage.SIGN_IN_PAGE;
import static by.petrovich.eshop.PathToPage.SIGN_UP_PAGE;

@RestController
//@SessionAttributes({"user"})
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
        return new ModelAndView(PROFILE_PAGE.getPath());
    }

    @PostMapping("/signup")
    public ModelAndView signUp(@ModelAttribute("registration_form_dto") @Valid RegistrationFormDto registrationFormDto, ModelAndView model) {
        model.addObject("registration_form_dto", registrationFormDto);
        userService.register(registrationFormDto);
        model.setViewName(SIGN_IN_PAGE.getPath());
        return model;
    }

    @PostMapping("/signin")
    public ModelAndView signIn(@ModelAttribute("login_form_dto") @Valid LogInFormDto logInFormDto, HttpSession httpSession) {
        User user = userService.authorize(logInFormDto);
        httpSession.setAttribute("user", user);
        return new ModelAndView(PROFILE_PAGE.getPath());
    }
//
//    @ModelAttribute("user")
//    public User setUpUserForm() {
//        return new User();
//    }

    @GetMapping("/logout")
    public ModelAndView showLogoutPage(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return new ModelAndView(HOME_PAGE.getPath());
    }

}