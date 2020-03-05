package com.example.onestoponestreet.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class HttpPostRequest {



    private static CloseableHttpClient httpClient = null;

    private static HttpPost httpPost = null;

    //        响应模型
    private static CloseableHttpResponse response = null;


    public InputStream doPost(String url , Map<String , Object> data){

//        获取http客户端
        httpClient = HttpClientBuilder.create().build();


//      创建post请求
        httpPost = new HttpPost(url);

        httpPost.setHeader("Content-Type","application/json;charset=utf8");

        httpPost.addHeader("HTTP.CONTENT_TYP","application/json");
//        httpPost.setEntity();

        String body = JSON.toJSONString(data);

        System.out.println(body);


        StringEntity entity = null;



        try {
            entity = new StringEntity(body);
            entity.setContentType("text/plain");
            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);

            System.out.println(response.getEntity());

            InputStream inputStream = response.getEntity().getContent();

            return inputStream;



        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {

        }

        return null;


    }


}

