package by.petrovich.eshop.controllers;

import by.petrovich.eshop.entity.Cart;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.service.CartService;
import by.petrovich.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/add/{productId}")
    public ModelAndView addProductToCart(@PathVariable("productId") String productId,
                                         @ModelAttribute("cart") Cart cart) {
        ModelMap modelParams = new ModelMap();
        if (productId != null) {
            Integer id = Integer.parseInt(productId);
            modelParams.addAttribute("cart", cartService.addProduct(id, cart));
        } else {
            return new ModelAndView(HOME_PAGE.getPath(), modelParams);
        }
        return new ModelAndView(CART_PAGE.getPath(), modelParams);
    }

    @PostMapping("/remove/{productId}")
    public ModelAndView removeProductFromCart(@PathVariable("productId") String productId,
                                              @ModelAttribute("cart") Cart cart) {
        ModelMap modelParams = new ModelMap();
        if (productId != null) {
            Integer id = Integer.parseInt(productId);
            modelParams.addAttribute("cart", cartService.removeProduct(id, cart));
        }
        return new ModelAndView(CART_PAGE.getPath(), modelParams);
    }

    @PostMapping("/clear")
    public ModelAndView clearCart(@ModelAttribute("cart") Cart cart) {
        ModelMap modelParams = new ModelMap();
        modelParams.addAttribute("cart", cartService.clear(cart));
        return new ModelAndView(HOME_PAGE.getPath());
    }

    @PostMapping("/order")
    public ModelAndView order(@ModelAttribute("cart") Cart cart,
                              @ModelAttribute("user") User user) {
        ModelMap modelParams = new ModelMap();
        if (cart != null && user != null) {
            Integer userId = user.getUserId();
            orderService.save(cart, userId);
            modelParams.addAttribute("cart", cart);
        }
        return new ModelAndView(CART_PAGE.getPath(), modelParams);
    }

}