package by.petrovich.eshop.controllers;

import by.petrovich.eshop.entity.Product;
import by.petrovich.eshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            @PathVariable Integer categoryId,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        ModelMap model = new ModelMap();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Page<Product> productPage = categoryService.findProductsByCategoryId(categoryId, PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("productPage", productPage);
        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return new ModelAndView(CATEGORY_PAGE.getPath(), model);
    }

}