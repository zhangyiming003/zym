package com.example.onestoponestreet.util;


import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.springframework.scheduling.annotation.Async;

import java.io.IOException;

public class HttpGetRequest {

    private static CloseableHttpClient httpClient = null;


    private static HttpGet httpGet = null;
    //        响应模型
    private static CloseableHttpResponse response = null;

    private String doGetContent = null;



    @Async
    public String  doGet(String url ,StringBuffer buffer){

//        获取http客户端(创建http客户端)

        httpClient = HttpClientBuilder.create().build();

        // 创建get请求
        httpGet = new HttpGet(url+"?"+buffer);


        try{

            //由客户端发送请求
            response = httpClient.execute(httpGet);

            //从响应模型中获取响应体
            HttpEntity responseEntity = response.getEntity();

//            System.out.println("响应状态："+response.getStatusLine());
            try {

                if (responseEntity != null){
//                System.out.println("响应内容长度："+responseEntity.getContentLength());
//                System.out.println("响应体内容："+EntityUtils.toString(responseEntity));
                    doGetContent = EntityUtils.toString(responseEntity);

                }

            }finally {
                EntityUtils.consume(responseEntity);
                response.close();
            }




        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {

            try {
                httpClient.close();
            }catch (IOException it){
                it.printStackTrace();
            }

        }

        return doGetContent;



    }
}
