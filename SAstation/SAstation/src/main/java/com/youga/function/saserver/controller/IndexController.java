package com.youga.function.saserver.controller;

import com.youga.function.saserver.obj.GoodsInfo;
import com.youga.function.saserver.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/home")
public class IndexController {

    GoodsInfo good1 ;

    @RequestMapping("/index")
    public String index() {
        System.out.println("is here");
        return "index";
    }

    @RequestMapping("/sellCenter")
    public String sellCenter(HttpServletRequest request, Model model) {

        good1 = GoodsService.getgood();

        model.addAttribute("good1",good1);

        return "sellCenter";
    }


}
