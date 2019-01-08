package com.group.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.group.shop.common.Result;
import com.group.shop.entity.User;

import java.util.Map;

public interface UserService {

    /**
     * 小程序用户登陆
     * @param user
     * @return
     */
    String wechatLogin(JSONObject object);

    /**
     * 校验token是否有效
     * @param token
     * @return
     */
    Boolean verifyToken(String token);
    
    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(User user);
}
