package com.youga.function.saserver.controller;


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

        String code = req.getParameter("code");

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" +AuthUtil.APPID
                +"&secret="+AuthUtil.APPSECRET
                + "&code="+code
                + "&grant_type=authorization_code";

        JSONObject jsonObject = AuthUtil.doGetJson(url);

        String openid  = jsonObject.getString("openid");
        String token  = jsonObject.getString("access_token");

        //拉取用户信息
        String infourl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token
                + "&openid=" + openid
                + "&lang=zh_CN";

        JSONObject userInfo = AuthUtil.doGetJson(infourl);

        //System.out.println(userInfo);

        String userName = userInfo.getString("nickname");
        String userId = userInfo.getString("openid");
        String headimgurl = userInfo.getString("headimgurl");
        String country = userInfo.getString("country");
        String city = userInfo.getString("city");
        String province = userInfo.getString("province");
        String sex = userInfo.getString("sex");

        Map<String,String> usermap = new HashMap<String,String>();

        usermap.put("userName",userName);
        usermap.put("headIconUrl",headimgurl);

        String userInfoOut = JSONArray.fromObject(usermap).toString();

//        String userInfoOut = "[{\"headIconUrl\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIZibJCINEz4Nym2gWDoKvJbMC0ePb4YzUd3oKiacouWI6ttMdJBrS9ZF4cGwOMAbdoT5FP5M4Sh8Tg/132\",\"userName\":\"芝麻君\"}]";

        model.addAttribute("userInfoList",userInfoOut);

        return "memberCenter";
    }

}
