package com.youga.function.saserver.dao;

import com.youga.function.saserver.obj.MemberInfo;
import com.youga.function.saserver.obj.WxInfo;

public interface MemberDao {

    /***
     * 检查openid是否存在
     */
    public String isOpenidExist(String openid);

    /***
     * 插入WxInfo
     */
    public String insertWxInfo(WxInfo wxInfo);

    /***
     * 修改WxInfo(信息变更)
     */
    public  String modifyWxInfo(WxInfo wxInfo);

    /***
     * 查询验证码
     */
    public String getVeriCode();

    /***
     * 插入会员信息
     */
    public String insertMemberInfo(MemberInfo memberInfo);


    /***
     * 查询会员信息
     */
    public MemberInfo getMemberInfo(String openid);

    /***
     * 会员信息变更(手机号变更)
     */
    public String updateMemberInfo(MemberInfo memberInfo);

    /**
     * 查询是否注册会员
     * @param openid
     * @return
     */
    public String isMemberExist(String openid);

    /**
     * 获取用户微信信息
     * @param openid
     * @return
     */
    public WxInfo getWxInfo(String openid);
}
