package com.youga.function.saserver.dao;

import com.youga.function.saserver.obj.VerifyCode;

public interface VerifyDao {

    /**
     * ������֤����Ϣ
     */
    public void insertVerifyCode(VerifyCode code);

    /**
     * ��ȡ��֤����Ϣ
     */
    public VerifyCode getVerifyCode(String openid);

    /**
     * ɾ����֤����Ϣ
     */
    public void  deleteVerifyCode(String openid);



}
