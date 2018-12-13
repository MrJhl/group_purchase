package com.group.shop.utils;

import com.alibaba.fastjson.JSON;
import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Slf4j
public class HttpClientUtil {

    public static Object httpGet(String url){
        CloseableHttpClient httpCilent = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)   //设置连接超时时间
                .setConnectionRequestTimeout(5000) // 设置请求超时时间
                .setSocketTimeout(5000)
                .setRedirectsEnabled(true)//默认允许自动重定向
                .build();

        HttpGet get = new HttpGet(url);
        get.setConfig(requestConfig);
        try{
            HttpResponse httpResponse = httpCilent.execute(get);
            if(httpResponse.getStatusLine().getStatusCode() == 200) {
                String resultStr = EntityUtils.toString(httpResponse.getEntity());
                return JSON.parseObject(resultStr);
            }else{
                return null;
            }
        }catch (IOException e){
            log.error("get请求异常："+e.getMessage());
            e.printStackTrace();
            return null;
        }finally {
            try {
                httpCilent.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
