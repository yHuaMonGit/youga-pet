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
     * 发送验证码
     * 功能点:首次登陆用户/未注册用户手机绑定短信验证码
     */
    public String sendVerificationSMS();

    /***
     * 注册会员信息
     */
    public String registerMember(WxInfo user,String msisdn,String verificationCode);

    /***
     * 查询会员信息
     * 功能点:初始化会员信息页面
     */
    public MemberInfo getMemberInfo(String openid);



}
