package com.youga.function.saserver.controller;

import com.youga.function.saserver.obj.GoodsInfo;
import com.youga.function.saserver.service.GoodsService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String sellCenter(HttpServletRequest request, ModelMap model) {

        goodslist = GoodsService.getgood();

        String goodslistString = JSONArray.fromObject(goodslist).toString();

        model.addAttribute("goodslistJson",goodslistString);

        return "sellCenter";
    }


}
