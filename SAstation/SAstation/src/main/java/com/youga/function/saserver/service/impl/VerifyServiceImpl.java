package com.youga.function.saserver.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.youga.function.saserver.dao.VerifyDao;
import com.youga.function.saserver.dao.impl.VerifyDaoImpl;
import com.youga.function.saserver.obj.ReturnCode;
import com.youga.function.saserver.obj.VerifyCode;
import com.youga.function.saserver.service.VerifyService;
import com.youga.tools.wx.auth.authUtil.SMSUtil;
import com.youga.tools.wx.auth.authUtil.TimeUtil;
import com.youga.tools.wx.auth.authUtil.VerifyUtil;

public class VerifyServiceImpl implements VerifyService {

    VerifyDao verifyDao = new VerifyDaoImpl();

    @Override
    public void createVerifyCode(String openid) {

        String verifyCode = VerifyUtil.produceVerifyCode();
        String currenttime = TimeUtil.getCurrentTime();
        VerifyCode vcode = new VerifyCode(verifyCode,currenttime,openid,"0");

        VerifyCode oldvcode = verifyDao.getVerifyCode(openid);
        if(null == oldvcode.getCode() || "".equals(oldvcode.getCode()) )
        {
            verifyDao.insertVerifyCode(vcode);
        }
        else
            {
                verifyDao.deleteVerifyCode(openid);
                verifyDao.insertVerifyCode(vcode);
            }

    }

    @Override
    public void sendSMS(String msisdn,String openid) {

        VerifyCode code = verifyDao.getVerifyCode(openid);
        try {
            SMSUtil.sendSms(msisdn,code.getCode());
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String checkVerifyCode(String openid, String vcode) {

        VerifyCode oriObj = verifyDao.getVerifyCode(openid);
        if (!vcode.equals(oriObj.getCode()))
        {
            return ReturnCode.VERIFY_ERROR;
        }
        String oriTime = oriObj.getStartTime();
        String currentTime = TimeUtil.getCurrentTime();
        String compareResult = TimeUtil.TimeCompare(oriTime,currentTime,300);
        if (ReturnCode.TIME_NULL.equals(compareResult))
        {
            return ReturnCode.VERIFY_ERROR;
        }
        else if (ReturnCode.VERIFY_EFFECTIVE.equals(compareResult))
        {
            verifyDao.deleteVerifyCode(oriObj.getOpenid());
            return ReturnCode.VERIFY_ACCESS;
        }
        else if ( ReturnCode.VERIFY_INVALID.equals(compareResult) )
        {
            verifyDao.deleteVerifyCode(oriObj.getOpenid());
            return ReturnCode.VERIFY_INVALID;
        }

        return ReturnCode.NORMAL_ERROR_CODE;
    }
}
