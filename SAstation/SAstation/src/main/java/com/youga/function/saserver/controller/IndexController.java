package com.youga.function.saserver.controller;

import com.youga.function.saserver.obj.GoodsInfo;
import com.youga.function.saserver.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/home")
public class IndexController {

    public List<GoodsInfo> goodslist = new ArrayList<GoodsInfo>();

    @RequestMapping("/index")
    public String index() {
        System.out.println("is here");
        return "index";
    }

    @RequestMapping("/sellCenter")
    public String sellCenter(HttpServletRequest request, Model model) {

        goodslist = GoodsService.getgood();
        int count = 1;
        for(GoodsInfo good :goodslist)
        {
            String goodsID = "goods"+count;
            model.addAttribute(goodsID,good);
            count++;
        }

        return "sellCenter";
    }


}
