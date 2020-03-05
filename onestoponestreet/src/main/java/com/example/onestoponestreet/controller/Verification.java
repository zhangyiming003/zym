package com.example.onestoponestreet.controller;

import com.example.onestoponestreet.util.HttpGetRequest;
import com.google.gson.Gson;

import org.springframework.web.bind.annotation.*;


/**
 * @author xuxiaohei
 * @version 1.0
 * @date 2020-03-01 02:55
 * 小程序需要的验证
 */

@RestController
public class Verification {

    /**
     * @api {get} /GetSessionKey
     * @apiDescription 获取openid和sessio_key
     * @apiParam {String} js_code 登录时获取的 code
     * @apiParamExample {json} Request-Example:
            *  {
     * "js_code":"033w4jbP1UqJl81cznbP1SikbP1w4jbT",
                * }
     * @apiGroup 获取凭证
     * @apiError userNotFound  The <code>id</code>
     * @apiSampleRequest http://localhost:8081/GetSessionKey
     */

    @GetMapping("GetSessionKey")
    @ResponseBody
    @CrossOrigin
    public String GetSessionKey(
            @RequestParam() String js_code
    ){

        String url = "https://api.weixin.qq.com/sns/jscode2session";

        String appid = "wx7eec257e54a584f3";

        String secret = "7b77cf23bf288ffb4734d3a1821c26e2";


        StringBuffer buffer = new StringBuffer();
        buffer.append("appid="+appid);
        buffer.append("&");
        buffer.append("secret="+secret);
        buffer.append("&");
        buffer.append("js_code="+js_code);
        buffer.append("&");
        buffer.append("grant_type=authorization_code");

        HttpGetRequest httpGetRequest = new HttpGetRequest();
        String http = httpGetRequest.doGet(url,buffer);

        Gson gson = new Gson();

        String json = gson.toJson(http);
        System.out.println(http);




        return json;
    }

}
