package com.youga.function.saserver.dao.impl;

import com.youga.function.saserver.dao.BaseDao;
import com.youga.function.saserver.dao.MemberDao;
import com.youga.function.saserver.obj.MemberInfo;
import com.youga.function.saserver.obj.ReturnCode;
import com.youga.function.saserver.obj.WxInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDaoImpl implements MemberDao {
    @Override
    public String isOpenidExist(String openid) {
        String retrunCode = null;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            String sql = "select count(1) from youga_pet.user_wx_info where openid = \""+openid+"\";";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int rows = rs.getInt(1);
                if ( rows > 0 && rows <= 1 )
                {
                    retrunCode = ReturnCode.SUCCESS_CODE;
                }
                else if ( rows == 0 )
                {
                    retrunCode =  ReturnCode.OPENID_NOD_FOUND;
                }
                else if ( rows > 1 )
                {
                    retrunCode = ReturnCode.OPENID_REPEAT;
                }
            }
            BaseDao.closeAll(conn, stmt, rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retrunCode;
    }

    @Override
    public String insertWxInfo(WxInfo wxInfo) {

        String retrunCode = null;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            String sql;
            sql = "insert into youga_pet.user_wx_info (openid,username,headimgurl,country,province,city,sex) " +
                    "value ( \"" +wxInfo.getUserId()+"\""+
                    ",\"" +wxInfo.getUserName()+"\""+
                    ",\"" +wxInfo.getHeadimgurl()+
                    "\",\"" +wxInfo.getCountry()+
                    "\",\"" +wxInfo.getProvince()+
                    "\",\"" +wxInfo.getCity()+
                    "\",\""+wxInfo.getSex()+ "\");";

            PreparedStatement stmt = conn.prepareStatement(sql);
            int result = stmt.executeUpdate();

            if ( 1 == result )
            {
                retrunCode = ReturnCode.SUCCESS_CODE;
            }
            else {
                retrunCode = ReturnCode.INSERT_ERROR;
            }

            BaseDao.closeAll(conn, stmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retrunCode;
    }

    @Override
    public String modifyWxInfo(WxInfo wxInfo) {
        String retrunCode = null;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            String sql;
            sql = "update youga_pet.user_wx_info set username = \""
                    +wxInfo.getUserName()+"\","+
                    "headimgurl = \"" +wxInfo.getHeadimgurl()+
                    "\",country = \"" +wxInfo.getCountry()+
                    "\",province = \"" +wxInfo.getProvince()+
                    "\",city = \"" +wxInfo.getCity()+
                    "\" Where openid = \""+wxInfo.getUserId()+"\";";

            PreparedStatement stmt = conn.prepareStatement(sql);
            int result = stmt.executeUpdate();

            if ( 0 == result )
            {
                retrunCode = ReturnCode.SUCCESS_CODE;
            }
            else
            {
                retrunCode = ReturnCode.MODIFY_ERROR;
            }

            BaseDao.closeAll(conn, stmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retrunCode;
    }

    @Override
    public String getVeriCode() {
        return null;
    }

    @Override
    public String insertMemberInfo(MemberInfo memberInfo) {
        String retrunCode = null;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            String sql;
            sql = "insert into youga_pet.member_info (openid,memberID,username,msisdn,integral,memberFlag,memberLevel,Amount,balance) " +
                    "value ( \"" +memberInfo.getOpenid()+"\""+
                    ",\"" +memberInfo.getMemberID()+"\""+
                    ",\"" +memberInfo.getOpenid()+
                    "\",\"" +memberInfo.getMsisdn()+
                    "\",\"" +memberInfo.getIntegral()+
                    "\",\"" +memberInfo.getMemberFlag()+
                    "\",\"" +memberInfo.getMemberLevel()+
                    "\",\"" +memberInfo.getAmount()+
                    "\",\"" +memberInfo.getBalance()+ "\");";

            PreparedStatement stmt = conn.prepareStatement(sql);
            int result = stmt.executeUpdate();

            if ( 1 == result )
            {
                retrunCode = ReturnCode.SUCCESS_CODE;
            }
            else {
                retrunCode = ReturnCode.INSERT_ERROR;
            }

            BaseDao.closeAll(conn, stmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retrunCode;
    }

    @Override
    public MemberInfo getMemberInfo(String openid) {
        Connection conn = null;
        MemberInfo member = null;
        try {
            conn = BaseDao.getConnection();
            String sql = "select * from youga_pet.member_info where openid = \""+openid+"\";";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                rs.previous();
            }
            else {
                return new MemberInfo();
            }

            while(rs.next())
            {
                member =new MemberInfo(
                        rs.getString("memberID"),
                        rs.getString("memberLevel"),
                        rs.getString("integral"),
                        rs.getString("memberFlag"),
                        rs.getString("msisdn"),
                        rs.getString("openid"),
                        rs.getString("Amount"),
                        rs.getString("balance")
                );
            }
            BaseDao.closeAll(conn, stmt, rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public String updateMemberInfo(MemberInfo memberInfo) {
        return null;
    }

    @Override
    public String isMemberExist(String openid) {
        String retrunCode = null;
        Connection conn = null;
        try {
            conn = BaseDao.getConnection();
            String sql = "select count(1) from youga_pet.member_info where openid = \""+openid+"\";";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int rows = rs.getInt(1);
                if ( rows > 0 && rows <= 1 )
                {
                    retrunCode = ReturnCode.MEMBER_EXIST;
                }
                else if ( rows == 0 )
                {
                    retrunCode =  ReturnCode.MEMBER_NOD_FOUND;
                }
                else if ( rows > 1 )
                {
                    retrunCode = ReturnCode.MEMBER_REPEAT;
                }
            }
            BaseDao.closeAll(conn, stmt, rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retrunCode;
    }

    @Override
    public WxInfo getWxInfo(String openid) {
        Connection conn = null;
        WxInfo wxInfo = null;
        try {
            conn = BaseDao.getConnection();
            String sql = "select * from youga_pet.user_wx_info where openid = \""+openid+"\";";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                rs.previous();
            }
            else {
                return new WxInfo();
            }

            while(rs.next())
            {
                wxInfo =new WxInfo(
                        rs.getString("username"),
                        rs.getString("openid"),
                        rs.getString("headimgurl"),
                        rs.getString("country"),
                        rs.getString("city"),
                        rs.getString("province"),
                        rs.getString("sex")
                );
            }
            BaseDao.closeAll(conn, stmt, rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wxInfo;
    }
}
