package com.youga.function.saserver.obj;

public class MemberInfo {


    public String memberID = null ;

    public String memberLevel = null ;

    public String integral = null ;

    public String memberFlag = null ;

    public String msisdn = null ;

    public String openid = null ;
    //累计消费金额
    public String Amount = null;

    public MemberInfo(String memberID, String memberLevel, String integral, String memberFlag, String msisdn, String openid, String amount) {
        this.memberID = memberID;
        this.memberLevel = memberLevel;
        this.integral = integral;
        this.memberFlag = memberFlag;
        this.msisdn = msisdn;
        this.openid = openid;
        this.Amount = amount;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getMemberFlag() {
        return memberFlag;
    }

    public void setMemberFlag(String memberFlag) {
        this.memberFlag = memberFlag;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
