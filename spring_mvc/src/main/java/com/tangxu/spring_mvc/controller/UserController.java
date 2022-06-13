package com.tangxu.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/quick")
    public String save(){
        System.out.println("Controller save running");
        return "forword:/success.jsp";
    }
}
