package com.learn.web.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ldy on 2017/3/27.
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler({Exception.class})//
    public ModelAndView exception(Exception ex, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error").addObject("errorMessage",ex.getMessage());
        return modelAndView;
    }
    @ModelAttribute//3
    public void addAttributes(Model model){
        model.addAttribute("msg","其他信息");
    }
    @InitBinder//4
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");//5
    }

}
