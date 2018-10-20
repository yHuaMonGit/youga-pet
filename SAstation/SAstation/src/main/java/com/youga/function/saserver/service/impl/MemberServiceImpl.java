package com.youga.function.saserver.service.impl;

import com.youga.function.saserver.obj.MemberInfo;
import com.youga.function.saserver.obj.WxInfo;
import com.youga.function.saserver.service.MemberService;

public class MemberServiceImpl implements MemberService {
    @Override
    public String isMember(String openid) {
        return null;
    }

    @Override
    public String sendVerificationSMS() {
        return null;
    }

    @Override
    public String registerMember(WxInfo user, String msisdn, String verificationCode) {
        return null;
    }

    @Override
    public MemberInfo getMemberInfo(String openid) {
        return null;
    }
}
