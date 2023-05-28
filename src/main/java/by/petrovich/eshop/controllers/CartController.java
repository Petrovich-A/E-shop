package by.petrovich.eshop.controllers;

import by.petrovich.eshop.model.Cart;
import by.petrovich.eshop.entity.Product;
import by.petrovich.eshop.service.CartService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static by.petrovich.eshop.PathToPage.CART_PAGE;

@RestController
@SessionAttributes({"cart"})
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/add")
    public ModelAndView addProductToCart(@RequestParam("product_id") String id, @ModelAttribute("cart") Cart cart) {
        Integer productId = Integer.parseInt(id);
        ModelMap modelParams = new ModelMap();
        Optional<Product> products = cartService.addProductToCart(productId, cart);
        products.ifPresent(cart::addProduct);
        modelParams.addAttribute("products", products);
        modelParams.addAttribute("cart", cart);
        return new ModelAndView(CART_PAGE.getPath(), modelParams);
    }

    @GetMapping("/redirectToCartPage")
    public ModelAndView showCartPage() {
        return new ModelAndView(CART_PAGE.getPath());
    }

    @ModelAttribute("cart")
    public Cart Cart() {
        return new Cart();
    }
}