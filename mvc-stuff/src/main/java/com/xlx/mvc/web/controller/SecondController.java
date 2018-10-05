package com.xlx.mvc.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v2")
public class SecondController {

    @GetMapping("/npe")
    @ResponseBody
    public String npe2() throws NullPointerException {
        throw new NullPointerException();
    }
}
