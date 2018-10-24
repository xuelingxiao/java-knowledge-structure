package com.xlx.mvc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@ManagedResource(objectName = "mvc:name=HomeController")
public class HomeController {

    @GetMapping("/npe1")
    @ResponseBody
    public String npe1() throws NullPointerException {
        throw new NullPointerException();
    }

    @GetMapping("/npe2")
    @ResponseBody
    @ManagedOperation
    public String npe2() throws NullPointerException {
        throw new NullPointerException();
    }

    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseBody
    public String npehandler(){
        return "test npe handler";
    }

    @GetMapping("/")
    @ResponseBody
    @ManagedOperation
    public String hello() throws BindException {
        throw new BindException(new Object(),"test");
    }

    @GetMapping("/responseStatus")
    @ResponseBody
    public String responseStatus() throws MyException {
        throw new MyException();
    }

    @ResponseStatus(code = HttpStatus.BAD_GATEWAY)
    public class MyException extends Exception{}
}
