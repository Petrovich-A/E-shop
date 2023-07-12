package by.petrovich.eshop.controller;

import by.petrovich.eshop.dto.CartDto;
import by.petrovich.eshop.service.CategoryService;
import by.petrovich.eshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.utils.PageName.ADMIN_PAGE;
import static by.petrovich.eshop.utils.PageName.CART_PAGE;
import static by.petrovich.eshop.utils.PageName.HOME_PAGE;
import static by.petrovich.eshop.utils.PageName.LOGIN_PAGE;
import static by.petrovich.eshop.utils.PageName.PROFILE_PAGE;
import static by.petrovich.eshop.utils.PageName.REGISTRATION_PAGE;

@RestController
@RequiredArgsConstructor
@SessionAttributes({"cartDto"})
public class GoToController {
    private final CategoryService categoryService;
    private final UserService userService;

    @ModelAttribute("cartDto")
    public CartDto initializeCartSessionObject() {
        return new CartDto();
    }

    @GetMapping("/home")
    public ModelAndView showHomePage() {
        ModelMap model = new ModelMap();
        model.addAttribute("categories", categoryService.findAll());
        return new ModelAndView(HOME_PAGE, model);
    }

    @GetMapping("/admin")
    public ModelAndView showAdminPage() {
        ModelMap model = new ModelMap();
        model.addAttribute("users", userService.findAll());
        return new ModelAndView(ADMIN_PAGE, model);
    }

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        return new ModelAndView(LOGIN_PAGE);
    }

    @GetMapping("/registration")
    public ModelAndView showRegistrationPage() {
        return new ModelAndView(REGISTRATION_PAGE);
    }

    @GetMapping("/cart")
    public ModelAndView showCartPage() {
        return new ModelAndView(CART_PAGE);
    }

    @GetMapping("/profile")
    public ModelAndView showProfilePage() {
        return new ModelAndView(PROFILE_PAGE);
    }

}
