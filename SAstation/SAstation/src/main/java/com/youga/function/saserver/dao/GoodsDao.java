package com.youga.function.saserver.dao;

import com.youga.function.saserver.obj.GoodsInfo;

import java.util.List;

public interface GoodsDao {

    /**
     * 查询当前所有售卖商品
     */
    List<GoodsInfo> findAllPets() ;

}
