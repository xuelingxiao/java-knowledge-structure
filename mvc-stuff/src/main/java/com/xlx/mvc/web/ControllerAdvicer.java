package com.xlx.mvc.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerAdvicer {

    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseBody
    public String npehandler(){
        return "test npe handler in advice";
    }
}
