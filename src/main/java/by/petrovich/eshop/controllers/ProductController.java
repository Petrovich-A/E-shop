package by.petrovich.eshop.controllers;

import by.petrovich.eshop.model.Product;
import by.petrovich.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static by.petrovich.eshop.PathToPage.PRODUCT_PAGE;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ModelAndView showProductPage(
            @PathVariable("productId") Integer productId) {
        ModelMap model = new ModelMap();
        Optional<Product> product = productService.findById(productId);
        model.addAttribute("product", product.get());
        return new ModelAndView(PRODUCT_PAGE.getPath(), model);
    }

}