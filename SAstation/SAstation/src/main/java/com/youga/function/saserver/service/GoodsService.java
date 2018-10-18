package com.youga.function.saserver.service;

import com.youga.function.saserver.obj.GoodsInfo;

public class GoodsService {
    public static GoodsInfo getgood() {

        GoodsInfo goods = new GoodsInfo();

        goods.set_goosName("伯纳天纯无谷低敏系列小型犬幼犬");
        goods.set_goosNum(10000);
        goods.set_goosPrice(79);
        goods.set_goosIndroduce("its good for dog !");

        return goods;
    }
}
