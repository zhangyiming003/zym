package com.example.onestoponestreet.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
//import com.example.importexcel.model.Brandinfo;
//import com.example.importexcel.services.BrandInfoServices;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 *
 * 不在Controller里面使用调取service里面的方法
 *
 */

@Component
public class SwitchJson {

//    @Autowired
//    private BrandInfoServices brandInfoServices;

    private static SwitchJson switchJson;

    public static JSONArray TransformJSON(String data){

        JSONObject datajson = JSONObject.parseObject(data);

        String datas = datajson.getString("data");

        JSONObject brandListjson = JSONObject.parseObject(datas);

        String brandList = brandListjson.getString("brandList");

        JSONArray dataArray = JSONArray.parseArray(brandList);


        return dataArray;
    }

    public static  StringBuffer stringBuffer(List list){

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0 ; i < list.size();i++){

            stringBuffer.append(list.get(i));
            stringBuffer.append("/");


        }

        System.out.println(stringBuffer);


        return stringBuffer;
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化...");
        switchJson = this;
    }

//    @Async
//    public void InsertBrandInfo(JSONArray dataArray){
//
//
//        for (int i = 0 ; i < dataArray.size();i++){
//
//            Brandinfo brandinfo = new Brandinfo();
//
//            brandinfo.setCsggqh((String) dataArray.getJSONObject(i).get("csggqh"));
//            brandinfo.setCsggrq((String) dataArray.getJSONObject(i).get("csggrq"));
//            brandinfo.setDlrmc((String) dataArray.getJSONObject(i).get("dlrmc"));
//            brandinfo.setGjfl((String) dataArray.getJSONObject(i).get("gjfl"));
//            brandinfo.setNewProcess((String) dataArray.getJSONObject(i).get("newProcess"));
//            brandinfo.setPicMiddle((String) dataArray.getJSONObject(i).get("picMiddle"));
//            brandinfo.setPicSmall((String) dataArray.getJSONObject(i).get("picSmall"));
//            brandinfo.setQunzuCodes((String) dataArray.getJSONObject(i).get("qunzuCodes"));
//            brandinfo.setSbwzLs((String) dataArray.getJSONObject(i).get("sbwzLs"));
//            brandinfo.setSqrmcZw((String) dataArray.getJSONObject(i).get("sqrmcZw"));
//            brandinfo.setSqrq((String) dataArray.getJSONObject(i).get("sqrq"));
//            brandinfo.setZcggqh((String) dataArray.getJSONObject(i).get("zcggqh"));
//            brandinfo.setZch((String) dataArray.getJSONObject(i).get("zch"));
//            brandinfo.setZchEn((String) dataArray.getJSONObject(i).get("zchEn"));
//            brandinfo.setZyqqx((String) dataArray.getJSONObject(i).get("zyqqx"));
//            brandinfo.setZyqqxStart((String) dataArray.getJSONObject(i).get("zyqqxStart"));
//
//
//
//            try {
//
//                Future<Integer> integerFuture =  switchJson.brandInfoServices.InsertBrandInfo(brandinfo);
//
//            }catch (InterruptedException t){
//                t.printStackTrace();
//
//            }catch (ExecutionException e){
//                e.printStackTrace();
//            }finally {
//
//            }
//
//        }
//
//    }



}
