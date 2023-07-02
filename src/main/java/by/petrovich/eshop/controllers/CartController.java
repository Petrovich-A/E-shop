package by.petrovich.eshop.controllers;

import by.petrovich.eshop.dto.CartDto;
import by.petrovich.eshop.entity.Order;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.service.CartService;
import by.petrovich.eshop.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.PageName.CART_PAGE;
import static by.petrovich.eshop.PageName.HOME_PAGE;

@Controller
@SessionAttributes({"cartDto", "user"})
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final OrderService orderService;

    @Autowired
    public CartController(CartService cartService, OrderService orderService) {
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @ModelAttribute("cartDto")
    public CartDto initializeCartSessionObject() {
        return new CartDto();
    }

    @ModelAttribute("user")
    public User initializeUserSessionObject() {
        return new User();
    }


    @PostMapping("/add/{productId}")
    public ModelAndView addProductToCart(@PathVariable("productId") String productId,
                                         @Valid @ModelAttribute("cartDto") CartDto cartDto) {
        ModelMap modelParams = new ModelMap();
        if (productId != null) {
            Integer id = Integer.parseInt(productId);
            modelParams.addAttribute("cartDto", cartService.addProduct(id, cartDto));
            return new ModelAndView(CART_PAGE, modelParams);
        }
        return new ModelAndView(HOME_PAGE, modelParams);
    }

    @PostMapping("/remove/{productId}")
    public ModelAndView removeProductFromCart(@PathVariable("productId") String productId,
                                              @Valid @ModelAttribute("cartDto") CartDto cartDto) {
        ModelMap modelParams = new ModelMap();
        if (productId != null) {
            Integer id = Integer.parseInt(productId);
            modelParams.addAttribute("cartDto", cartService.removeProduct(id, cartDto));
            return new ModelAndView(CART_PAGE, modelParams);
        }
        return new ModelAndView(HOME_PAGE, modelParams);
    }

    @PostMapping("/clear")
    public ModelAndView clearCart(@ModelAttribute("cartDto") CartDto cartDto) {
        ModelMap modelParams = new ModelMap();
        clearCart(cartDto, modelParams);
        return new ModelAndView(CART_PAGE, modelParams);
    }

    @PostMapping("/order/{userId}")
    public ModelAndView order(@ModelAttribute("cartDto") CartDto cartDto,
                              @PathVariable("userId") String userId) {
        ModelMap modelParams = new ModelMap();
        if (cartDto != null && userId != null) {
            Integer id = Integer.valueOf(userId);
            Order savedCart = orderService.save(cartDto, id);
            if (savedCart != null) {
                clearCart(cartDto, modelParams);
            }
        }
        return new ModelAndView(CART_PAGE, modelParams);
    }

    private void clearCart(CartDto cartDto, ModelMap modelParams) {
        modelParams.addAttribute("cartDto", cartService.clear(cartDto));
    }

}