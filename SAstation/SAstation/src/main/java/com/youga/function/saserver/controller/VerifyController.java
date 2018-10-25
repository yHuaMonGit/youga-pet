package com.youga.function.saserver.controller;

import com.youga.function.saserver.obj.ReturnCode;
import com.youga.function.saserver.service.MemberService;
import com.youga.function.saserver.service.VerifyService;
import com.youga.function.saserver.service.impl.MemberServiceImpl;
import com.youga.function.saserver.service.impl.VerifyServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/verify")
public class VerifyController {

    VerifyService verifyService = new VerifyServiceImpl();
    MemberService memberService = new MemberServiceImpl();


    @RequestMapping("/getVerify")
    public void center(HttpServletRequest req,HttpServletResponse resp, ModelMap model) throws IOException {


        String openid = req.getParameter("openid");
        String msisdn = req.getParameter("msisdn");
        verifyService.createVerifyCode(openid);
        verifyService.sendSMS(msisdn,openid);

        resp.getWriter().print(ReturnCode.SMS_SUCCESS);

    }

    @RequestMapping("/checkVerify")
    public void checkVerfiy(HttpServletRequest req, HttpServletResponse resp, ModelMap model) throws IOException {


        String openid = req.getParameter("openid");
        String msisdn = req.getParameter("msisdn");
        String vericode = req.getParameter("vericode");


        String veriResult = verifyService.checkVerifyCode(openid,vericode);

        if (ReturnCode.VERIFY_ACCESS.equals(veriResult))
        {
             String registResult = memberService.registerMember(memberService.getWxInfo(openid),msisdn);
             if(ReturnCode.SUCCESS_CODE.equals(registResult))
             {
                 resp.getWriter().print(ReturnCode.SUCCESS_CODE);
             }
             else {

             }
        }

    }

}
