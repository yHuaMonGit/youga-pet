package com.youga.function.saserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class IndexController {
    @RequestMapping("/index")
    public String index() {
        System.out.println("in to here ");
        return "index";
    }
}
