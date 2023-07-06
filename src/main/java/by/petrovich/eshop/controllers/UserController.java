package by.petrovich.eshop.controllers;

import by.petrovich.eshop.dto.CartDto;
import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping("/registrate")
    public ModelAndView registrate(@ModelAttribute("registration_form_dto") @Valid RegistrationFormDto registrationFormDto,
                                   BindingResult errors,
                                   ModelAndView model) {
        if (errors.hasErrors()) {
            throw new ValidationException((Throwable) errors);
            // TODO: 3 июл. 2023 г.  
        }
        model.addObject("registration_form_dto", registrationFormDto);
        userService.register(registrationFormDto);
        return new ModelAndView(LOGIN_PAGE);
    }

}