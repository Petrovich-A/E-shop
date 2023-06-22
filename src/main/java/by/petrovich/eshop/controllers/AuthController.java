package by.petrovich.eshop.controllers;

import by.petrovich.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.PageName.SIGN_IN_PAGE;
import static by.petrovich.eshop.PageName.SIGN_UP_PAGE;

@RestController
@SessionAttributes("USER")
@RequestMapping("/signing")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/redirectToSignInPage")
    public ModelAndView showSignInPage() {
        return new ModelAndView(SIGN_IN_PAGE);
    }

    @GetMapping("/redirectToSignUpPage")
    public ModelAndView showSignUpPage() {
        return new ModelAndView(SIGN_UP_PAGE);
    }

}
