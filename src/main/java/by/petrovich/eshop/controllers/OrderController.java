package by.petrovich.eshop.controllers;

import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.PathToPage.HOME_PAGE;
import static by.petrovich.eshop.PathToPage.ORDER_PAGE;

@Controller
@SessionAttributes({"user"})
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ModelAttribute("user")
    public User User() {
        return new User();
    }

    @GetMapping("/read/{userId}")
    public ModelAndView addProductToCart(@PathVariable("userId") String userId) {
        ModelMap modelParams = new ModelMap();
        if (userId != null) {
            Integer id = Integer.parseInt(userId);
            modelParams.addAttribute("orders", orderService.read(id));
        } else {
            return new ModelAndView(HOME_PAGE.getPath(), modelParams);
        }
        return new ModelAndView(ORDER_PAGE.getPath(), modelParams);
    }

}