package com.ipiecoles.java.java320.controller;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    //1 méthode par type d'exception
    //EntityNotFoundException => 404, en utilisant le template erreur (afficher le message d'erreur)
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleENFE(EntityNotFoundException e){
        ModelAndView model = new ModelAndView("erreur");
        model.addObject("statut", 404);
        model.addObject("message", e.getMessage());
        return model;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleENFE(IllegalArgumentException e) {
        ModelAndView model = new ModelAndView("erreur");
        model.addObject("statut", 400);
        model.addObject("message", e.getMessage());
        return model;
    }

}
