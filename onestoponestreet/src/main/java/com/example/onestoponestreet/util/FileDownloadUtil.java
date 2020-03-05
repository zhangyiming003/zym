package com.example.onestoponestreet.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.springframework.scheduling.annotation.Async;

public class FileDownloadUtil {
 /**
  7      * 下载文件---返回下载后的文件存储路径
  8      *
  9      * @param url 文件路径
  10      * @param dir 目标存储目录
  11      * @param fileName 存储文件名
  12      * @return
  13      */

 private String lastPath ;

    public String getLastPath() {
        return lastPath;
    }

    public void setLastPath(String lastPath) {
        this.lastPath = lastPath;
    }

    @Async
     public Integer downloadHttpUrl(String url) throws  Exception {

        int stateInt = 1;

        try {

            File file1 = new File("/Users/xuchangkai/Desktop/upload/picture/"+new SimpleDateFormat("yyyy/MM/dd/").format(new Date()));

            //目标存储目录
            String dir  = file1.getAbsolutePath();

            //存储文件名
            String fileName = new Date().getTime()+".png";

            URL httpurl = new URL(url);

            File dirfile = new File(dir);

            if (!dirfile.exists()) {

                dirfile.mkdirs();

            }

            lastPath = dir+"/"+fileName;


                FileUtils.copyURLToFile(httpurl, new File(dir+"/"+fileName));

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return 0;
            } catch (IOException e) {
                e.printStackTrace();
                return 2;
            }
        return stateInt;
    }
 }
