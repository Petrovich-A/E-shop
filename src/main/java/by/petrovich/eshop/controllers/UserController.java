package by.petrovich.eshop.controllers;

import by.petrovich.eshop.dto.CartDto;
import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.PageName.PROFILE_PAGE;
import static by.petrovich.eshop.PageName.LOGIN_PAGE;

@Controller
@SessionAttributes({"user", "cartDto"})
@RequestMapping("/users")
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

    @PostMapping("/signup")
    public ModelAndView signUp(@ModelAttribute("registration_form_dto") @Valid RegistrationFormDto registrationFormDto,
                               ModelAndView model) {
        model.addObject("registration_form_dto", registrationFormDto);
        userService.register(registrationFormDto);
        return new ModelAndView(LOGIN_PAGE);
    }

//    @GetMapping("/logout")
//    public ModelAndView deleteFromSession(@ModelAttribute User user, WebRequest webRequest, SessionStatus sessionStatus) {
//        sessionStatus.setComplete();
//        webRequest.removeAttribute("user", WebRequest.SCOPE_SESSION);
//        return new ModelAndView("redirect:/home");
//    }

}