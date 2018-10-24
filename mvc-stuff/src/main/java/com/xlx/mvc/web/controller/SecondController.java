package com.xlx.mvc.web.controller;


import com.xlx.mvc.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

@Controller
@RequestMapping("/v2")
public class SecondController {

    @GetMapping("/npe")
    @ResponseBody
    public String npe2() throws NullPointerException {
        throw new NullPointerException();
    }

    @Autowired
    WebApplicationContext context;

    @Autowired
    @GetMapping("/getMyService")
    @ResponseBody
    public String getMyService() {
        return context.getBean("myService").toString();
    }
}
