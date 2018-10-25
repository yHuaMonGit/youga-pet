package com.youga.function.saserver.dao.impl;

import com.youga.function.saserver.dao.BaseDao;
import com.youga.function.saserver.dao.GoodsDao;
import com.youga.function.saserver.obj.GoodsInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {


    List<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();


    @Override
    public List<GoodsInfo> findAllPets()  {

        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            String sql = "select * from double_eleven_goods_info;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                GoodsInfo goods=new GoodsInfo(
                    rs.getString("goodsName"),
                    rs.getInt("goodsPrice"),
                    rs.getInt("goodsNum"),
                    rs.getString("goodsDes"),
                    rs.getString("goodsPic"),
                    rs.getInt("goodsPrePrice")
                );
                goodsList.add(goods);
            }
            BaseDao.closeAll(conn, stmt, rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goodsList;
    }
}
