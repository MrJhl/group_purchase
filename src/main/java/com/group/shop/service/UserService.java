package com.group.shop.service;

import com.group.shop.entity.User;

import java.util.Map;

public interface UserService {

    /**
     * 小程序用户登陆
     * @param user
     * @return
     */
    Map<String,Object> wechatLogin(User user);
}
