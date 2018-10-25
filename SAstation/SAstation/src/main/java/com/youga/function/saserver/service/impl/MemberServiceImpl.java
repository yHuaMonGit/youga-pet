package com.youga.function.saserver.service.impl;

import com.youga.function.saserver.dao.MemberDao;
import com.youga.function.saserver.dao.impl.MemberDaoImpl;
import com.youga.function.saserver.obj.MemberInfo;
import com.youga.function.saserver.obj.ReturnCode;
import com.youga.function.saserver.obj.WxInfo;
import com.youga.function.saserver.service.MemberService;

public class MemberServiceImpl implements MemberService {

    MemberDao memberDao = new MemberDaoImpl();
    @Override
    public String isMember(String openid) {

        String result = memberDao.isOpenidExist(openid);

        if (ReturnCode.SUCCESS_CODE.equals(result))
        {
            return ReturnCode.OPENID_EXIST;
        }
        else if(ReturnCode.OPENID_REPEAT.equals(result)){
            return ReturnCode.OPENID_REPEAT;
        }
        else if (ReturnCode.OPENID_NOD_FOUND.equals(result))
        {
            return ReturnCode.OPENID_NOD_FOUND;
        }
        return ReturnCode.NORMAL_ERROR_CODE;

    }

    @Override
    public String insertUser(WxInfo user) {
        if (ReturnCode.SUCCESS_CODE.equals(memberDao.insertWxInfo(user)))
        {
            return ReturnCode.OPENID_EXIST;
        }
        else
        {
            return ReturnCode.INSERT_ERROR;
        }
    }

    @Override
    public String updataUser(WxInfo user) {
        if (ReturnCode.SUCCESS_CODE.equals(memberDao.modifyWxInfo(user)))
        {
            return ReturnCode.OPENID_EXIST;
        }
        else
        {
            return ReturnCode.MODIFY_ERROR;
        }
    }

    @Override
    public WxInfo getWxInfo(String openid) {

        return memberDao.getWxInfo(openid);

    }

    @Override
    public String sendVerificationSMS() {
        return null;
    }

    @Override
    public String registerMember(WxInfo user, String msisdn) {
        MemberInfo member = new MemberInfo(
                user.getUserId(),
                MemberInfo.MEMBER_LEVEL_1,
                "0",
                "1",
                msisdn,
                user.getUserId(),
                "0",
                "0");

        String inserResult = memberDao.insertMemberInfo(member);
        if (ReturnCode.SUCCESS_CODE.equals(inserResult))
        {
            return ReturnCode.SUCCESS_CODE;
        }
        else
        {
            return ReturnCode.INSERT_ERROR;
        }


    }

    @Override
    public MemberInfo getMemberInfo(String openid) {
        return memberDao.getMemberInfo(openid);
    }

    @Override
    public String CheckMember(String openid) {
        String result = memberDao.isMemberExist(openid);

        if (ReturnCode.MEMBER_EXIST.equals(result))
        {
            return ReturnCode.MEMBER_EXIST;
        }
        else if(ReturnCode.MEMBER_REPEAT.equals(result)){
            return ReturnCode.MEMBER_REPEAT;
        }
        else if (ReturnCode.MEMBER_NOD_FOUND.equals(result))
        {
            return ReturnCode.MEMBER_NOD_FOUND;
        }
        return ReturnCode.NORMAL_ERROR_CODE;
    }
}
