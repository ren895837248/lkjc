package com.lkjc.consumablesmanager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/toindex",method = {RequestMethod.GET,RequestMethod.POST})
    public String toIndex() {
        return "redirect:index";
    }
    @RequestMapping(path = "/index",method = {RequestMethod.GET,RequestMethod.POST})
    public String index() {
        return "index";
    }
}

