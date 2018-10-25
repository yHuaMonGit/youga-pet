package com.youga.function.saserver.service;

import com.youga.function.saserver.obj.MemberInfo;
import com.youga.function.saserver.obj.WxInfo;

public interface MemberService {

    /***
     * 检查用户是否会员
     * 功能点:检测首次登陆
     */
    public String isMember(String openid);

    /***
     * 微信信息入库
     */
    public String insertUser(WxInfo user);

    /***
     * 更新用户信息
     */
    public String updataUser(WxInfo user);

    /**
     * 获取用户微信信息
     */
    public WxInfo getWxInfo(String openid);

    /***
     * 发送验证码
     * 功能点:首次登陆用户/未注册用户手机绑定短信验证码
     */
    public String sendVerificationSMS();

    /***
     * 注册会员信息
     */
    public String registerMember(WxInfo user,String msisdn);

    /***
     * 查询会员信息
     * 功能点:初始化会员信息页面
     */
    public MemberInfo getMemberInfo(String openid);

    /***
     * 查询是否为会员/是否绑定手机号
     * 注册信息
     */
    String CheckMember(String userId);
}
