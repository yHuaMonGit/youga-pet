package com.youga.function.saserver.service;

public interface VerifyService {
    /**
     * ?????
     */
    public void createVerifyCode(String openid);

    /**
     * ?????
     */
    public void sendSMS(String msisdn,String openid);

    /**
     * ?????
     */
    public String checkVerifyCode(String openid,String vcode);
}
