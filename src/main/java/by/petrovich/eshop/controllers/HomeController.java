package by.petrovich.eshop.controllers;

import by.petrovich.eshop.entity.Category;
import by.petrovich.eshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static by.petrovich.eshop.PathToPage.HOME_PAGE;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final CategoryService categoryService;

    @Autowired
    public HomeController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ModelAndView showHomePage() {
        ModelMap model = new ModelMap();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return new ModelAndView(HOME_PAGE.getPath(), model);
    }

}