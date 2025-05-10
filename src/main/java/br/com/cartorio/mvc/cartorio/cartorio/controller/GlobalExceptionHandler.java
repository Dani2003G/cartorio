package br.com.cartorio.mvc.cartorio.cartorio.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ModelAndView handleNoResourceFoundException(NoResourceFoundException ex) {
        ModelAndView mv = new ModelAndView("paginaErro");
        mv.addObject("erro", 1);
        mv.addObject("msg", "");
        return mv;
    }

    @ExceptionHandler(ServiceException.class)
    public ModelAndView handleServiceException(ServiceException ex) {
        ModelAndView mv = new ModelAndView("paginaErro");
        mv.addObject("erro", 2);
        mv.addObject("msg", ex.getMessage());
        return mv;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(ServiceException ex) {
        ModelAndView mv = new ModelAndView("paginaErro");
        mv.addObject("erro", 1);
        return mv;
    }

}
