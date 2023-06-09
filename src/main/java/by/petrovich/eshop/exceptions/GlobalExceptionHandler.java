package by.petrovich.eshop.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.utils.PageName.ERROR_PAGE;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFoundException(UserNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
        modelAndView.addObject("User not found", ex.getMessage());
        log.error("User not found", ex);
        return modelAndView;
    }

}