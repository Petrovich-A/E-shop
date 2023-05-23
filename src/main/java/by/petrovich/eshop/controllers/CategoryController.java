package by.petrovich.eshop.controllers;

import by.petrovich.eshop.model.Product;
import by.petrovich.eshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static by.petrovich.eshop.PathToPage.CATEGORY_PAGE;

@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{categoryId}")
    public ModelAndView showCategoryPage(
            @PathVariable Integer categoryId) {
        ModelMap model = new ModelMap();
        List<Product> products = categoryService.findProductsByCategoryId(categoryId);
        model.addAttribute("products", products);
        return new ModelAndView(CATEGORY_PAGE.getPath(), model);
    }


}