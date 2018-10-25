package com.youga.function.saserver.controller;


import com.youga.function.saserver.obj.MemberInfo;
import com.youga.function.saserver.obj.ReturnCode;
import com.youga.function.saserver.obj.WxInfo;
import com.youga.function.saserver.service.MemberService;
import com.youga.function.saserver.service.impl.MemberServiceImpl;
import com.youga.tools.wx.auth.authUtil.AuthUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/member")
public class MemberController {

    MemberService mbService = new MemberServiceImpl();

    @RequestMapping("/auth")
    public void auth(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String callBack = "http://www.youga-pet.com/SAstation/member/center";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
                + AuthUtil.APPID
                + "&redirect_uri=" + URLEncoder.encode(callBack)
                + "&response_type=code"
                + "&scope=snsapi_userinfo"
                + "&state=STATE#wechat_redirect";
        resp.sendRedirect(url);

    }

    @RequestMapping("/center")
    public String center(HttpServletRequest req, HttpServletResponse resp,ModelMap model) throws IOException {

        //ҳ�����
        Map<String,String> usermap = new HashMap<String,String>();
        String code = req.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" +AuthUtil.APPID
                +"&secret="+AuthUtil.APPSECRET
                + "&code="+code
                + "&grant_type=authorization_code";
        JSONObject jsonObject = AuthUtil.doGetJson(url);
        String openid  = jsonObject.getString("openid");
        String token  = jsonObject.getString("access_token");

        //��ȡ�û���Ϣ
        String infourl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token
                + "&openid=" + openid
                + "&lang=zh_CN";
        JSONObject userInfo = AuthUtil.doGetJson(infourl);
        String userName = userInfo.getString("nickname");
        String userId = userInfo.getString("openid");
        String headimgurl = userInfo.getString("headimgurl");
        String country = userInfo.getString("country");
        String city = userInfo.getString("city");
        String province = userInfo.getString("province");
        String sex = userInfo.getString("sex");

        //���ز��Դ���
        //WxInfo testUser = new WxInfo("testU","11111111kkkkk1111","http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIZibJCINEz4Nym2gWDoKvJbMC0ePb4YzUd3oKiacouWI6ttMdJBrS9ZF4cGwOMAbdoT5FP5M4Sh8Tg/132","chine","sian","shanxi","1");
        //String userId = "11111111kkkkk1111";

        //�������
        WxInfo tmpUser = new WxInfo(userName,userId,headimgurl,country,city,province,sex);
        //���opendi�Ƿ����(�Ƿ����û�)
//        String ismember = mbService.isMember(userId);
        String isuser = mbService.isMember(userId);
        String ismember = mbService.CheckMember(userId);

        if (ReturnCode.OPENID_EXIST.equals(isuser))
        {
            //1.����Ƿ�Ϊ��Ա
            if (ReturnCode.MEMBER_EXIST.equals(ismember))
            {
                MemberInfo member = mbService.getMemberInfo(openid);
                usermap.put("level",member.getMemberLevel());
                usermap.put("integral",member.getIntegral());
                usermap.put("balance",member.getBalance());
            }
            else if ( ReturnCode.MEMBER_NOD_FOUND.equals(ismember) )
            {
                //����δע��
                usermap.put("isMember","1");
            }
            //2.������Ϣ
            mbService.updataUser(tmpUser);
            //mbService.updataUser(testUser);
        }
        else if (ReturnCode.OPENID_NOD_FOUND.equals(isuser)){
            //1.��Աע��
            usermap.put("isMember","1");
            //�����ݲ������
            if (ReturnCode.SUCCESS_CODE.equals(mbService.insertUser(tmpUser)))
            //if (ReturnCode.SUCCESS_CODE.equals(mbService.insertUser(testUser)))
            {
                //��������
            }
            else {
                //�쳣����
            }
        }else if(ReturnCode.OPENID_REPEAT.equals(isuser))
        {
            //�����ظ���¼
        }



        usermap.put("userName",userName);
        usermap.put("headIconUrl",headimgurl);
        usermap.put("openid",openid);
       // usermap.put("userName",testUser.getUserName());
       // usermap.put("headIconUrl",testUser.getHeadimgurl());
        String userInfoOut = JSONArray.fromObject(usermap).toString();


        model.addAttribute("userInfoList",userInfoOut);
        return "memberCenter";
    }

    @RequestMapping("/showcenter")
    public void showCenter(HttpServletRequest req, HttpServletResponse resp,ModelMap model) throws IOException {

        String url = "http://www.youga-pet.com/SAstation/member/membercenter";
        resp.sendRedirect(url);
    }

    @RequestMapping("/membercenter")
    public String membercenter(HttpServletRequest req, HttpServletResponse resp,ModelMap model){

        return  "sellCenter";
    }

}
