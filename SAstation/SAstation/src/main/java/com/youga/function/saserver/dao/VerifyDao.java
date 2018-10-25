package com.youga.function.saserver.dao;

import com.youga.function.saserver.obj.VerifyCode;

public interface VerifyDao {

    /**
     * 创建验证码信息
     */
    public void insertVerifyCode(VerifyCode code);

    /**
     * 获取验证码信息
     */
    public VerifyCode getVerifyCode(String openid);

    /**
     * 删除验证码信息
     */
    public void  deleteVerifyCode(String openid);



}
