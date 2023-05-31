package by.petrovich.eshop.controllers;

import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.model.Cart;
import by.petrovich.eshop.service.CartService;
import by.petrovich.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.PathToPage.CART_PAGE;
import static by.petrovich.eshop.PathToPage.HOME_PAGE;

@RestController
@SessionAttributes({"cart"})
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final OrderService orderService;

    @Autowired
    public CartController(CartService cartService, OrderService orderService) {
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @ModelAttribute("cart")
    public Cart Cart() {
        return new Cart();
    }

    @GetMapping("/redirectToCartPage")
    public ModelAndView showCartPage() {
        return new ModelAndView(CART_PAGE.getPath());
    }

    @GetMapping("/add")
    public ModelAndView addProductToCart(@RequestParam("product_id") String id,
                                         @ModelAttribute("cart") Cart cart) {
        ModelMap modelParams = new ModelMap();
        if (cart != null && id != null) {
            Integer productId = Integer.parseInt(id);
            cart = cartService.addProductToCart(productId, cart);
            modelParams.addAttribute("cart", cart);
            modelParams.addAttribute("products", cart.getProducts());
        } else {
            return new ModelAndView(HOME_PAGE.getPath(), modelParams);
        }
        return new ModelAndView(CART_PAGE.getPath(), modelParams);
    }

    @GetMapping("/remove")
    public ModelAndView removeProductFromCart(@RequestParam("product_id") String id,
                                              @ModelAttribute("cart") Cart cart) {
        ModelMap modelParams = new ModelMap();
        if (cart != null && id != null) {
            Integer productId = Integer.parseInt(id);
            cart.removeProduct(productId);
            modelParams.addAttribute("cart", cart);
            modelParams.addAttribute("products", cart.getProducts());
        }
        return new ModelAndView(CART_PAGE.getPath(), modelParams);
    }

    @GetMapping("/clear")
    public ModelAndView clearCart(@ModelAttribute("cart") Cart cart) {
        ModelMap modelParams = new ModelMap();
        if (cart != null) {
            cart.clear();
            modelParams.addAttribute("cart", cart);
        }
        return new ModelAndView(CART_PAGE.getPath(), modelParams);
    }

    @GetMapping("/order")
    public ModelAndView order(@ModelAttribute("cart") Cart cart,
                              @ModelAttribute("user") User user) {
        ModelMap modelParams = new ModelMap();
        if (cart != null && user != null) {
            Integer userId = user.getUserId();
            orderService.save(cart, userId);
            cart.clear();
            modelParams.addAttribute("cart", cart);
        }
        return new ModelAndView(CART_PAGE.getPath(), modelParams);
    }

}