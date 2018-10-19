package com.youga.function.saserver.service;

import com.youga.function.saserver.dao.GoodsDao;
import com.youga.function.saserver.dao.impl.GoodsDaoImpl;
import com.youga.function.saserver.obj.GoodsInfo;

import java.util.ArrayList;
import java.util.List;

public class GoodsService {

    public static List<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();

    public static GoodsDao goodsDao = new GoodsDaoImpl();

    public static List<GoodsInfo> getgood() {

        goodsList = goodsDao.findAllPets();

        return goodsList;

    }
}
