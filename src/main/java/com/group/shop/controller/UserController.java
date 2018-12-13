package com.group.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.group.shop.common.Constant;
import com.group.shop.common.Result;
import com.group.shop.config.wxconfig.WxPayProperties;
import com.group.shop.entity.User;
import com.group.shop.service.UserService;
import com.group.shop.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WxPayProperties properties;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/code")
    public Result<Object> wechatLogin(@RequestParam("code")String code){

        String url = Constant.CODE_SESSION + "?appid=" + properties.getAppId() + "&secret=" + properties.getSecret()
                + "&js_code=" + code + "&grant_type=authorization_code";
        JSONObject jsonObject = (JSONObject) HttpClientUtil.httpGet(url);
        if(jsonObject.get("errcode") == null){
            return Result.success(jsonObject);
        }else{
            return Result.errorMsg("请求失败！");
        }

    }
}
