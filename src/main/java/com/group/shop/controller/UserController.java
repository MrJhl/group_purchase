package com.group.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.group.shop.common.CodeMsg;
import com.group.shop.common.Constant;
import com.group.shop.common.Result;
import com.group.shop.config.wxconfig.WxPayProperties;
import com.group.shop.entity.User;
import com.group.shop.service.UserService;
import com.group.shop.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WxPayProperties properties;

    @Autowired
    private UserService userService;

    /**
     * 微信登录
     * @param reqbody
     * @return
     */
    @PostMapping(value = "/code",produces = {"application/json;charset=UTF-8"})
    public Result<Object> wechatLogin(@RequestBody Map<String,String> reqbody){
        String code = reqbody.get("code");

        String url = Constant.CODE_SESSION + "?appid=" + properties.getAppId() + "&secret=" + properties.getSecret()
                + "&js_code=" + code + "&grant_type=authorization_code";
        JSONObject jsonObject = (JSONObject) HttpClientUtil.httpGet(url);
        if(jsonObject.get("errcode") == null){
            return Result.success(userService.wechatLogin(jsonObject));
        }else{
            return Result.errorMsg("请求失败！");
        }
    }

    /**
     * 校验token
     * @param reqbody
     * @return
     */
    @PostMapping(value = "/verifyToken",produces = {"application/json;charset=UTF-8"})
    public Result<Boolean> verifyToken(@RequestBody Map<String,String> reqbody){
        String token = reqbody.get("token");
        return Result.success(userService.verifyToken(token));
    }
    
    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping(value = "regist",produces = {"application/json;charset=UTF-8"})
    public Result<Object> registUser(@RequestBody User user){
    	int flag = userService.insertUser(user);
    	if(flag == 1) {
    		return Result.success(true);
    	}else if(flag == -1){
    		return Result.errorMsg("存在该用户");
    	}else {
    		return Result.error(CodeMsg.FAIL);
    	}
    }
}
