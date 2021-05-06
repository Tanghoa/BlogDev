package com.lrm.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//contorller控制异常处理
@ControllerAdvice
public class ControExceptionHandlerr {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(Exception.class)
    public ModelAndView handler(HttpServletRequest re , Exception e){
        ModelAndView   model = new ModelAndView();
        logger.error("request url,{}: exception :{}",re.getRequestURL(),e);
        model.addObject("url",re.getRequestURL());
        model.addObject("exception",e);
        model.setViewName("error/error");
        return model;
    }
}
