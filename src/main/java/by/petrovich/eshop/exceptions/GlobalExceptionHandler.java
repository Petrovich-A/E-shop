package by.petrovich.eshop.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.PageName.ERROR_PAGE;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(Controller.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleUserNotFoundException(UserNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
        modelAndView.addObject("userNotFoundException", ex.getMessage());
        logger.error("error", ex);
        return modelAndView;
    }

}