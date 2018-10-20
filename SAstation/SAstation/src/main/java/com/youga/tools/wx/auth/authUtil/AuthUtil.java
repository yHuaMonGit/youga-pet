package com.youga.tools.wx.auth.authUtil;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class AuthUtil {

    public static final String APPID = "wx9d42eee607f08bf6";
    public static final String APPSECRET = "e9e2a49966784bc0816ae6650026af2f";

    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject = null;
        DefaultHttpClient clent  = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = clent.execute(httpGet);
        HttpEntity entity = response.getEntity();

        if (entity != null)
        {
            String result = EntityUtils.toString(entity,"UTF-8");
            jsonObject = JSONObject.fromObject(result);
        }

        httpGet.releaseConnection();


        return jsonObject;
    }

}
