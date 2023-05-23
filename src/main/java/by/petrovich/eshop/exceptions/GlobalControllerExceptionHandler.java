package by.petrovich.eshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import static by.petrovich.eshop.PathToPage.ERROR_PAGE;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(StudentNotFoundException.class)
    public ModelAndView handleAuthException(Exception ex) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("error", ex.getMessage());
        ModelAndView model = new ModelAndView();
        model.setViewName(ERROR_PAGE.getPath());
        model.addAllObjects(modelMap);
        return model;
    }
}
