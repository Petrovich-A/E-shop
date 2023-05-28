package by.petrovich.eshop.controllers;

import by.petrovich.eshop.entity.Product;
import by.petrovich.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @GetMapping("/search")
    public ModelAndView advancedSearch(
            @RequestParam("searchKey") String searchKey) {
        ModelMap model = new ModelMap();
        Set<Product> products = productService.searchProductsByNameAndDescription(searchKey);
        model.addAttribute("products", products);
        return new ModelAndView(PRODUCT_PAGE.getPath(), model);
    }

    @RequestMapping(value = "/listProducts", method = RequestMethod.GET)
    public ModelAndView listProducts(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        ModelMap model = new ModelMap();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Page<Product> productPage = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("productPage", productPage);
        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return new ModelAndView(PRODUCT_PAGE.getPath(), model);
    }

}