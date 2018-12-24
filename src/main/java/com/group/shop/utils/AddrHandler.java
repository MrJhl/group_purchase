package com.group.shop.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddrHandler {

    private static String seperator = System.getProperty("file.separator");

    private static String uploadImgWinUrl;

    private static String uploadImgLinuxUrl;

    @Value("${win.file.upload.image}")
    public void setUploadImgWinUrl(String uploadImgWinUrl) {
        AddrHandler.uploadImgWinUrl = uploadImgWinUrl;
    }

    @Value("${linux.file.upload.image}")
    public void setUploadImgLinuxUrl(String uploadImgLinuxUrl) {
        AddrHandler.uploadImgLinuxUrl = uploadImgLinuxUrl;
    }

    /**
     * 获取图片文件的绝对路径
     * @return
     */
    public static String getImgBasePath(){
        //获取系统名
        String os = System.getProperty("os.name");
        String basePath = "";
        //如若是win系统，则：
        if(os.toLowerCase().startsWith("win")){
            basePath = uploadImgWinUrl;
        }else{
            basePath = uploadImgLinuxUrl;
        }
        //根据不同的系统"/"的方向也不同，所以需要根据系统来替换
        basePath = basePath.replace("/", seperator);
        return basePath;
    }
}
